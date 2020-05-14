package com.alan.api_alelo.INFRA.cartao.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

import org.springframework.jdbc.core.RowMapper;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;
import com.alan.api_alelo.DOMAIN.cliente.Cliente;

/**
 * Classe extratora da entidade Cartao
 * 
 * @author alan.cardoso
 * 12.05.2020
 */
public class CartaoRowMapper implements RowMapper<Cartao> {

	@Override
	public Cartao mapRow(ResultSet rs, int rowNum) throws SQLException {

		Cliente cliente = Cliente.builder().id(rs.getInt("CLIENTE")).build();
		return Cartao
				.builder()
				.cliente(cliente)
				.dataDeVencimento(rs.getDate("DATA_DE_VENCIMENTO") == null ? null
						: rs.getDate("DATA_DE_VENCIMENTO").toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
				.id(rs.getInt("ID"))
				.numero(rs.getString("NUMERO"))
				.build();
	}

}
