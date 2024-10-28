package com.patricio.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.patricio.bookstore.dominio.Categoria;
import com.patricio.bookstore.dtos.CategoriaDTO;
import com.patricio.bookstore.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	public CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {

		Categoria obj = service.findById(id);// criamos um objecto que possui dados via ID
		return ResponseEntity.ok().body(obj);// buscamos objecto e metemos no corpo
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {

		List<Categoria> list = service.findAll();

		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);

	}

	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO objDto) {

		Categoria newobj = service.create(id, objDto);
		return ResponseEntity.ok().body(new CategoriaDTO(newobj));
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
