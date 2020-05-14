package com.alan.api_alelo.DOMAIN.cartao;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.alan.api_alelo.DOMAIN.cliente.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe modelo da entidade Cartao
 * 
 * @author alan.cardoso 12.05.2020
 */
@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ")
	@SequenceGenerator(sequenceName = "CARTAO_SEQ", allocationSize = 1, name = "CART_SEQ")
	private Integer id;

	@Column(unique = true, nullable = false)
	private String numero;

	@JoinColumn(nullable = false)
	private LocalDate dataDeVencimento;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;

}
