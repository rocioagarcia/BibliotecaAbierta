package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comit.bibliotecaAbierta.modelo.PersonalAuthor;

public interface PersonalAuthorRepository extends JpaRepository<PersonalAuthor, Long> {

}
