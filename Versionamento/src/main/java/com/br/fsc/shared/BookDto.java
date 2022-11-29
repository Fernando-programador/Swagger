package com.br.fsc.shared;

import java.io.Serializable;
import java.util.Objects;


public class BookDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String description;
	private int pages;
	private Double value;
	
	public BookDto() {
	}

	public BookDto(Long id, String title, String description, int pages, Double value) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.pages = pages;
		this.value = value;
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

	@Override
	public int hashCode() {
		return Objects.hash(description, id, pages, title, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDto other = (BookDto) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(pages, other.pages) && Objects.equals(title, other.title)
				&& Objects.equals(value, other.value);
	}

	
	
}
