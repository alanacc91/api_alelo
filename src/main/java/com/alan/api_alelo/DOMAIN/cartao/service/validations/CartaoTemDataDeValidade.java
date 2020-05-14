package com.alan.api_alelo.DOMAIN.cartao.service.validations;

import java.util.function.Predicate;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;

public class CartaoTemDataDeValidade {
	public static Predicate<Cartao> naoForValido() {

		return c -> {
			if (c == null || c.getDataDeVencimento() == null) {
				return true;
			}
			return false;
		};
	}
}
