package com.ada.filmes.repository;

import com.ada.filmes.domain.Ator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtorRepository extends JpaRepository <Ator, Long> {
}
