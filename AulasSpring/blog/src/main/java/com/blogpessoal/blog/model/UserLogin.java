package com.blogpessoal.blog.model;

import lombok.Data;

@Data
public class UserLogin {
	//Atributos 
	private String nome;
	
	private String usuario;
	
	private String senha;
	
	private String token;
}
