package com.github.morenopep.clientes.controller.exception;

import java.util.List;
import java.util.Arrays;

import lombok.Getter;

public class ApiErrors {
	//atributos
	
	@Getter
	private List<String> errors;

	//Construtor
	public ApiErrors(List<String> errors ) {
		this.errors = errors;
	}
	
	//tranformando um objeto em lista
	public ApiErrors(String message ) {
		this.errors = Arrays.asList(message);
	}
}
