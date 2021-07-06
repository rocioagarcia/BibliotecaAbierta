package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comit.bibliotecaAbierta.modelo.EventAuthor;

public interface EvenAuthorRepository extends JpaRepository<EventAuthor, Long> {

}
