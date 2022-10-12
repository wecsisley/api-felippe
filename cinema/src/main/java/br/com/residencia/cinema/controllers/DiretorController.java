package br.com.residencia.cinema.controllers;

import br.com.residencia.cinema.dtos.DiretorDTO;
import br.com.residencia.cinema.models.DiretorModel;
import br.com.residencia.cinema.services.DiretorService;
import br.com.residencia.cinema.validadors.DiretorValidador;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/diretor")
public class DiretorController {

    final DiretorService diretorService;
    final DiretorValidador diretorValidador;

    public DiretorController(DiretorService diretorService) {
        this.diretorService = diretorService;
        this.diretorValidador = new DiretorValidador();
    }

    @PostMapping
    public ResponseEntity<Object> saveDiretor(@RequestBody @Valid DiretorDTO diretorDTO) {
        if(diretorValidador.validaDiretorJaCadastradoPorNome(diretorService,diretorDTO.getNomeDiretor())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Conflito: O diretor " + diretorDTO.getNomeDiretor() + " Já foi cadastrado !");
        }
        var diretorModel = new DiretorModel();
        BeanUtils.copyProperties(diretorDTO, diretorModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(diretorService.save(diretorModel));
    }

    @GetMapping
    public ResponseEntity<Page<DiretorModel>> getAllDiretor(
            @PageableDefault(page = 0, size = 10, sort = "nomeDiretor", direction = Sort.Direction.ASC)
            Pageable pageable) {

        return ResponseEntity.status(HttpStatus.OK).body(diretorService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDiretorById(@PathVariable(value = "id") UUID id) {
        Optional<DiretorModel> diretorModelOptional = diretorService.findById(id);
        if(diretorValidador.validaDiretorNaoEncontrado(diretorModelOptional)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado nenhum diretor com o id: " + id);
        }

        return ResponseEntity.status(HttpStatus.OK).body(diretorModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDiretorById(@PathVariable(value = "id") UUID id) {
        Optional<DiretorModel> diretorModelOptional = diretorService.findById(id);
        if(diretorValidador.validaDiretorNaoEncontrado(diretorModelOptional)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado nenhum diretor com o id: " + id);
        }

        diretorService.delete(diretorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK)
                .body("Diretor " + diretorModelOptional.get().getNomeDiretor() + " deletado com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDiretorById(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid DiretorDTO diretorDTO) {

        Optional<DiretorModel> diretorModelOptional = diretorService.findById(id);
        if(diretorValidador.validaDiretorNaoEncontrado(diretorModelOptional)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado nenhum diretor com o id: " + id);
        }

        var diretorModel = new DiretorModel();
        BeanUtils.copyProperties(diretorDTO, diretorModel);
        diretorModel.setId(diretorModelOptional.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(diretorService.save(diretorModel));
    }
}
