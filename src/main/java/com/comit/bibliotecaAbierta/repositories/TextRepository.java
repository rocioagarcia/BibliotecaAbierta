package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comit.bibliotecaAbierta.modelo.Text;

public interface TextRepository extends JpaRepository<Text, Long> {

}
