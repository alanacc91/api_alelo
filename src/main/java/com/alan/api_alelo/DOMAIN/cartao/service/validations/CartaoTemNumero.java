package com.alan.api_alelo.DOMAIN.cartao.service.validations;

import java.util.function.Predicate;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;

public class CartaoTemNumero {
	public static Predicate<Cartao> naoForValido() {

		return c -> {
			if (c == null || c.getNumero() == null || "".equals(c.getNumero().trim())) {
				return true;
			}
			return false;
		};
	}
}
