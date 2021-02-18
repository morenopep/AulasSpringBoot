package com.blogpessoal.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.blog.model.Postagem;
import com.blogpessoal.blog.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repositoty;
	
	// metodo findall
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repositoty.findAll()); //Traz todas as postagem
	}
	
	//METODO GETBYID
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById (@PathVariable long id){
		return repositoty.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/Titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String Titulo){
		return ResponseEntity.ok(repositoty.findAllByTituloContaningIgnoreCase(Titulo));
	}
	
	

		
	
		
	
	
	
	
	
}
	

