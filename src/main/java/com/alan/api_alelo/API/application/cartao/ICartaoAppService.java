package com.alan.api_alelo.API.application.cartao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alan.api_alelo.utils.excecao.ExcecaoDeNegocios;

/**
 * Interface de aplicacao de servicos
 * 
 * @author alan.cardoso 13.05.2020
 */
@Service
public interface ICartaoAppService {
	List<CartaoDTO> selecionarTodosPaginados(int numeroDaPagina, int quantidadeDePaginas) throws ExcecaoDeNegocios;

	List<CartaoDTO> selecionarTodos();

	CartaoDTO selecionarPorId(Integer id) throws ExcecaoDeNegocios;

	CartaoDTO selecionarPorNumero(String numero) throws ExcecaoDeNegocios;

	List<CartaoDTO> selecionarPorCliente(int id) throws ExcecaoDeNegocios;

	CartaoDTO salvar(CartaoDTO cartao) throws ExcecaoDeNegocios;

	CartaoDTO atualizar(CartaoDTO cartao) throws ExcecaoDeNegocios;

	CartaoDTO deletar(CartaoDTO cartao) throws ExcecaoDeNegocios;
}
