package com.github.morenopep.clientes.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data //essa anotação cria os Getter, setters, Construtor vazio e com parametros e tbm o toString
public class Cliente {
	//Atributos da Classe
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremente do BD
		private Long id; //id do Cliente
	
	@NotNull @Size(min = 2, max = 100, message = "Minimo de 2 letras e maximo 100")
		private String nome; //Nome do cliente
	
	@NotNull @Size(max = 11)
		private String	cpf; //cpf do cliente
	
	private LocalDate dataCadastro; //Data que o cliente foi cadastrado
	
	
}
