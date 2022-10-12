package br.com.residencia.cinema.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "TB_FILME")
public class GeneroModel implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nomeGenero;
    @OneToMany(mappedBy = "genero")
    private Set<FilmeModel> filmes;

    public Integer getIdGenero() {
        return id;
    }

    public void setIdGenero(Integer idGenero) {
        this.id = idGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public Set<FilmeModel> getFilmes() {
        return filmes;
    }

    public void setFilmes(Set<FilmeModel> filmes) {
        this.filmes = filmes;
    }
}
