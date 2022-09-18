package com.ada.filmes.controller;

import com.ada.filmes.domain.Ator;
import com.ada.filmes.service.AtorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
@AllArgsConstructor
public class AtorController {

    private final AtorService AtorService;

    @PostMapping
    public ResponseEntity<Ator> adicionaAtor(@RequestBody Ator Ator) {
        AtorService.adicionaAtor(Ator);
        return new ResponseEntity<>(Ator, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ator> buscaAtorPorId(@PathVariable Long id) {
        Ator Ator = AtorService.buscaPorId(id);
        return new ResponseEntity<>(Ator, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Ator> atualizaAtor(@RequestBody Ator novoAtor) {
        Ator Ator = AtorService.atualizaAtor(novoAtor);
        return new ResponseEntity<>(Ator, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ator>> listarAtors() {
        List<Ator> listaAtores = AtorService.listarAtores();
        return new ResponseEntity<>(listaAtores, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ator> removerAtor(@PathVariable Long id) {
        Ator Ator = AtorService.removeAtor(id);
        return new ResponseEntity<>(Ator, HttpStatus.OK);
    }
}

