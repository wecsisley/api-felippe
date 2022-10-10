package br.com.residencia.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import br.com.residencia.cinema.entidade.Filme;
import br.com.residencia.cinema.repository.FilmeRepository;

@Service
public class FilmeService {
	@Autowired
	FilmeRepository filmeRepository;
	
	
	public List<Filme> getAllFilmes(){
		return filmeRepository.findAll();
	}
	
	public Filme getFilmeById(Integer id) {
		return filmeRepository.findById(id).orElse(null);
	}
	
	public Filme saveFilme(Filme filme) {
		return filmeRepository.save(filme);
	}
	
	public Filme updateFilme(Filme filme, Integer id) {
		Filme filmeExistenteNoBanco = getFilmeById(id);
		
		filmeExistenteNoBanco.setNomeBr(filme.getNomeBr());
		filmeExistenteNoBanco.setNomeEn(filme.getNomeEn());
		filmeExistenteNoBanco.setAnoLancamento(filme.getAnoLancamento());
		filmeExistenteNoBanco.setSinopse(filme.getSinopse());
		
		return filmeRepository.save(filmeExistenteNoBanco);
		
	}
	
	public Filme deleteFilme (Integer id) {
		filmeRepository.deleteById(id);
		return getFilmeById(id);
	}
}
