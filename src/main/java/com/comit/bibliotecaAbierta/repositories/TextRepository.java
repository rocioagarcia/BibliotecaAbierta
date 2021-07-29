package com.comit.bibliotecaAbierta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.comit.bibliotecaAbierta.model.Text;

@Repository
public interface TextRepository extends JpaRepository<Text, Long> {

	Text findOneById(Long id);
	List<Text> findAllByOrderByTitleAsc();
	

	@Query(value = "FROM Text t JOIN t.author a JOIN t.subjects s WHERE ((t.title like '%:matcher%' OR t.title is null) "
			+ "OR (a.name like '%:matcher%' OR a.name is null)" + "OR (s.name like '%:matcher%' OR s.name is null))")
	List<Text> findAllByMatchers(@Param("matcher") String matcher);
}
