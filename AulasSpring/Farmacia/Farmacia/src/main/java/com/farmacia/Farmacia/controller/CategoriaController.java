package com.farmacia.Farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.Farmacia.model.Categoria;
import com.farmacia.Farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/tb_categoria")
@CrossOrigin("*")
	public class CategoriaController {
	
	@Autowired
		private CategoriaRepository repositoty; //injetando a classe Repositorio dentro do controle
	
	@GetMapping
		public ResponseEntity<List<Categoria>> findAllCategoria(){
			return ResponseEntity.ok(repositoty.findAll());
	}
	
	@GetMapping("/{id}")
		public ResponseEntity<Categoria> findByIdCategoria(@PathVariable long id){
			return repositoty.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
		public ResponseEntity<List<Categoria>> findByDescricaoCategoria(@PathVariable String descricao){
			return ResponseEntity.ok(repositoty.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
		public ResponseEntity<Categoria> posCategoria(@Validated @RequestBody Categoria categoria){
			return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(categoria));
	}
	
	@PutMapping 
		public ResponseEntity<Categoria> putCategorias(@Validated @RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(categoria));
	}
	
	@DeleteMapping("/id/{id}")
		public ResponseEntity<Categoria> deleteCategoria(@PathVariable Long id) {
			if(repositoty.existsById(id)) {
				repositoty.deleteById(id);
				return ResponseEntity.status(HttpStatus.OK).build();
		}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
		
	
	
}
