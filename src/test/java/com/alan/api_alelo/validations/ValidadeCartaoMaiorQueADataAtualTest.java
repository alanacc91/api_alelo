package com.alan.api_alelo.validations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;
import com.alan.api_alelo.DOMAIN.cartao.service.validations.ValidadeCartaoMaiorQueADataAtual;

class ValidadeCartaoMaiorQueADataAtualTest {

	@Test
	public void testNaoForValido() {

		LocalDate dataAtual = LocalDate.now();

		Cartao cartao = Cartao.builder().dataDeVencimento(
				LocalDate.of(dataAtual.getYear(), dataAtual.getMonth(), dataAtual.getDayOfMonth() - 1)).build();
		assertEquals(true, ValidadeCartaoMaiorQueADataAtual.naoForValido().test(cartao));

		cartao = Cartao.builder().dataDeVencimento(dataAtual).build();
		assertEquals(true, ValidadeCartaoMaiorQueADataAtual.naoForValido().test(cartao));

		cartao = Cartao.builder().dataDeVencimento(
				LocalDate.of(dataAtual.getYear(), dataAtual.getMonth(), dataAtual.getDayOfMonth() + 1)).build();
		assertEquals(false, ValidadeCartaoMaiorQueADataAtual.naoForValido().test(cartao));

	}

}
