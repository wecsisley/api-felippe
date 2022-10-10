package br.com.residencia.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.cinema.entidade.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer>{

}
