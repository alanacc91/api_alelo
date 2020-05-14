package com.alan.api_alelo.DOMAIN.cartao.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;
import com.alan.api_alelo.DOMAIN.cartao.repository.ICartaoRepository;
import com.alan.api_alelo.DOMAIN.cartao.service.validations.CartaoTemCliente;
import com.alan.api_alelo.DOMAIN.cartao.service.validations.CartaoTemDataDeValidade;
import com.alan.api_alelo.DOMAIN.cartao.service.validations.CartaoTemIdentificador;
import com.alan.api_alelo.DOMAIN.cartao.service.validations.CartaoTemNumero;
import com.alan.api_alelo.DOMAIN.cartao.service.validations.ValidadeCartaoMaiorQueADataAtual;
import com.alan.api_alelo.utils.excecao.ExcecaoDeNegocios;
import com.alan.api_alelo.utils.mensagem.NivelDeMensagemDeNegocios;
import com.alan.api_alelo.utils.mensagem.PilhaDeMensagensDeNegocios;

@Service
public class CartaoService implements ICartaoService {

	@Autowired
	ICartaoRepository iCartaoRepository;

	@Override
	public Page<Cartao> selecionarTodosPaginados(PilhaDeMensagensDeNegocios mensagens, int numeroDaPagina,
			int quantidadeDePaginas) throws ExcecaoDeNegocios {
		try {
			if (quantidadeDePaginas <= 0) {
				mensagens.adicionarMensagem("Quantidade de paginas não pode ser zero!",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (mensagens.existirMensagensDeErro()) {
				throw new ExcecaoDeNegocios(mensagens);
			}

			Pageable pageable = PageRequest.of(numeroDaPagina, quantidadeDePaginas);
			return iCartaoRepository.selecionarTodosPaginados(pageable);
		} catch (ExcecaoDeNegocios e) {
			throw e;
		}

	}

	@Override
	public List<Cartao> selecionarTodos() {
		return iCartaoRepository.selecionarTodos();
	}

	@Override
	public Cartao selecionarPorId(PilhaDeMensagensDeNegocios mensagens, Integer id) throws ExcecaoDeNegocios {

		try {
			if (id == null || id < 1) {
				mensagens.adicionarMensagem("Necessário incluir um Id válido para selecionar um cartão!",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (mensagens.existirMensagensDeErro()) {
				throw new ExcecaoDeNegocios(mensagens);
			}

			Optional<Cartao> optCartao = iCartaoRepository.selecionarPorId(id);
			return optCartao.orElse(null);
		} catch (ExcecaoDeNegocios e) {
			throw e;
		}
	}

	@Override
	public void salvar(PilhaDeMensagensDeNegocios mensagens, Cartao cartao) throws ExcecaoDeNegocios {
		try {
			if (CartaoTemNumero.naoForValido().test(cartao)) {
				mensagens.adicionarMensagem("Necessário inserir um número para o cartão!",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (CartaoTemCliente.naoForValido().test(cartao)) {
				mensagens.adicionarMensagem("Necessário inserir um cliente para o cartão!",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (CartaoTemDataDeValidade.naoForValido().test(cartao)) {
				mensagens.adicionarMensagem("Necessário inserir uma data de validade para o cartão",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (ValidadeCartaoMaiorQueADataAtual.naoForValido().test(cartao)) {
				mensagens.adicionarMensagem("Data de validade do cartao não pode ser maior que a data atual",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (mensagens.existirMensagensDeErro()) {
				throw new ExcecaoDeNegocios(mensagens);
			}

			iCartaoRepository.salvar(cartao);

			mensagens.adicionarMensagem("Cartão inserido com sucesso!", NivelDeMensagemDeNegocios.INFO);

		} catch (ExcecaoDeNegocios e) {
			throw e;
		}

	}

	@Override
	public void atualizar(PilhaDeMensagensDeNegocios mensagens, Cartao cartao) throws ExcecaoDeNegocios {
		try {
			if (CartaoTemIdentificador.naoForValido().test(cartao)) {
				mensagens.adicionarMensagem("Necessário inserir um identificador para atualizar o cartão!",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (CartaoTemNumero.naoForValido().test(cartao)) {
				mensagens.adicionarMensagem("Necessário inserir um número para o cartão!",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (CartaoTemCliente.naoForValido().test(cartao)) {
				mensagens.adicionarMensagem("Necessário inserir um cliente para o cartão!",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (CartaoTemDataDeValidade.naoForValido().test(cartao)) {
				mensagens.adicionarMensagem("Necessário inserir uma data de validade para o cartão",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (ValidadeCartaoMaiorQueADataAtual.naoForValido().test(cartao)) {
				mensagens.adicionarMensagem("Data de validade do cartao não pode ser maior que a data atual",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (mensagens.existirMensagensDeErro()) {
				throw new ExcecaoDeNegocios(mensagens);
			}

			iCartaoRepository.atualizar(cartao);

			mensagens.adicionarMensagem("Cartão atualizado com sucesso!", NivelDeMensagemDeNegocios.INFO);

		} catch (ExcecaoDeNegocios e) {
			throw e;
		}

	}

	@Override
	public void deletar(PilhaDeMensagensDeNegocios mensagens, int id) throws ExcecaoDeNegocios {
		try {
			if (id < 1) {
				mensagens.adicionarMensagem("Necessário inserir um identificador para deletar o cartão!",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (mensagens.existirMensagensDeErro()) {
				throw new ExcecaoDeNegocios(mensagens);
			}

			iCartaoRepository.deletar(id);

			mensagens.adicionarMensagem("Cartão deletado com sucesso!", NivelDeMensagemDeNegocios.INFO);

		} catch (ExcecaoDeNegocios e) {
			throw e;
		}

	}

	@Override
	public Cartao selecionarPorNumero(PilhaDeMensagensDeNegocios mensagens, String numero) throws ExcecaoDeNegocios {

		try {
			if (Strings.isEmpty(numero)) {
				mensagens.adicionarMensagem("Necessário incluir um número válido para selecionar um cartão!",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (mensagens.existirMensagensDeErro()) {
				throw new ExcecaoDeNegocios(mensagens);
			}

			Optional<Cartao> optCartao = iCartaoRepository.selecionarPorNumero(numero);
			return optCartao.orElse(null);
		} catch (ExcecaoDeNegocios e) {
			throw e;
		}
	}

	@Override
	public List<Cartao> selecionarPorCliente(PilhaDeMensagensDeNegocios mensagens, int id) throws ExcecaoDeNegocios {

		try {
			if (id < 1) {
				mensagens.adicionarMensagem(
						"Necessário incluir o identificador de um cliente válido para selecionar um cartão!",
						NivelDeMensagemDeNegocios.ERROR);
			}

			if (mensagens.existirMensagensDeErro()) {
				throw new ExcecaoDeNegocios(mensagens);
			}

			return iCartaoRepository.selecionarPorCliente(id);
		} catch (ExcecaoDeNegocios e) {
			throw e;
		}
	}

}
