package com.alan.api_alelo.utils.excecao;

import com.alan.api_alelo.utils.mensagem.PilhaDeMensagensDeNegocios;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ExcecaoDeNegocios extends Exception {

	private static final long serialVersionUID = 3811732567958190699L;
	@Getter
	private PilhaDeMensagensDeNegocios mensagens;

	public ExcecaoDeNegocios(String mensagem) {
		super(mensagem);
	}

	public ExcecaoDeNegocios(PilhaDeMensagensDeNegocios mensagens) {
		super();
		this.mensagens = mensagens;
	}

}
