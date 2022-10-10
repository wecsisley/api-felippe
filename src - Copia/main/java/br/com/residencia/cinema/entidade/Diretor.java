package br.com.residencia.cinema.entidade;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "diretor")
public class Diretor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddiretor")
	private Integer idDiretor;

	@Column(name = "nomediretor")
	private String nomeDiretor;

	@OneToMany(mappedBy = "diretor")
	private Set<Filme> filmes;

	public Integer getIdDiretor() {
		return idDiretor;
	}

	public void setIdDiretor(Integer idDiretor) {
		this.idDiretor = idDiretor;
	}

	public String getNomeDiretor() {
		return nomeDiretor;
	}

	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
	}

	public Set<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(Set<Filme> filmes) {
		this.filmes = filmes;
	}

	
	
	
	
}

