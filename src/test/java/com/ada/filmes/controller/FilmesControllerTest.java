package com.ada.filmes.controller;

import com.ada.filmes.domain.Ator;
import com.ada.filmes.domain.Filme;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmesControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    private List<Ator> ator;

    @Test
    public void testAdicionaFilme () {
        List<String> list = List.of("aaa","bbb","ccc");
        System.out.println(list);
        Filme filme = Filme.builder()
               .nome("Avatar")
               .genero("Aventura")
               .ano("2009")
               .listaDeAtores(List)
               .build();

       ResponseEntity<Filme> filmeResposta = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/filmes",
                        filme, Filme.class);

        Assertions.assertEquals(HttpStatus.CREATED, filmeResposta.getStatusCode());
        Assertions.assertEquals("Avatar", filmeResposta.getBody().getNome());
        Assertions.assertEquals("Aventura", filmeResposta.getBody().getGenero());
        Assertions.assertEquals("2009", filmeResposta.getBody().getAno());
        Assertions.assertEquals("aaa","bbb","ccc", filmeResposta.getBody().getListaDeAtores());
    }

}
