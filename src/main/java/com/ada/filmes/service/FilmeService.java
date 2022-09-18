package com.ada.filmes.service;

import com.ada.filmes.domain.Filme;
import com.ada.filmes.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public void adicionaFilme(Filme filme) {
        filmeRepository.save(filme);
    }
    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public Filme buscaFilmePorNome(String nome) {
        return filmeRepository.buscaFilmePorNome(nome);
    }

    public List<Filme> buscaFilmePorGenero(String genero) {
        return filmeRepository.buscaFilmePorGenero(genero);
    }

    public List<Filme> buscaFilmePorAnoDeLancamento(String ano) {
        return filmeRepository.buscaFilmePorAnoDeLancamento(ano);
    }

    public List<Filme> buscaFilmePorAtor(String ator) {
        return filmeRepository.buscaFilmePorAtor(ator);
    }

    public Filme removeFilme(String nome) {
        Filme filme = this.buscaFilmePorNome(nome);
        filmeRepository.delete(filme);
        return filme;
    }
}
