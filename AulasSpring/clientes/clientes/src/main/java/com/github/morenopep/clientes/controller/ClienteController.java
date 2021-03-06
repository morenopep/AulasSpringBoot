package com.github.morenopep.clientes.controller;

import java.util.Optional;
import java.util.function.Function;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.morenopep.clientes.model.Cliente;
import com.github.morenopep.clientes.repository.ClienteRepository;

@RestController 
@RequestMapping("/api/clientes")  //Mapeia a URL base que vai ser tratado desse controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;  //INJETANDO REPOSITORIO
	
	//esse metodo salva o cliente da base de dados e responde um StatusHttp q foi criado
	
	@PostMapping //Mapeia o metodo para uma requisão com o verbo post
	@ResponseStatus(HttpStatus.CREATED) //mapeia o objeto de retorno para o corpo da resposta e vai em formato JSON
		public Cliente salvar(@RequestBody @Valid Cliente cliente) {
			return repository.save(cliente);
		}
	
	 //esse metodo vai buscar um cliente por id, se não encontrar vai mostrar um erro HttpStatus.NOT_FOUND
	
	@GetMapping("{id}")
		public Cliente getById(@PathVariable Long id) {
			return repository.findById(id)
					.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );
	}
	
	
	//Esse metodo Busca o cliente por Id e Delete da base e responde um Status 204 falando que funcionou o delte, se não encontrar vai mostrar um erro HttpStatus.NOT_FOUND 
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deleteById(@PathVariable Long id) {
		repository.findById(id).map( cliente -> {
			repository.delete(cliente);
			return Void.TYPE;
			}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );
		}
	
	//Ess metodo busca o cliente por id e Atualiza alguma informação
//	@PutMapping("{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//		public void putAtualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
//			repository
//			.findById(id).map(cliente -> {
//				clienteAtualizado.setId( cliente.getId() );
//				repository.save(clienteAtualizado);
//			}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
//		}
	
	@PutMapping
		public ResponseEntity<Cliente> putCliente(@Validated @RequestBody Cliente cliente){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(cliente));
		}
	
	

	
	
}

