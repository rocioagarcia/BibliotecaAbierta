package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.bibliotecaAbierta.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
