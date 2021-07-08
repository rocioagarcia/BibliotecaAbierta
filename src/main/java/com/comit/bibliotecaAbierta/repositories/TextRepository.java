package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.bibliotecaAbierta.modelo.Text;

@Repository
public interface TextRepository extends JpaRepository<Text, Long> {

	
}
