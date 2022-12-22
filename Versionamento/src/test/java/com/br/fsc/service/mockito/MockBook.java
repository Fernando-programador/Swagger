package com.br.fsc.service.mockito;

import java.util.ArrayList;
import java.util.List;



import com.br.fsc.DTO.BookDto;
import com.br.fsc.model.Book;

public class MockBook {


	public Book bookMock() {
		return bookMock(0);
	}
	
	
	public BookDto bookDtoMock() {
		return bookDtoMock(0);
	}
	
	
	public List<Book> bookListMock(){
		List<Book> books = new ArrayList<Book>();
		for(int i =0; i < 14; i++) {
			books.add(bookMock(i));
		}
		return books;
	}
	

	public List<BookDto> bookDtoListMock(){
		List<BookDto> bookDtos = new ArrayList<BookDto>();
		for(int i =0; i < 14; i++) {
			bookDtos.add(bookDtoMock(i));
		}
		return bookDtos;
	}
	
	
	public Book bookMock(Integer number) {
		Book book = new Book();
		book.setId(number.longValue());
		book.setTitle("Nome titulo");
		book.setDescription("Nome descricao");
		book.setPages(0);
		book.setValue(2212.83 );
		
		return book;
	}
	
	
	public BookDto bookDtoMock(Integer number) {
	BookDto bookDto = new BookDto();
	bookDto.setId(number.longValue());
	bookDto.setTitle("Nome titulo");
	bookDto.setDescription("Nome descricao");
	bookDto.setPages(0 );
	bookDto.setValue(2212.83 );
	
	return bookDto;
}
	
	
}
