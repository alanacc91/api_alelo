package com.alan.api_alelo.utils.mensagem;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.Getter;

public class PilhaDeMensagensDeNegocios {
	@Getter
	private Set<MensagemDeNegocios> mensagemDeNegocios;

	private PilhaDeMensagensDeNegocios() {
		this.mensagemDeNegocios = new LinkedHashSet<>();
	}

	public static PilhaDeMensagensDeNegocios novaInstancia() {
		return new PilhaDeMensagensDeNegocios();
	}

	public boolean existirMensagensDeErro() {
		return existirMensagem(NivelDeMensagemDeNegocios.ERROR);
	}

	public boolean existirMensagensDeInformacoes() {
		return existirMensagem(NivelDeMensagemDeNegocios.INFO);
	}

	public boolean existirMensagensDeAviso() {
		return existirMensagem(NivelDeMensagemDeNegocios.WARN);
	}

	public boolean existirMensagens() {
		return this.mensagemDeNegocios != null && !this.mensagemDeNegocios.isEmpty();
	}

	public void limparMensagens() {

		if (this.mensagemDeNegocios != null) {
			this.mensagemDeNegocios.clear();
		}
	}

	public void adicionarMensagem(String mensagem, NivelDeMensagemDeNegocios nivel) {

		if (mensagem != null && !"".equals(mensagem.trim()) && nivel != null) {
			this.mensagemDeNegocios.add(new MensagemDeNegocios(mensagem, nivel));
		}
	}

	private boolean existirMensagem(NivelDeMensagemDeNegocios nivel) {

		if (this.mensagemDeNegocios == null || this.mensagemDeNegocios.isEmpty()) {
			return false;
		}

		for (MensagemDeNegocios mensagemDeNegocios : this.mensagemDeNegocios) {
			if (mensagemDeNegocios.getNivel().equals(nivel)) {
				return true;
			}
		}

		return false;
	}
}
