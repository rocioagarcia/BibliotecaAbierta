package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comit.bibliotecaAbierta.modelo.TextList;

public interface TextListRepository extends JpaRepository<TextList, Long> {

}