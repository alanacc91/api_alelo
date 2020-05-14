package com.alan.api_alelo.API.application.cartao;

import java.time.LocalDate;

import com.alan.api_alelo.API.application.RespostaDTO;
import com.alan.api_alelo.API.application.cliente.ClienteDTO;
import com.alan.api_alelo.DOMAIN.cartao.Cartao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de transferencia de dados da entidade Cartao
 * 
 * @author alan.cardoso 13.05.2020
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CartaoDTO extends RespostaDTO {

	private Integer id;
	private String numero;
	private LocalDate dataDeVencimento;
	private ClienteDTO cliente;

	public CartaoDTO(Cartao cartao) {
		this.id = cartao.getId();
		this.numero = cartao.getNumero();
		this.dataDeVencimento = cartao.getDataDeVencimento();
		this.cliente = new ClienteDTO(cartao.getCliente());
	}

	public Cartao retornarObjetoModelo() {
		return Cartao.builder().cliente(this.cliente.retornarObjetoModelo()).dataDeVencimento(this.dataDeVencimento)
				.id(this.id).numero(this.numero).build();
	}

}
