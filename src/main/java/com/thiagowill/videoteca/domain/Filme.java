package com.thiagowill.videoteca.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;



@Entity
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@NotBlank
	private String titulo;
	private String direcao;
	private String protagonista;
	private String genero;
	private String classIndic;
	private String tempo;
	private String ano;
	@Lob
	private byte[] capa;
	@Column(name = "linkVideo")
	private String idLinkYoutube;
	
	
	User user;
	
	public Filme() {
		
	}

	public Filme(int id, @NotBlank String titulo, String direcao, String protagonista, String genero, String classIndic,
			String tempo, String ano, byte[] capa) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.direcao = direcao;
		this.protagonista = protagonista;
		this.genero = genero;
		this.classIndic = classIndic;
		this.tempo = tempo;
		this.ano = ano;
		this.capa = capa;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getClassIndic() {
		return classIndic;
	}

	public void setClassIndic(String classIndic) {
		this.classIndic = classIndic;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}

	public String getIdLinkYoutube() {
		return idLinkYoutube;
	}

	public void setIdLinkYoutube(String idLinkYoutube) {
		this.idLinkYoutube = idLinkYoutube;
	}
	
	
	
	
}
