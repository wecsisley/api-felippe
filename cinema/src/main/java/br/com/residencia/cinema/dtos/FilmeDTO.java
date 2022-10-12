package br.com.residencia.cinema.dtos;

import br.com.residencia.cinema.models.DiretorModel;
import br.com.residencia.cinema.models.GeneroModel;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

public class FilmeDTO {

    @NotBlank
    private String nomeBr;
    @NotBlank
    private String nomeEn;
    @NotBlank
    private Instant anoLancamento;
    @NotBlank
    private String sinopse;
    @NotBlank
    private DiretorModel diretor;
    @NotBlank
    private GeneroModel genero;

    public String getNomeBr() {
        return nomeBr;
    }

    public void setNomeBr(String nomeBr) {
        this.nomeBr = nomeBr;
    }

    public String getNomeEn() {
        return nomeEn;
    }

    public void setNomeEn(String nomeEn) {
        this.nomeEn = nomeEn;
    }

    public Instant getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Instant anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public DiretorModel getDiretor() {
        return diretor;
    }

    public void setDiretor(DiretorModel diretor) {
        this.diretor = diretor;
    }

    public GeneroModel getGenero() {
        return genero;
    }

    public void setGenero(GeneroModel genero) {
        this.genero = genero;
    }
}
