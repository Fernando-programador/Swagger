package com.br.fsc.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fsc.controllers.BookController;
import com.br.fsc.exception.ResourceNotFoundException;
import com.br.fsc.model.Book;
import com.br.fsc.repository.BookRepository;
import com.br.fsc.shared.BookDto;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public BookDto create(BookDto bookDto){
		//cancelamos o id de book
		 bookDto.setId(null);
		 //criamos um mapeador
		 ModelMapper mapper = new ModelMapper();
		 //convertemos o bookDto em um entity
		 Book book = mapper.map(bookDto, Book.class);
		//salvamos os valores
		book =bookRepository.save(book);
		//copiamos o book para bookDto
		bookDto.setId(book.getId());
		//retornamos o bookDto
		return bookDto;	
	}
	/*
	public BookDtoV2 createV2(BookDtoV2 bookDtoV2){
		//cancelamos o id de book
		bookDtoV2.setId(null);
		//criamos um mapeador
		ModelMapper mapper = new ModelMapper();
		//convertemos o bookDto em um entity
		//Book book = mapper.addConverter(Converter<BookDto.class, Book.class> bookDtoV2.);
				//bookDtoV2.setTitle(book.getTitle()),
			//	bookDtoV2.setDescription(book.getDescription()),
				//bookDtoV2.setPages(book.getPages()),
			//	bookDtoV2.setValue(book.getValue()),
			//	bookDtoV2.setDate(new Date()));
		//salvamos os valores
		book =bookRepository.save(book);
		//copiamos o book para bookDto
		bookDtoV2.setId(book.getId());
		//retornamos o bookDto
		return bookDtoV2;	
	}
	*/
	public List<BookDto> readAll(){
		var book = bookRepository.findAll();
		
		return book.stream().map(bookDto -> new ModelMapper()
				.map(bookDto, BookDto.class))
				.collect(Collectors.toList());
	}

	
	public Optional<BookDto> readId(Long id) {
		 Optional<Book> book = bookRepository.findById(id);
		 
		 ModelMapper mapper = new ModelMapper();
		 
		 BookDto bookDto = mapper.map(book.get(), BookDto.class);
		// bookDto.add((((Link) methodOn(BookRepository.class).findAll()).withSelfRel()));
		 bookDto.add(linkTo(methodOn(BookController.class).obterPorId(id)).withSelfRel());
		 return Optional.of(bookDto);
		 
	}
	
	public BookDto update(BookDto bookDto, Long id) {
		bookDto.setId(id);
		
		
		ModelMapper mapper = new ModelMapper();
		
		Book book = mapper.map(bookDto, Book.class);
		
		book = bookRepository.save(book);
		return bookDto;
	}
	
	public void deleteId (Long id) {
		var book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Id " + id + " não encontrado"));
		
		bookRepository.delete(book);
	}
	
	
	
}
