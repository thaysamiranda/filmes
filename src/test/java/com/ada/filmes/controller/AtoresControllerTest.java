package com.ada.filmes.controller;

import com.ada.filmes.domain.Ator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AtoresControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testInserePorApi() {
        Ator ator = Ator.builder()
                .ator("Sam Worthington")
                .ator("Zoë Saldaña")
                .ator("Sigourney Weaver")
                .build();


        ResponseEntity<Ator> filmeResposta = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/atores",
                        ator, Ator.class);

        Assertions.assertEquals(HttpStatus.CREATED, filmeResposta.getStatusCode());
        Assertions.assertEquals("Sam Worthington", filmeResposta.getBody().getAtor());

    }
}
