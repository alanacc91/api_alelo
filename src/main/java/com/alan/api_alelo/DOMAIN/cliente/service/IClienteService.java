package com.alan.api_alelo.DOMAIN.cliente.service;

import org.springframework.stereotype.Service;

import com.alan.api_alelo.DOMAIN.cliente.Cliente;

/**
 * Interface de servicos da entidade Cliente
 * 
 * @author alan.cardoso
 *
 *         14.05.2020
 */
@Service
public interface IClienteService {
	boolean existirCliente(int id);

	void salvar(Cliente cliente);

	Cliente selecionarPorNome(String nome);
}
