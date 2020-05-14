package com.alan.api_alelo.INFRA.cartao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alan.api_alelo.DOMAIN.cartao.Cartao;

/**
 * Interface JPA da entidade Cartao
 * 
 * @author alan.cardoso 12.05.2020
 *
 */
@Repository
public interface ICartaoJPARepository extends JpaRepository<Cartao, Integer> {

	Optional<Cartao> findByNumero(String numero);

	List<Cartao> findByClienteId(int id);

}
