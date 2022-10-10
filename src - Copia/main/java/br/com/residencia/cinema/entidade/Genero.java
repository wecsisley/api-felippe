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
@Table(name = "genero")
public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idgenero")
	private Integer idGenero;

	@Column(name = "nomegenero")
	private String nomeGenero;

	@OneToMany(mappedBy = "genero")
	private Set<Filme> filmes;

	public Integer getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public Set<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(Set<Filme> filmes) {
		this.filmes = filmes;
	}

	public String getNomeGenero() {
		return nomeGenero;
	}

	public void setNomeGenero(String nomeGenero) {
		this.nomeGenero = nomeGenero;
	}



	
	
}
