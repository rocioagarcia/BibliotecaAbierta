package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comit.bibliotecaAbierta.modelo.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
