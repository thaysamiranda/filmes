package com.ada.filmes.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {

    private WebDriver webDriver;

    @BeforeAll
    public static void setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @Test
    public void listFilmes() {
        webDriver = new ChromeDriver();

        webDriver.get("http://localhost:8080/home");

        String titulo = webDriver.getTitle();

        Assertions.assertEquals("Filmes", titulo);

        WebElement nome = webDriver.findElement(By.name("nome"));
        String valorNome = nome.getText();

        WebElement genero = webDriver.findElement(By.name("genero"));
        String valorGenero = genero.getText();

        WebElement ano = webDriver.findElement(By.name("ano"));
        String valorAno = ano.getText();

        Assertions.assertEquals("Meu Filme", valorNome);
        Assertions.assertEquals("Suspense", valorGenero);
        Assertions.assertEquals("2020", valorAno);


        webDriver.quit();
    }

    @Test
    public void insereFilme() {
        webDriver = new ChromeDriver();

        webDriver.get("http://localhost:8080/create");

        WebElement nome = webDriver.findElement(By.name("nome"));
        nome.sendKeys("Meu Filme");
        WebElement genero = webDriver.findElement(By.name("genero"));
        genero.sendKeys("Suspense");
        WebElement ano = webDriver.findElement(By.name("ano"));
        ano.sendKeys("2020");

        WebElement submit = webDriver.findElement(By.id("submitButton"));
        submit.click();


        String titulo = webDriver.getTitle();
        Assertions.assertEquals("Filmes", titulo);

        WebElement nomeInserido = webDriver.findElement(By.name("nome"));
        WebElement generoInserida = webDriver.findElement(By.name("genero"));
        WebElement anoInserido = webDriver.findElement(By.name("ano"));

        Assertions.assertEquals("Meu Filme", nomeInserido.getText());
        Assertions.assertEquals("Suspense", generoInserida.getText());
        Assertions.assertEquals("2020", anoInserido.getText());

        webDriver.quit();
    }
}