package com.alan.api_alelo.utils.mensagem;

import lombok.Getter;

@Getter
public class MensagemDeNegocios {
	public MensagemDeNegocios(String message, NivelDeMensagemDeNegocios nivel) {
		this.mensagem = message;
		this.nivel = nivel;
	}

	private NivelDeMensagemDeNegocios nivel;
	private String mensagem;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MensagemDeNegocios other = (MensagemDeNegocios) obj;
		if (nivel != other.nivel)
			return false;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		return true;
	}

}
