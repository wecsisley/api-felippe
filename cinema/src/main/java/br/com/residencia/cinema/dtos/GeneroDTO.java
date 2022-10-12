package br.com.residencia.cinema.dtos;

import br.com.residencia.cinema.models.FilmeModel;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class GeneroDTO {

    @NotBlank
    private String nomeGenero;
    @NotBlank
    private Set<FilmeModel> filmes;
}
