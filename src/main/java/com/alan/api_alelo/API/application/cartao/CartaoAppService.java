package com.alan.api_alelo.API.application.cartao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;
import com.alan.api_alelo.DOMAIN.cartao.service.ICartaoService;
import com.alan.api_alelo.utils.excecao.ExcecaoDeNegocios;
import com.alan.api_alelo.utils.mensagem.PilhaDeMensagensDeNegocios;

/**
 * Classe de aplicacao de servicos da entidade Cartao
 * 
 * @author alan.cardoso 13.05.2020
 */
@Service
public class CartaoAppService implements ICartaoAppService {

	@Autowired
	ICartaoService iCartaoService;

	@Override
	public List<CartaoDTO> selecionarTodosPaginados(int numeroDaPagina, int quantidadeDePaginas)
			throws ExcecaoDeNegocios {

		PilhaDeMensagensDeNegocios mensagens = PilhaDeMensagensDeNegocios.novaInstancia();
		Page<Cartao> listaDeCartaoPaginados = iCartaoService.selecionarTodosPaginados(mensagens, numeroDaPagina,
				quantidadeDePaginas);
		List<CartaoDTO> listaDeCartaoDTO = new ArrayList<>();

		listaDeCartaoPaginados.forEach(cartao -> {
			CartaoDTO cartaoDTO = new CartaoDTO(cartao);
			cartaoDTO.setMensagens(mensagens);
			listaDeCartaoDTO.add(cartaoDTO);
		});

		return listaDeCartaoDTO;
	}

	@Override
	public List<CartaoDTO> selecionarTodos() {

		List<Cartao> listaDeCartao = iCartaoService.selecionarTodos();
		List<CartaoDTO> listaDeCartaoDTO = new ArrayList<>();

		listaDeCartao.forEach(cartao -> {
			listaDeCartaoDTO.add(new CartaoDTO(cartao));
		});

		return listaDeCartaoDTO;
	}

	@Override
	public CartaoDTO selecionarPorId(Integer id) throws ExcecaoDeNegocios {
		PilhaDeMensagensDeNegocios mensagens = PilhaDeMensagensDeNegocios.novaInstancia();
		Cartao cartao = iCartaoService.selecionarPorId(mensagens, id);
		CartaoDTO cartaoDTO = new CartaoDTO(cartao);
		cartaoDTO.setMensagens(mensagens);

		return cartaoDTO;
	}

	@Override
	public CartaoDTO selecionarPorNumero(String numero) throws ExcecaoDeNegocios {
		PilhaDeMensagensDeNegocios mensagens = PilhaDeMensagensDeNegocios.novaInstancia();
		Cartao cartao = iCartaoService.selecionarPorNumero(mensagens, numero);
		CartaoDTO cartaoDTO = new CartaoDTO(cartao);
		cartaoDTO.setMensagens(mensagens);

		return cartaoDTO;
	}

	@Override
	public List<CartaoDTO> selecionarPorCliente(int id) throws ExcecaoDeNegocios {
		PilhaDeMensagensDeNegocios mensagens = PilhaDeMensagensDeNegocios.novaInstancia();
		List<Cartao> listaDeCartao = iCartaoService.selecionarPorCliente(mensagens, id);
		List<CartaoDTO> listaDeCartaoDTO = new ArrayList<>();

		listaDeCartao.forEach(cartao -> {
			CartaoDTO cartaoDTO = new CartaoDTO(cartao);
			cartaoDTO.setMensagens(mensagens);
			listaDeCartaoDTO.add(cartaoDTO);
		});

		return listaDeCartaoDTO;
	}

	@Override
	public CartaoDTO salvar(CartaoDTO cartao) throws ExcecaoDeNegocios {
		PilhaDeMensagensDeNegocios mensagens = PilhaDeMensagensDeNegocios.novaInstancia();
		try {
			iCartaoService.salvar(mensagens, cartao.retornarObjetoModelo());
			cartao.setMensagens(mensagens);
			return cartao;
		} catch (ExcecaoDeNegocios e) {
			cartao.setMensagens(mensagens);
			throw e;
		}

	}

	@Override
	public CartaoDTO atualizar(CartaoDTO cartao) throws ExcecaoDeNegocios {
		PilhaDeMensagensDeNegocios mensagens = PilhaDeMensagensDeNegocios.novaInstancia();
		try {
			iCartaoService.atualizar(mensagens, cartao.retornarObjetoModelo());
			cartao.setMensagens(mensagens);
			return cartao;
		} catch (Exception e) {
			cartao.setMensagens(mensagens);
			throw e;
		}

	}

	@Override
	public CartaoDTO deletar(int id) throws ExcecaoDeNegocios {
		PilhaDeMensagensDeNegocios mensagens = PilhaDeMensagensDeNegocios.novaInstancia();
		try {
			iCartaoService.deletar(mensagens, id);
			return CartaoDTO.builder().id(id).build();
		} catch (Exception e) {
			CartaoDTO cartao = CartaoDTO.builder().id(id).build();
			cartao.setMensagens(mensagens);
			throw e;
		}

	}

}
