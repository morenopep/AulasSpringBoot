package com.ila.Vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ila.Vendas.model.Clientes;
import com.ila.Vendas.repository.ClientesRepository;

@Service
public class ClientesServices {
	
	//@Autowired 
	private ClientesRepository repository;
	
	//METODO CONSTRUTOR para injetar uma dependencia, tbm da por set ou colocando o autowired emcima do atributo
	@Autowired
	public ClientesServices(ClientesRepository repository) {
		this.repository = repository;
	}

	public void salvarCliente(Clientes cliente) {
		validarCliente(cliente);		
		this.repository.persistir(cliente);
	}
	
	public void validarCliente(Clientes cliente) {
		//aplica validações
	}
	
}
