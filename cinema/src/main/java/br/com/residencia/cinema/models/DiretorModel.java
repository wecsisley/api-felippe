package br.com.residencia.cinema.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_DIRETOR")
public class DiretorModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String nomeDiretor;
    @OneToMany(mappedBy = "diretor")
    private Set<FilmeModel> filmes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
