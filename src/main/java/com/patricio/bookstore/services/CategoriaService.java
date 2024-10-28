package com.patricio.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patricio.bookstore.dominio.Categoria;
import com.patricio.bookstore.dtos.CategoriaDTO;
import com.patricio.bookstore.repositories.CategoriaRepository;
import com.patricio.bookstore.services.exceptions.ObjectNotFoundExcepion;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		
		//para buscar via ID
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExcepion(
				"Objecto nao encotrado! id:" + id + ",Tipo:" + Categoria.class.getName()));

	}
	//para listar todos
	public List<Categoria> findAll() {

		return repository.findAll();
	}

	//para gravar
	public Categoria create(Categoria obj) {

		obj.setId(null);
		return repository.save(obj);
	}
	
	//para Actualizar
	public Categoria create(Integer id, CategoriaDTO objDto) {
		
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDiscricao(objDto.getDiscricao());
		return repository.save(obj);
		
	}
	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
		
	}
}
