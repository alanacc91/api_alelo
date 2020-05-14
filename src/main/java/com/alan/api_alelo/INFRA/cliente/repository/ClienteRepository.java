package com.alan.api_alelo.INFRA.cliente.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alan.api_alelo.DOMAIN.cliente.Cliente;
import com.alan.api_alelo.DOMAIN.cliente.repository.IClienteRepository;

/**
 * Classe de persistencia da entidade Cliente
 * 
 * @author alan.cardoso
 *
 *         14.05.2020s
 */
@Repository
public class ClienteRepository implements IClienteRepository {

	@Autowired
	IClienteJPARepository iClienteJPARepository;

	@Override
	public Optional<Cliente> selecionarPorId(Integer id) {
		return iClienteJPARepository.findById(id);
	}

	@Override
	public void salvar(Cliente cliente) {
		iClienteJPARepository.save(cliente);
		
	}

	@Override
	public Optional<Cliente> selecionarPorNome(String nome) {
		return iClienteJPARepository.findByNome(nome);
	}

}
