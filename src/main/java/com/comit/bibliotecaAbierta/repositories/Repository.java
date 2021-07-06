package com.comit.bibliotecaAbierta.repositories;

import java.util.Optional;
import java.util.List;

public interface Repository <T, E>{

	Optional<T> findById(E id);
	List<T> findAll();
	List<T> findAllByIds(List<E> id);
	T save (T entity);
	void delete (T entity);
	int count();
	
	
}
