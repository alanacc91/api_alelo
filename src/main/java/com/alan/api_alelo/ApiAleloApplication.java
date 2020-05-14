package com.alan.api_alelo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;
import com.alan.api_alelo.DOMAIN.cartao.service.ICartaoService;
import com.alan.api_alelo.DOMAIN.cliente.Cliente;
import com.alan.api_alelo.DOMAIN.cliente.service.IClienteService;
import com.alan.api_alelo.utils.excecao.ExcecaoDeNegocios;
import com.alan.api_alelo.utils.mensagem.PilhaDeMensagensDeNegocios;

@SpringBootApplication
public class ApiAleloApplication {

	@Autowired
	IClienteService iClienteService;

	@Autowired
	ICartaoService iCartaoService;

	public static void main(String[] args) {
		SpringApplication.run(ApiAleloApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void iniciarDadosNaBaseDeDados() {
		try {
			Cliente cliente = Cliente.builder().nome("Steve Rogers").build();
			iClienteService.salvar(cliente);
			cliente = iClienteService.selecionarPorNome("Steve Rogers");

			Cartao cartao = Cartao.builder().cliente(cliente).dataDeVencimento(LocalDate.of(2080, 01, 01))
					.numero("0000 0000 0000 0000").build();
			iCartaoService.salvar(PilhaDeMensagensDeNegocios.novaInstancia(), cartao);

			cliente = Cliente.builder().nome("Tony Stark").build();
			iClienteService.salvar(cliente);
			cliente = iClienteService.selecionarPorNome("Tony Stark");

			cartao = Cartao.builder().cliente(cliente).dataDeVencimento(LocalDate.of(2028, 01, 01))
					.numero("1111 1111 1111 1111").build();
			iCartaoService.salvar(PilhaDeMensagensDeNegocios.novaInstancia(), cartao);

			cliente = Cliente.builder().nome("Thor Odinson").build();
			iClienteService.salvar(cliente);
			cliente = iClienteService.selecionarPorNome("Thor Odinson");

			cartao = Cartao.builder().cliente(cliente).dataDeVencimento(LocalDate.of(3099, 12, 31))
					.numero("2222 2222 2222 2222").build();
			iCartaoService.salvar(PilhaDeMensagensDeNegocios.novaInstancia(), cartao);

			cliente = Cliente.builder().nome("Bruce Banner").build();
			iClienteService.salvar(cliente);
			cliente = iClienteService.selecionarPorNome("Bruce Banner");

			cartao = Cartao.builder().cliente(cliente).dataDeVencimento(LocalDate.of(2020, 11, 30))
					.numero("3333 3333 3333 3333").build();
			iCartaoService.salvar(PilhaDeMensagensDeNegocios.novaInstancia(), cartao);

		} catch (ExcecaoDeNegocios e) {
			e.printStackTrace();
		}
	}
}
