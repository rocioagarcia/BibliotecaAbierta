package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.bibliotecaAbierta.modelo.TextList;

@Repository
public interface TextListRepository extends JpaRepository<TextList, Long> {

}
