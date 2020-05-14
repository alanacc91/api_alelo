package com.alan.api_alelo.DOMAIN.cartao.service.validations;

import java.util.function.Predicate;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;

public class CartaoTemIdentificador {
	public static Predicate<Cartao> naoForValido() {

		return c -> {
			if (c == null || c.getId() == null || c.getId() < 1) {
				return true;
			}
			return false;
		};
	}
}
