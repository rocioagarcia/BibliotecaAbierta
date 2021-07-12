package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.bibliotecaAbierta.model.EventAuthor;

@Repository
public interface EvenAuthorRepository extends JpaRepository<EventAuthor, Long> {

}
