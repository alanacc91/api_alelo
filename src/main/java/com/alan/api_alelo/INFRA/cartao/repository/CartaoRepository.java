package com.alan.api_alelo.INFRA.cartao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;
import com.alan.api_alelo.DOMAIN.cartao.repository.ICartaoRepository;

/**
 * Classe de persistencia da entidade cartao
 * 
 * @author alan.cardoso 13.05.2020
 */
@Repository
public class CartaoRepository implements ICartaoRepository {

	@Autowired
	ICartaoJPARepository iCartaoJPARepository;

	@Override
	public Page<Cartao> selecionarTodosPaginados(Pageable pageable) {
		return iCartaoJPARepository.findAll(pageable);
	}

	@Override
	public List<Cartao> selecionarTodos() {
		return iCartaoJPARepository.findAll();
	}

	@Override
	public Optional<Cartao> selecionarPorId(Integer id) {
		return iCartaoJPARepository.findById(id);
	}

	@Override
	public void salvar(Cartao cartao) {
		iCartaoJPARepository.save(cartao);
	}

	@Override
	public void atualizar(Cartao cartao) {
		iCartaoJPARepository.save(cartao);
	}

	@Override
	public void deletar(Cartao cartao) {
		iCartaoJPARepository.delete(cartao);
	}

	@Override
	public Optional<Cartao> selecionarPorNumero(String numero) {
		return iCartaoJPARepository.findByNumero(numero);
	}

	@Override
	public List<Cartao> selecionarPorCliente(int id) {
		return iCartaoJPARepository.findByClienteId(id);
	}

}
