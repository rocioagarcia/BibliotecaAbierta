package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.bibliotecaAbierta.modelo.InstitutionalAuthor;

@Repository
public interface InstitutionalAuthorRepository extends JpaRepository<InstitutionalAuthor, Long> {

}
