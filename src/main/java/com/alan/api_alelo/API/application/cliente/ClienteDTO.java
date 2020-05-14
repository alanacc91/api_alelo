package com.alan.api_alelo.API.application.cliente;

import com.alan.api_alelo.API.application.RespostaDTO;
import com.alan.api_alelo.DOMAIN.cliente.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de transferencia de dados da entidade Cliente
 * 
 * @author alan.cardoso 13.05.2020
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ClienteDTO extends RespostaDTO {
	private Integer id;
	private String nome;

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
	}

	public Cliente retornarObjetoModelo() {
		return Cliente
				.builder()
				.id(this.id)
				.nome(this.nome)
				.build();
	}
}
