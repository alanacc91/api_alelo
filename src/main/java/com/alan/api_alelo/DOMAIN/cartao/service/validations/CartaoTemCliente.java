package com.alan.api_alelo.DOMAIN.cartao.service.validations;

import java.util.function.Predicate;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;

public class CartaoTemCliente {
	public static Predicate<Cartao> naoForValido() {

		return c -> {
			if (c == null || c.getCliente() == null || c.getCliente().getId() == null) {
				return true;
			}
			return false;
		};
	}
}
