package br.com.residencia.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.cinema.entidade.Diretor;
import br.com.residencia.cinema.service.DiretorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/diretor")
@Api(value = "API REST de Diretor")
@CrossOrigin(origins = "*")
public class DiretorController {
	@Autowired
	DiretorService diretorService;
	
	@GetMapping
	@ApiOperation(value = "Retorna uma lista de diretores")
	public ResponseEntity<List<Diretor>> getAllDiretors(){
		return new ResponseEntity<>(diretorService.getAllDiretores(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}") 
	@ApiOperation(value = "Retorna um diretor por id")
	public ResponseEntity<Diretor> getDiretorById(@PathVariable Integer id){
		return new ResponseEntity<>(diretorService.getDiretorById(id), HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value = "Salva um diretor")
	public ResponseEntity<Diretor> saveDiretor(@RequestBody Diretor diretor) {
		return new ResponseEntity<>(diretorService.saveDiretor(diretor), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um diretor")
	public ResponseEntity<Diretor>updateDiretor(@RequestBody Diretor diretor,@PathVariable Integer id){
		return new ResponseEntity<> (diretorService.updateDiretor(diretor,id),
				HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um diretor")
	public ResponseEntity<Diretor> deleteDiretor(@PathVariable Integer id) {
		Diretor diretor = diretorService.getDiretorById(id);
		if(null == diretor)
			return new ResponseEntity<>(diretor,
					HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(diretorService.deleteDiretor(id),
					HttpStatus.OK);
	}
}