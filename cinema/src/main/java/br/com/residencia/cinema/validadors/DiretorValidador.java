package br.com.residencia.cinema.validadors;

import br.com.residencia.cinema.models.DiretorModel;
import br.com.residencia.cinema.services.DiretorService;

import java.util.Optional;

public class DiretorValidador {

    public boolean validaDiretorJaCadastradoPorNome(DiretorService diretorService, String nomeDiretor) {
        if(diretorService.existsByNomeDiretor(nomeDiretor)){
            return true;
        }
        return false;
    }

    public boolean validaDiretorNaoEncontrado(Optional<DiretorModel> diretorModelOptional) {
        if (!diretorModelOptional.isPresent()) {
            return true;
        }
        return false;
    }
}
