package com.thiagowill.videoteca.resources;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thiagowill.videoteca.domain.Filme;
import com.thiagowill.videoteca.services.FilmeService;

@Controller

public class FilmeControler{
	
	
	@Autowired
	private FilmeService service;
	
	
	

	
	@RequestMapping(value = "/filmes", method = RequestMethod.GET)
	public ModelAndView buscar() {
		ModelAndView mv = new ModelAndView("Filmes");
		List<Filme> filmes = service.buscarTodos();
		mv.addObject("Filmes",filmes);
		return mv;
	}
	
	@RequestMapping(value = "/filme/{id}", method = RequestMethod.GET)
	public ModelAndView procurarPorId(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("filmeDetails");
		Filme filme = service.buscar(id);
		mv.addObject("filme",filme);
		return mv;
	}
	
	@RequestMapping(value = "/Remover/{id}", method = RequestMethod.GET)
	public String deletarFilme(@PathVariable(value = "id") int id, RedirectAttributes attributes) {
		service.delete(id);
		
		return "redirect:/filmes";
	}
	
	
	@RequestMapping(value = "/novofilme", method = RequestMethod.GET)
	public String getFormularioCadastro() {
		return "filmeForm";
	}
	
	@RequestMapping(value = "/novofilme", method = RequestMethod.POST)
	public String cadastrarFilme(@Valid Filme filme,@RequestParam("fileFilme") MultipartFile file, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("message", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/novofilme";
		}
		
		try {
			filme.setCapa(file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		service.save(filme);
		return "redirect:/filmes";
	}
	
	
	@RequestMapping(value = "/editarfilme/{id}", method = RequestMethod.GET)
	public ModelAndView formularioEditarFilme(@PathVariable("id") int id) {
		ModelAndView mv  = new ModelAndView("filmeEditar");
		Filme filme = service.buscar(id);
		mv.addObject("filme",filme);
		return mv;
	}
	
	@RequestMapping(value = "/editarfilme/{id}", method = RequestMethod.POST)
	public String editarFilme(@Valid Filme filme,BindingResult result, RedirectAttributes attributes ) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("message", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/editarfilme";
		}
		service.save(filme);
		return "redirect:/filmes";
	}
	
	
	@RequestMapping(value = "/filmes", method = RequestMethod.POST)
	public ModelAndView buscaPorNome( String titulo) {
		ModelAndView mv = new ModelAndView("Filmes");
		List<Filme>f = service.procurarPorTitulo(titulo);
		mv.addObject("Filmes",f);
		return mv;
	}
	
	@GetMapping("/imagem/{idImg}")
	@ResponseBody
	public byte[] imagemCapa(@PathVariable("idImg")  int id) {
		Filme filme = service.buscar(id);
		return filme.getCapa();
	}
	
}
