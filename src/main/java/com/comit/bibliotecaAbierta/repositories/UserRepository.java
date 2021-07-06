package com.comit.bibliotecaAbierta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comit.bibliotecaAbierta.modelo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
