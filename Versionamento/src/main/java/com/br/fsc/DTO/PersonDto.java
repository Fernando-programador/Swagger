package com.br.fsc.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"id","author","wage","date","work",})
public class PersonDto extends RepresentationModel<PersonDto> implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	//@JsonProperty("my_Title") para mudar o nome
	private String author;
	
	private Date date;
	
	private Double wage;
	
	private Integer work;
	
	
	public PersonDto() {
	}


	public PersonDto(Long id, String author, Date date, Double wage, Integer work) {
		super();
		this.id = id;
		this.author = author;
		this.date = date;
		this.wage = wage;
		this.work = work;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getWage() {
		return wage;
	}


	public void setWage(Double wage) {
		this.wage = wage;
	}


	public Integer getWork() {
		return work;
	}


	public void setWork(Integer work) {
		this.work = work;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(author, date, id, wage, work);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDto other = (PersonDto) obj;
		return Objects.equals(author, other.author) && Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(wage, other.wage) && Objects.equals(work, other.work);
	}

	
	

	
	
	



	

	
	
}
