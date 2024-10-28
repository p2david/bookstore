package com.patricio.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patricio.bookstore.dominio.Livro;
import com.patricio.bookstore.repositories.LivroRepository;
import com.patricio.bookstore.services.exceptions.ObjectNotFoundExcepion;


@Service
public class LivroService {

	@Autowired
	public LivroRepository repository;
	

public Livro findById(Integer id) {
		
		//para buscar via ID
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExcepion(
				"Objecto nao encotrado! id:" + id + ",Tipo:" + Livro.class.getName()));

	}
	
	public List<Livro> findAll(){	
	return	repository.findAll();
		
	}
	
	
	public Livro create(Livro obj) {
		
		obj.setId(null);
	return repository.save(obj);
		
	}
	
}
