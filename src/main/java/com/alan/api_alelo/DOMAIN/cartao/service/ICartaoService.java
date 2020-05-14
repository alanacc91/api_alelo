package com.alan.api_alelo.DOMAIN.cartao.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;
import com.alan.api_alelo.utils.excecao.ExcecaoDeNegocios;
import com.alan.api_alelo.utils.mensagem.PilhaDeMensagensDeNegocios;

/**
 * Interface de negocios da entidade Cartao
 * 
 * @author alan.cardoso 13.05.2020
 *
 */
@Service
public interface ICartaoService {

	Page<Cartao> selecionarTodosPaginados(PilhaDeMensagensDeNegocios mensagens, int numeroDaPagina,
			int quantidadeDePaginas) throws ExcecaoDeNegocios;

	List<Cartao> selecionarTodos();

	Cartao selecionarPorId(PilhaDeMensagensDeNegocios mensagens, Integer id) throws ExcecaoDeNegocios;

	Cartao selecionarPorNumero(PilhaDeMensagensDeNegocios mensagens, String numero) throws ExcecaoDeNegocios;

	List<Cartao> selecionarPorCliente(PilhaDeMensagensDeNegocios mensagens, int id) throws ExcecaoDeNegocios;

	void salvar(PilhaDeMensagensDeNegocios mensagens, Cartao cartao) throws ExcecaoDeNegocios;

	void atualizar(PilhaDeMensagensDeNegocios mensagens, Cartao cartao) throws ExcecaoDeNegocios;

	void deletar(PilhaDeMensagensDeNegocios mensagens, Cartao cartao) throws ExcecaoDeNegocios;

}
