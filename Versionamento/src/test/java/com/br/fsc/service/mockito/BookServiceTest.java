package com.br.fsc.service.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.longThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.br.fsc.model.Book;
import com.br.fsc.repository.BookRepository;
import com.br.fsc.service.BookService;
import com.br.fsc.service.mockito.MockBook;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

	
	MockBook input;
	
	@InjectMocks
	private BookService  service;
	
	
	@Mock
	BookRepository repository;
	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockBook();
		MockitoAnnotations.openMocks(this);
		
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testReadAll() {
		fail("Not yet implemented");
	}

	@Test
	void testReadId() {
		Book book = input.bookMock();
		book.setId(1L);		
		when(repository.findById(1L)).thenReturn(Optional.of(book));
		var resultado = service.readId(1L);
		
		assertNotNull(resultado);
		assertEquals("", resultado.());

		System.out.println(resultado.toString());	
		assertTrue(resultado.toString().contains("links: [</book/1>;rel=\"self\"]"));
		// na linha acima deixe o contaisn vazio  e rode a aplicação
		//apos rodar ele vai te passar o valor no console e vc cola ele
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteId() {
		fail("Not yet implemented");
	}

}
