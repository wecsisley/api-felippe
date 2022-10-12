package br.com.residencia.cinema.dtos;

import br.com.residencia.cinema.models.FilmeModel;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class DiretorDTO {

    @NotBlank
    private String nomeDiretor;

    private Set<FilmeModel> filmes;

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public Set<FilmeModel> getFilmes() {
        return filmes;
    }

    public void setFilmes(Set<FilmeModel> filmes) {
        this.filmes = filmes;
    }
}
