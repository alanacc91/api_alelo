package com.alan.api_alelo.DOMAIN.cliente.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alan.api_alelo.DOMAIN.cliente.Cliente;
import com.alan.api_alelo.DOMAIN.cliente.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	IClienteRepository iClienteRepository;

	@Override
	public boolean existirCliente(int id) {
		Optional<Cliente> optCliente = iClienteRepository.selecionarPorId(id);
		return optCliente.isPresent();
	}

	@Override
	public void salvar(Cliente cliente) {
		iClienteRepository.salvar(cliente);
	}

	@Override
	public Cliente selecionarPorNome(String nome) {
		Optional<Cliente> optCliente = iClienteRepository.selecionarPorNome(nome);
		return optCliente.orElse(null);
	}

}
