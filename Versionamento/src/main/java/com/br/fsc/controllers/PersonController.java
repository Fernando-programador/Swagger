package com.br.fsc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.br.fsc.DTO.BookDto;
import com.br.fsc.DTO.PersonDto;
import com.br.fsc.service.PersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


//@CrossOrigin
@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "End point do CRUD de Person")
public class PersonController {
	
	
	@Autowired
	private PersonService personService;
	
	@CrossOrigin(origins = {"localhost:8080", "https://ajeitandoseulado.com.br"})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "Create Person",
				description = "create new person",
				tags = {"person"},
				responses = {
						@ApiResponse(content = {
								@Content(
										mediaType = "application/json",
										array = @ArraySchema(
												schema =@Schema(
														implementation = PersonDto.class)
	))},
								description = "Sucess",
								responseCode = "200"),
	@ApiResponse(content = @Content, description = "Bad Request", responseCode = "400" ),
	@ApiResponse(content = @Content, description = "Unauthorized", responseCode = "401" ),
	@ApiResponse(content = @Content, description = "Internal Error", responseCode = "500" )})
	public ResponseEntity<PersonDto> criarPessoa(@RequestBody PersonDto personDto){
		return new ResponseEntity<>(personService.create(personDto),HttpStatus.CREATED);
		
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "FindByALL",
	description = "Object find id ALL",
	tags = {"Person"},
	responses = {
			@ApiResponse(content = {
					@Content(
							mediaType = "application/json",
							array = @ArraySchema(
									schema = @Schema(
											implementation = PersonDto.class)
))},
	description = "Sucess",
	responseCode = "200"),
@ApiResponse(content = @Content, description = "No Content", responseCode = "204"),
@ApiResponse(content = @Content, description = "Bad Request", responseCode = "400"),
@ApiResponse(content = @Content, description = "Unauthorized", responseCode = "401"),
@ApiResponse(content = @Content, description = "Not Found", responseCode = "404"),
@ApiResponse(content = @Content, description = "Internal Error", responseCode = "500")})
	public ResponseEntity <List<PersonDto>> obterTodos(){
		return new ResponseEntity<>(personService.readAll(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "localhost:8080")
	@GetMapping(value = "/{id}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "FindById",
				description = "Object find id",
				tags = {"Person"},
				responses = {
						@ApiResponse(content = {
								@Content(
										mediaType = "application/json",
										array = @ArraySchema(
												schema = @Schema(
														implementation = PersonDto.class)
	))},
			description = "Sucess",
			responseCode = "200"),
	@ApiResponse(content = @Content, description = "No Content", responseCode = "204"),
	@ApiResponse(content = @Content, description = "Bad Request", responseCode = "400"),
	@ApiResponse(content = @Content, description = "Unauthorized", responseCode = "401"),
	@ApiResponse(content = @Content, description = "Not Found", responseCode = "404"),
	@ApiResponse(content = @Content, description = "Internal Error", responseCode = "500")})
	public ResponseEntity<PersonDto> obterPorId(@PathVariable("id") Long id){
		return new ResponseEntity<>(personService.readId(id), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{id}",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "Update Object",
	description = "Object Book Update",
	tags = {"Person"},
	responses = {
			@ApiResponse(content = {
					@Content(
							mediaType = "application/json",
							array = @ArraySchema(
									schema = @Schema(
											implementation = PersonDto.class)
				))},
		description = "Sucess",
		responseCode = "200"),
	@ApiResponse(content = @Content, description = "No Content", responseCode = "204"),
	@ApiResponse(content = @Content, description = "Bad Request", responseCode = "400"),
	@ApiResponse(content = @Content, description = "Unauthorized", responseCode = "401"),
	@ApiResponse(content = @Content, description = "Not Found", responseCode = "404"),
	@ApiResponse(content = @Content, description = "Internal Error", responseCode = "500")})
	public ResponseEntity<PersonDto> atualizar(@RequestBody PersonDto personDto,@PathVariable("id") Long id){
		return new ResponseEntity<>(personService.update(personDto, id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Object",
	description = "Object Person Delete",
	tags = {"Person"},
	responses = {
	@ApiResponse(content = @Content, description = "No Content", responseCode = "204"),
	@ApiResponse(content = @Content, description = "Bad Request", responseCode = "400"),
	@ApiResponse(content = @Content, description = "Unauthorized", responseCode = "401"),
	@ApiResponse(content = @Content, description = "Not Found", responseCode = "404"),
	@ApiResponse(content = @Content, description = "Internal Error", responseCode = "500")})
	public ResponseEntity<HttpStatus> deletar(@PathVariable("id") Long id){
		personService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
