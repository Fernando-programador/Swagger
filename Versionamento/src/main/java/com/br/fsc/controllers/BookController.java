package com.br.fsc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fsc.DTO.BookDto;
import com.br.fsc.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

@RestController
@RequestMapping("/book")
@Tag(name = "Book", description = "EndPoint do CRUD de Book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "Create new Book",
				description = "New Gallery Books",
				tags = {"Book"},
				responses = {
						@ApiResponse(content = {
								@Content(
										mediaType = "application/json",
										array = @ArraySchema(
												schema = @Schema(
														implementation = BookDto.class)
	))},
			description = "Sucess",
			responseCode = "200"),
	@ApiResponse(content = @Content, description = "Bad Request", responseCode = "400"),
	@ApiResponse(content = @Content, description = "Unauthorized", responseCode = "401"),
	@ApiResponse(content = @Content, description = "Internal Error", responseCode = "500")
	})
	public ResponseEntity<BookDto> criar(@RequestBody BookDto bookDto){
		return new ResponseEntity<>(bookService.create(bookDto), HttpStatus.CREATED);
	}
	
	
	/*
	@PostMapping(value = "/v2",
			consumes =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<BookDtoV2> criarV2(@RequestBody BookDtoV2 bookDtoV2){
		return new ResponseEntity<>(bookService.createV2(bookDtoV2), HttpStatus.CREATED);
	}
*/
	
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "FindByALL",
				description = "Object find id ALL",
				tags = {"Book"},
				responses = {
						@ApiResponse(content = {
								@Content(
										mediaType = "application/json",
										array = @ArraySchema(
												schema = @Schema(
														implementation = BookDto.class)
	))},
				description = "Sucess",
				responseCode = "200"),
	@ApiResponse(content = @Content, description = "No Content", responseCode = "204"),
	@ApiResponse(content = @Content, description = "Bad Request", responseCode = "400"),
	@ApiResponse(content = @Content, description = "Unauthorized", responseCode = "401"),
	@ApiResponse(content = @Content, description = "Not Found", responseCode = "404"),
	@ApiResponse(content = @Content, description = "Internal Error", responseCode = "500")
	})
	public ResponseEntity<List<BookDto>> obterTodos(){
		return new ResponseEntity<>(bookService.readAll(), HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "FindById",
				description = "Object find id",
				tags = {"Book"},
				responses = {
						@ApiResponse(content = {
								@Content(
										mediaType = "application/json",
										array = @ArraySchema(
												schema = @Schema(
														implementation = BookDto.class)
	))},
			description = "Sucess",
			responseCode = "200"),
	@ApiResponse(content = @Content, description = "No Content", responseCode = "204"),
	@ApiResponse(content = @Content, description = "Bad Request", responseCode = "400"),
	@ApiResponse(content = @Content, description = "Unauthorized", responseCode = "401"),
	@ApiResponse(content = @Content, description = "Not Found", responseCode = "404"),
	@ApiResponse(content = @Content, description = "Internal Error", responseCode = "500")
	})
	public ResponseEntity <Optional<BookDto>> obterPorId(@PathVariable ("id") Long id){
		return new ResponseEntity<>(bookService.readId(id), HttpStatus.OK);
	}
	
	
	
	@PutMapping(value = "/{id}",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Operation(summary = "Update Object",
	description = "Object Book Update",
	tags = {"Book"},
	responses = {
			@ApiResponse(content = {
					@Content(
							mediaType = "application/json",
							array = @ArraySchema(
									schema = @Schema(
											implementation = BookDto.class)
				))},
		description = "Sucess",
		responseCode = "200"),
	@ApiResponse(content = @Content, description = "No Content", responseCode = "204"),
	@ApiResponse(content = @Content, description = "Bad Request", responseCode = "400"),
	@ApiResponse(content = @Content, description = "Unauthorized", responseCode = "401"),
	@ApiResponse(content = @Content, description = "Not Found", responseCode = "404"),
	@ApiResponse(content = @Content, description = "Internal Error", responseCode = "500")
})
	public ResponseEntity<BookDto> atualizar(@PathVariable ("id") Long id,
			@RequestBody BookDto bookDto){
		return new ResponseEntity<>(bookService.update(bookDto, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Object",
	description = "Object Book Delete",
	tags = {"Book"},
	responses = {
	@ApiResponse(content = @Content, description = "No Content", responseCode = "204"),
	@ApiResponse(content = @Content, description = "Bad Request", responseCode = "400"),
	@ApiResponse(content = @Content, description = "Unauthorized", responseCode = "401"),
	@ApiResponse(content = @Content, description = "Not Found", responseCode = "404"),
	@ApiResponse(content = @Content, description = "Internal Error", responseCode = "500")
})
	public ResponseEntity<HttpStatus> deletePorId(@PathVariable ("id") Long  id){
		bookService.deleteId(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
