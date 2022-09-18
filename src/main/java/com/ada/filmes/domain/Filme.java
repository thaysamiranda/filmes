package com.ada.filmes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String genero;

    @NotBlank
    private String ano;

    @OneToMany
    private List<Ator> listaDeAtores;

}




