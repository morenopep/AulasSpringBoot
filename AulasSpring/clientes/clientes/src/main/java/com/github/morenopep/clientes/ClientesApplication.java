package com.github.morenopep.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.morenopep.clientes.model.Cliente;

@SpringBootApplication // --> essa classe inicia a aplicação
public class ClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);		
		
	}

}
