package com.minhalojadegames.MinhaLojaDeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhalojadegames.MinhaLojaDeGames.model.Usuario;
import com.minhalojadegames.MinhaLojaDeGames.repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
		public UsuarioRepository repository;
	
	@GetMapping("/all")
		public ResponseEntity<List<Usuario>> getAll() {
			return repository.findAll().size() == 0 ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : 
				ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
		}
	
	@GetMapping("/id/{id}")
		public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
			return repository.findById(id).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
					.orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
		}
	
	@GetMapping("/nome/{nome}")
		public ResponseEntity<Usuario> getUsuarioByNome(@PathVariable String nome) {
			return repository.findByNome(nome).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
					.orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
		}
	
	@PostMapping
		public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
		}
	
	@PutMapping
		public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario) {
			return repository.existsById(usuario.getId()) ? ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario)) :
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	@DeleteMapping("/id/{id}")
		public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
			if(repository.existsById(id)) {
				repository.deleteById(id);
				return ResponseEntity.status(HttpStatus.OK).build();
			} else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();			
			}
		}
	
}