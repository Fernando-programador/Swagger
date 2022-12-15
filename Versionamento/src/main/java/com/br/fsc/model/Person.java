package com.br.fsc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "autores")
public class Person  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false, unique = true, length = 120)
	private String author;
	
	@Column(name = "data", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "salario", nullable = false)
	private Double wage;
	
	@Column(name = "livros escritos")
	private Integer work;

	public Person() {
		super();
	}

	public Person(Long id, String author, Date date, Double wage, Integer work) {
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
		return Objects.hash(author, date, id, wage, work);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(author, other.author) && Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(wage, other.wage) && Objects.equals(work, other.work);
	}
	
	
	
	
}


