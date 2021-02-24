package com.minhalojadegames.MinhaLojaDeGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;


@Entity
public class Produtos {
	
		//ATRIBUTOS
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
	@NotNull @Size(min = 2, max = 30)
		private String titulo;	
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
		private Categoria categoria;
	
		//METODO CONSTRUTOR
	public Produtos() {
		
	}

		//METODOS DE ACESSO
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	

	
}
