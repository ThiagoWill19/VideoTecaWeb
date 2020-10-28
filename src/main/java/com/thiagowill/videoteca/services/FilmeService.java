package com.thiagowill.videoteca.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.thiagowill.videoteca.domain.Filme;
import com.thiagowill.videoteca.repositories.FilmeRepository;
import com.thiagowill.videoteca.services.exceptions.ObjectNotFoundException;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository fr;
	
	public Filme buscar(int id) {
		Optional<Filme>  obj = fr.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id +"  Tipo: " + Filme.class.getName()));
	}
	
	public List<Filme> buscarTodos(){
		List <Filme> lista = fr.findAll();
		return lista;
	}
	
	public void save(Filme filme) {
		fr.save(filme);
	}
	
	public void delete(int id) {
		fr.deleteById(id);
		
	}
	
	public List<Filme> procurarPorTitulo(String titulo) {
		return fr.findByTituloIgnoreCaseContaining(titulo);
	}
	
	
	
}
