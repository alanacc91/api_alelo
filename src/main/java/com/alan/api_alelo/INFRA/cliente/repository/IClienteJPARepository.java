package com.alan.api_alelo.INFRA.cliente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alan.api_alelo.DOMAIN.cliente.Cliente;

/**
 * Interface JPA da entidade Cliente
 * 
 * @author alan.cardoso
 * 
 *         14.05.2020
 */
@Repository
public interface IClienteJPARepository extends JpaRepository<Cliente, Integer> {

	Optional<Cliente> findByNome(String nome);

}
