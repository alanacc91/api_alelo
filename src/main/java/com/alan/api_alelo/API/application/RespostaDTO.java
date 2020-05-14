package com.alan.api_alelo.API.application;

import com.alan.api_alelo.utils.mensagem.PilhaDeMensagensDeNegocios;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public abstract class RespostaDTO {
	
	private PilhaDeMensagensDeNegocios mensagens;
}
