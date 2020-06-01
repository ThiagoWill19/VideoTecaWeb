package com.thiagowill.videoteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagowill.videoteca.domain.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer>{
}
