package com.br.fsc.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class BookDtoV2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String description;
	private int pages;
	private Double value;
	private Date date;
	
	public BookDtoV2() {
	}

	public BookDtoV2(Long id, String title, String description, int pages, Double value, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.pages = pages;
		this.value = value;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, description, id, pages, title, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDtoV2 other = (BookDtoV2) obj;
		return Objects.equals(date, other.date) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && pages == other.pages && Objects.equals(title, other.title)
				&& Objects.equals(value, other.value);
	}

	
}
