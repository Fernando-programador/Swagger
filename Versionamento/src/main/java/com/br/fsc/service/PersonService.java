package com.br.fsc.service;




import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.br.fsc.DTO.PersonDto;
import com.br.fsc.controllers.PersonController;
import com.br.fsc.exception.ResourceNotFoundException;
import com.br.fsc.mapper.DozerMapper;
import com.br.fsc.model.Person;
import com.br.fsc.repository.PersonRepostory;


@Service
public class PersonService {

	
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	PersonRepostory personRepostory;
	
	public PersonDto create(PersonDto personDto) {
		
		logger.info("Create people");
		personDto.setId(null);
		
		var entity = DozerMapper.parseObject(personDto, Person.class);
		
		var person = DozerMapper.parseObject(personRepostory.save(entity), PersonDto.class);
		
		person.add(linkTo(methodOn(PersonController.class).obterPorId(person.getId())).withSelfRel());
		
		return person;	
	}
	
	
	
	public List<PersonDto> readAll(){
		logger.info("Finding all people");
		
		var persons = DozerMapper.parseListObject(personRepostory.findAll(), PersonDto.class);
		
		persons
		.stream()
		.forEach(p -> p.add(linkTo(methodOn(PersonController.class).obterPorId(p.getId())).withSelfRel()));
		
		return persons;
	}
	
	
	public PersonDto readId(Long id) {
		logger.info("Finding id people");
		
		var entity = personRepostory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("id " + id + "not exists is repository"));
		
		var person = DozerMapper.parseObject(entity, PersonDto.class);
		
		person.add(linkTo(methodOn(PersonController.class).obterPorId(id)).withSelfRel());
		
		return person;
	}
	
	
	public PersonDto update(PersonDto personDto, Long id) {
		logger.info("Update People");
		
		var entity = personRepostory.findById(personDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("id " + id + " not exists is repository!!!"));
		
		entity.setAuthor(personDto.getAuthor());
		entity.setDate(personDto.getDate());
		entity.setWage(personDto.getWage());
		entity.setWork(personDto.getWork());
		
		var person = DozerMapper.parseObject(entity, PersonDto.class);
		
		person.add(linkTo(methodOn(PersonController.class).obterPorId(personDto.getId())).withSelfRel());
		
		return person;
	}
	
	public void delete(Long id) {
		logger.info("delete person");
		
		var entity = personRepostory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("id " + id + " not exists is repository!!"));
		
		personRepostory.delete(entity);
		
	}
	
}
