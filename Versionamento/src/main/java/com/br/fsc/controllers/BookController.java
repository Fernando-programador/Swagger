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

import com.br.fsc.service.BookService;
import com.br.fsc.shared.BookDto;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> criar(@RequestBody BookDto bookDto){
		return new ResponseEntity<>(bookService.create(bookDto), HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDto>> obterTodos(){
		return new ResponseEntity<>(bookService.readAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Optional<BookDto>> obterPorId(@PathVariable ("id") Long id){
		return new ResponseEntity<>(bookService.readId(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> atualizar(@PathVariable ("id") Long id,
			@RequestBody BookDto bookDto){
		return new ResponseEntity<>(bookService.update(bookDto, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePorId(@PathVariable ("id") Long  id){
		bookService.deleteId(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
