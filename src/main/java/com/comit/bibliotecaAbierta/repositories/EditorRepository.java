package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.bibliotecaAbierta.modelo.Editor;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {

}
