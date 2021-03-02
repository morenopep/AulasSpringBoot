package com.blogpessoal.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity @Data
public class Usuario {
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 75)
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 25)
	private String usuario;
	
	@NotNull
	@Size(min = 6, max = 18)
	private String senha;
	
	//metodos 
	
}
