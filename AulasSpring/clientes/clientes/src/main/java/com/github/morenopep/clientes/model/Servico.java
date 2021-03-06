package com.github.morenopep.clientes.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Servico {
	//ATRIBUTOS 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
	
	@NotNull @Size(max = 150)
		private String descricao;
	
	@ManyToOne //Muitos "Serviços" para um "Cliente"
	@JoinColumn(name = "id_clientes") //Define uma chave estrangeira
 		private Cliente cliente;
	
	@Column
		private BigDecimal valor; //Valor do serviço prestado
	
}
