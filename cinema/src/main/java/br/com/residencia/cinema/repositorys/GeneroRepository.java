package br.com.residencia.cinema.repositorys;

import br.com.residencia.cinema.models.GeneroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GeneroRepository extends JpaRepository<GeneroModel, UUID> {

}
