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

import com.farmacia.Farmacia.model.Produtos;
import com.farmacia.Farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin
public class ProdutosController {
	@Autowired
		public	ProdutoRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Produtos>> findAllProdutos() {
		return repository.findAll().size() == 0 ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() 
				: ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	} 
	
	@GetMapping("/id/{id}")
		public ResponseEntity<Produtos> findByIdProdutos(@PathVariable Long id) {
			return repository.findById(id).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
	}
	
	@GetMapping("/nome/{nome}")
		public ResponseEntity<Produtos> getProdutosByNome(@PathVariable String nome) {
			return repository.findByNomeIgnoreCase(nome).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
	}
	
	@PostMapping
		public ResponseEntity<Produtos> postProdutos(@Validated @RequestBody Produtos produto) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
		public ResponseEntity<Produtos> putProdutos(@Validated @RequestBody Produtos produto) {
			if(produto.getId() == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/id/{id}")
		public ResponseEntity<Produtos> deleteProdutos(@PathVariable Long id) {
			if(repository.existsById(id)) {
				repository.deleteById(id);
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
}
