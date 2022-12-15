package com.br.fsc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fsc.DTO.PersonDto;
import com.br.fsc.service.PersonService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "End point do CRUD de Person")
public class PersonController {
	
	
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<PersonDto> criarPessoa(PersonDto personDto){
		return new ResponseEntity<>(personService.create(personDto),HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity <List<PersonDto>> obterTodos(){
		return new ResponseEntity<>(personService.readAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonDto> obterPorId(Long id){
		return new ResponseEntity<>(personService.readId(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PersonDto> atualizar(PersonDto personDto, Long id){
		return new ResponseEntity<>(personService.update(personDto, id), HttpStatus.UPGRADE_REQUIRED);
		
	}
	
	@DeleteMapping
	public ResponseEntity<HttpStatus> deletar(){
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
