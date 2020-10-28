	package com.thiagowill.videoteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagowill.videoteca.domain.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer>{
	List<Filme> findByTituloIgnoreCaseContaining(String titulo);
}


