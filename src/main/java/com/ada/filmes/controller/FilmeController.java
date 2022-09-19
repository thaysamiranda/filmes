package com.ada.filmes.controller;

import com.ada.filmes.domain.Filme;
import com.ada.filmes.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@AllArgsConstructor
public class FilmeController {
    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<Filme> adicionaFilme(@RequestBody Filme filme){
        filmeService.adicionaFilme(filme);
        return new ResponseEntity<>(filme, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes(){
        List<Filme> listaFilmes = filmeService.listarFilmes();
        return new ResponseEntity<>(listaFilmes, HttpStatus.OK);
    }
//
//    @GetMapping("/nome")
//    public ResponseEntity<Filme> buscaFilmePorNome(@RequestParam String nome){
//        return new ResponseEntity<>(filmeService.buscaFilmePorNome(nome), HttpStatus.OK);
//    }
//
//    @GetMapping("/genero")
//    public ResponseEntity<List<Filme>> buscaFilmePorGenero(@RequestParam String genero){
//        return new ResponseEntity<>(filmeService.buscaFilmePorGenero(genero), HttpStatus.OK);
//    }
//
//    @GetMapping("/ano")
//    public ResponseEntity<List<Filme>> buscaFilmePorAnoDeLancamento(@RequestParam String ano){
//        return new ResponseEntity<>(filmeService.buscaFilmePorAnoDeLancamento(ano), HttpStatus.OK);
//    }
//
//    @GetMapping("/ator")
//    public ResponseEntity<List<Filme>> buscaFilmePorAtor(@RequestParam String ator){
//        return new ResponseEntity<>(filmeService.buscaFilmePorAtor(ator), HttpStatus.OK);
//    }
//
//   @DeleteMapping("/nome")
//    public ResponseEntity<Filme> removerFilme(@RequestParam String nome) {
//        Filme filme = filmeService.removeFilme(nome);
//        return new ResponseEntity<>(filme, HttpStatus.OK);
//    }
}

