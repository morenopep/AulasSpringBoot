package com.github.morenopep.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.morenopep.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
