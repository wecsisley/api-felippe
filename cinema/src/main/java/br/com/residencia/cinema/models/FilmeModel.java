package br.com.residencia.cinema.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "TB_FILME")
public class FilmeModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String nomeBr;
    @Column(nullable = false, unique = true)
    private String nomeEn;
    @Column(nullable = false, unique = true)
    private Instant anoLancamento;
    @Column(nullable = false, unique = true)
    private String sinopse;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private DiretorModel diretor;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private GeneroModel genero;

    public Integer getIdFilme() {
        return id;
    }

    public void setIdFilme(Integer idFilme) {
        this.id = idFilme;
    }

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
