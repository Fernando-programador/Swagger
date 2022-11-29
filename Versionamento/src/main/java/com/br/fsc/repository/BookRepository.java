package com.br.fsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fsc.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
