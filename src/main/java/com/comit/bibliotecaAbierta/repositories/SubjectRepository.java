package com.comit.bibliotecaAbierta.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.bibliotecaAbierta.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	Subject findOneBySubject(String subject);
}
