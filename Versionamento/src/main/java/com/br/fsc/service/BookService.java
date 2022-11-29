package com.br.fsc.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	public List<BookDto> readAll(){
		var book = bookRepository.findAll();
		
		return book.stream().map(bookDto -> new ModelMapper()
				.map(bookDto, BookDto.class))
				.collect(Collectors.toList());
	}

	
	public BookDto readId(@PathVariable ("id") Long id) {
		 Optional<Book> book = bookRepository.findById(id);
		 
		 ModelMapper mapper = new ModelMapper();
		 
		 BookDto bookDto = mapper.map(book, BookDto.class);
		 
		 return bookDto;
		 
	}
	
	public BookDto update(BookDto bookDto, Long id) {
		bookDto.setId(id);
		
		
		ModelMapper mapper = new ModelMapper();
		
		Book book = mapper.map(bookDto, Book.class);
		
		book = bookRepository.save(book);
		return bookDto;
	}
	
	public void deleteId (@PathVariable ("id") Long id) {
		
		
		bookRepository.deleteById(id);
		
	}
	
	
	
}
