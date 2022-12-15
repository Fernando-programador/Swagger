package com.br.fsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fsc.model.Person;

@Repository
public interface PersonRepostory extends JpaRepository<Person, Long> {

}
