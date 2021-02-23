package com.farmacia.Farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
		//ATRIBUTOS
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@NotNull @Size(min = 2, max = 30)
//	private String cosmetico;	
	
	@NotNull @Size(min = 2, max = 50)
	private String remedio;
	
	
	@NotNull @Size(min = 2, max = 50)
	private String descricao;
	
		//METODO CONSTRUTOR
	public Categoria() {
		this.id = id;
//		this.cosmetico = cosmetico;
		this.remedio = remedio;
		this.descricao = descricao;
		
		
	}

		//METODOS DE ACESSO
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public String getCosmetico() {
//		return cosmetico;
//	}
//
//	public void setCosmetico(String cosmetico) {
//		this.cosmetico = cosmetico;
//	}

	public String getRemedio() {
		return remedio;
	}

	public void setRemedio(String remedio) {
		this.remedio = remedio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
