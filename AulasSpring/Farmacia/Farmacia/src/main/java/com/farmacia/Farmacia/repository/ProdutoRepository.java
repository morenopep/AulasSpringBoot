package com.farmacia.Farmacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.Farmacia.model.Produtos;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

	public Optional<Produtos> findByNomeIgnoreCase(String nome);
}
