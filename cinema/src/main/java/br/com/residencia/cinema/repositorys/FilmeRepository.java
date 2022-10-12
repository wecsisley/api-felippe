package br.com.residencia.cinema.repositorys;

import br.com.residencia.cinema.models.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilmeRepository extends JpaRepository<FilmeModel, UUID> {
}
