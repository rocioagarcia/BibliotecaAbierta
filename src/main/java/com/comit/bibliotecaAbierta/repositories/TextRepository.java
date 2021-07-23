package com.comit.bibliotecaAbierta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.comit.bibliotecaAbierta.model.Text;

@Repository
public interface TextRepository extends JpaRepository<Text, Long> {

	Text findOneById(Long id);
	List<Text> findAllByOrderByTitleAsc();
}
