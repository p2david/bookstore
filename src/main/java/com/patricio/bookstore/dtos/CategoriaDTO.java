package com.patricio.bookstore.dtos;

import java.io.Serializable;

import com.patricio.bookstore.dominio.Categoria;

public class CategoriaDTO implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;
	private String discricao;

	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaDTO(Categoria obj) {//nao vamos receber parametros vamos meter um objecto de Categoria
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.discricao = obj.getDiscricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiscricao() {
		return discricao;
	}

	public void setDiscricao(String discricao) {
		this.discricao = discricao;
	}

}
