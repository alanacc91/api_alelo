package com.alan.api_alelo.DOMAIN.cartao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;

/**
 * Interface de persistencia da entidade Cartao
 * 
 * @author alan.cardoso 12.05.2020
 */
@Repository
public interface ICartaoRepository {

	Page<Cartao> selecionarTodosPaginados(Pageable pageable);

	List<Cartao> selecionarTodos();

	Optional<Cartao> selecionarPorId(Integer id);

	Optional<Cartao> selecionarPorNumero(String numero);

	List<Cartao> selecionarPorCliente(int id);

	void salvar(Cartao cartao);

	void atualizar(Cartao cartao);

	void deletar(int id);

}
