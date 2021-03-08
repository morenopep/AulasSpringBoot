package com.github.morenopep.clientes.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.morenopep.clientes.controller.exception.ApiErrors;

@RestControllerAdvice //identifica uma classe que vai receber um erro

public class ApplicationControllerAdvice {
	
	//TRATANDO ERROS NA API
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleValitionErros(MethodArgumentNotValidException ex ) {
		BindingResult BindingResult = ex.getBindingResult();
		List<String> messages = BindingResult.getAllErrors().stream()
		.map(ObjectError -> ObjectError.getDefaultMessage())
		.collect( Collectors.toList() );
		return new ApiErrors(messages);
	}	
}
