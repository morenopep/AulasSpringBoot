package com.blogpessoal.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;


@Entity // Aqui estou dizendo que essa classe é uma entidade
@Table(name = "postagem") //--- esssa entidade vai virar uma tabel dentro do BD
public class Postagem {
	//Atributos 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	//@Size
	private String texto;
	
	@NonNull
	//@Size
	private String titulo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	
	
	//metodos de acesso

	private long getId() {
		return id;
	}


	private void setId(long id) {
		this.id = id;
	}


	private String getTexto() {
		return texto;
	}


	private void setTexto(String texto) {
		this.texto = texto;
	}


	private String getTitulo() {
		return titulo;
	}


	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	private Date getData() {
		return data;
	}


	private void setData(Date data) {
		this.data = data;
	}
	
	
	
	
}
