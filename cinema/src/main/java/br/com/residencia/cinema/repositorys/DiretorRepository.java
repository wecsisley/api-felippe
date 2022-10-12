package br.com.residencia.cinema.repositorys;

import br.com.residencia.cinema.models.DiretorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiretorRepository extends JpaRepository<DiretorModel, UUID> {

    boolean existsByNomeDiretor(String nomeDiretor);
}
