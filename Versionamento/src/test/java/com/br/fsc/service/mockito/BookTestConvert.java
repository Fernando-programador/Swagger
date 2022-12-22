package com.br.fsc.service.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

import com.br.fsc.DTO.BookDto;
import com.br.fsc.model.Book;

public class BookTestConvert {
	
	MockBook inputObject;
	
	@BeforeEach
	public void setUp() {
		inputObject = new MockBook();
	}

	@Test
	public void EntityListBookDtoTest() {
		List<BookDto> out = inputObject.bookDtoListMock();

		var outZero = out.get(0); 
		assertEquals(Long.valueOf(0), outZero.getId());
		assertEquals("Nome titulo", outZero.getTitle());
		assertEquals("Nome descricao", outZero.getDescription());
		assertEquals(0, outZero.getPages());
		assertEquals(2212.83, outZero.getValue());
	}
	
	@Test
	public void EntityListBookTest() {
		List<Book> out = inputObject.bookListMock();
		
		var outZero = out.get(0); 
		
		assertNotNull(outZero);
		assertNotNull(outZero.getId());
		assertNotNull(outZero.getTitle());
		assertEquals(Long.valueOf(0), outZero.getId());
		assertEquals("Nome titulo", outZero.getTitle());
		assertEquals("Nome descricao", outZero.getDescription());
		assertEquals(0, outZero.getPages());
		assertEquals(2212.83, outZero.getValue());
	}



}

