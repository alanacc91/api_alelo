package com.alan.api_alelo.DOMAIN.cartao.service.validations;

import java.time.LocalDate;
import java.util.function.Predicate;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;

public class ValidadeCartaoMaiorQueADataAtual {
	public static Predicate<Cartao> naoForValido() {

		return c -> {
			if (c == null || c.getDataDeVencimento() == null || !(c.getDataDeVencimento().isAfter(LocalDate.now()))) {
				return true;
			}
			return false;
		};
	}
}
