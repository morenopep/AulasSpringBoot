package com.github.morenopep.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.morenopep.clientes.model.Cliente;
import com.github.morenopep.clientes.repository.ClienteRepository;

@SpringBootApplication // --> essa classe inicia a aplicação
public class ClientesApplication {
	
	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository) {
		return agrs -> {
			Cliente cliente01 = Cliente.builder().cpf("00000000000").nome("Pedro").build();
			repository.save(cliente01);
		};
		
			
		}
		
	

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);		
		
	}

}
