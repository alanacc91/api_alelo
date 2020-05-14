package com.alan.api_alelo.DOMAIN.cliente.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.alan.api_alelo.DOMAIN.cliente.Cliente;

/**
 * Interface de persistencia da entidade cliente
 * 
 * @author alan.cardoso
 *
 *         14.05.2020
 */
@Repository
public interface IClienteRepository {
	Optional<Cliente> selecionarPorId(Integer id);

	public void salvar(Cliente cliente);

	public Optional<Cliente> selecionarPorNome(String nome);
}
