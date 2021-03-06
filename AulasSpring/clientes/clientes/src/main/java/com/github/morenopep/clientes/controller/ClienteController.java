package com.github.morenopep.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.morenopep.clientes.model.Cliente;
import com.github.morenopep.clientes.repository.ClienteRepository;

@RestController 
@RequestMapping("/api/clientes")  //Mapeia a URL base que vai ser tratado desse controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;  //INJETANDO REPOSITORIO
	
	@PostMapping //Mapeia o metodo para uma requisão com o verbo post
	@ResponseStatus(HttpStatus.CREATED) //mapeia o objeto de retorno para o corpo da resposta e vai em formato JSON
		public Cliente salvar( Cliente cliente) {
			return repository.save(cliente);
		}
}
