package com.minhalojadegames.MinhaLojaDeGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoriaLoja")
public class Categoria {
	
		//ATRIBUTOS
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;	
	
	@NotNull @Size(min = 2, max = 70)
		private String descricao;
	
		//METODO CONSTRUTOR
	public Categoria() {	
		
	}

		//METODOS DE ACESSO
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
