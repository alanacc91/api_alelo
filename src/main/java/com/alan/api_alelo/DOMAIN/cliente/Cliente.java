package com.alan.api_alelo.DOMAIN.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe modelo da entidade Cliente
 * 
 * @author alan.cardoso 12.05.2020
 */
@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLI_SEQ")
	@SequenceGenerator(sequenceName = "CLIENTE_SEQ", allocationSize = 1, name = "CLI_SEQ")
	private Integer id;
	private String nome;
}
