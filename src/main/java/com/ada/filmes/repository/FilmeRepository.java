package com.ada.filmes.repository;

import com.ada.filmes.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

   }

