package com.patricio.bookstore.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.patricio.bookstore.dominio.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
	

}
