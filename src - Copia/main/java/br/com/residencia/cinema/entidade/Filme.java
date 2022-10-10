package br.com.residencia.cinema.entidade;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_Filme")
	private Integer idFilme;
	
	@Column(name = "nomebr")
	private String nomeBr;
	
	@Column(name = "nomeen")
	private String nomeEn;
	
	@Column(name = "anolancamento")
	private Instant anoLancamento;
	
	@Column(name = "sinopse")
	private String sinopse;
	
	@ManyToOne
	@JoinColumn(name = "iddiretor", referencedColumnName = "iddiretor")
	private Diretor diretor;
	
	@ManyToOne
	@JoinColumn(name = "idgenero", referencedColumnName = "idgenero")
	private Genero genero;

	public Integer getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
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

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
