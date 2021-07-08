package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.bibliotecaAbierta.modelo.PersonalAuthor;

@Repository
public interface PersonalAuthorRepository extends JpaRepository<PersonalAuthor, Long> {

}
