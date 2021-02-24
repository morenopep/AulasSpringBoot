package com.minhalojadegames.MinhaLojaDeGames.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.minhalojadegames.MinhaLojaDeGames.model.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
	public Optional<Produtos> findByTituloIgnoreCase(String titulo);
}
