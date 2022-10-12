package br.com.residencia.cinema.services;

import br.com.residencia.cinema.models.DiretorModel;
import br.com.residencia.cinema.repositorys.DiretorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiretorService {

    final DiretorRepository diretorRepository;

    public DiretorService(DiretorRepository diretorRepository) {
        this.diretorRepository = diretorRepository;
    }

    @Transactional
    public DiretorModel save(DiretorModel diretorModel) {
        return diretorRepository.save(diretorModel);
    }

    public boolean existsByNomeDiretor(String nomeDiretor) {
        return diretorRepository.existsByNomeDiretor(nomeDiretor);
    }

    public Page<DiretorModel> findAll(Pageable pageable) {
        return diretorRepository.findAll(pageable);
    }

    public Optional<DiretorModel> findById(UUID id) {
        return diretorRepository.findById(id);
    }

    @Transactional
    public void delete(DiretorModel diretorModel) {
        diretorRepository.delete(diretorModel);
    }
}
