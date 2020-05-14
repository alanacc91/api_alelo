package com.alan.api_alelo.API.controller.cartao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alan.api_alelo.API.application.cartao.CartaoDTO;
import com.alan.api_alelo.API.application.cartao.ICartaoAppService;
import com.alan.api_alelo.utils.excecao.ExcecaoDeNegocios;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "API com recursos do serviço de cartões.")
@RequestMapping(path = "/alelo/v1/cartao")
public class CartaoController {

	@Autowired
	ICartaoAppService iCartaoAppService;

	@ApiOperation(value = "Seleciona todos os cartões de forma páginada.", response = CartaoDTO.class)
	@GetMapping("/paginados/{page}/{size}")
	public ResponseEntity<?> selecionarTodosPaginados(@PathVariable int page, @PathVariable int size) {
		List<CartaoDTO> resposta = null;
		try {
			resposta = iCartaoAppService.selecionarTodosPaginados(page, size);
			return new ResponseEntity<>(resposta, HttpStatus.OK);
		} catch (ExcecaoDeNegocios e) {
			return new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Seleciona todos os cartões.", response = CartaoDTO.class)
	@GetMapping("/todos")
	public ResponseEntity<?> selecionarTodos() {
		List<CartaoDTO> resposta = null;
		try {
			resposta = iCartaoAppService.selecionarTodos();
			return new ResponseEntity<>(resposta, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Seleciona um cartão pelo seu identificador.", response = CartaoDTO.class)
	@GetMapping("/id/{id}")
	public ResponseEntity<?> selecionarPorId(@PathVariable Integer id) {
		CartaoDTO resposta = null;
		try {
			resposta = iCartaoAppService.selecionarPorId(id);
			return new ResponseEntity<>(resposta, HttpStatus.OK);
		} catch (ExcecaoDeNegocios e) {
			return new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Seleciona um cartão pelo seu número.", response = CartaoDTO.class)
	@GetMapping("/numero/{numero}")
	public ResponseEntity<?> selecionarPorNumero(@PathVariable String numero) {
		CartaoDTO resposta = null;
		try {
			resposta = iCartaoAppService.selecionarPorNumero(numero);
			return new ResponseEntity<>(resposta, HttpStatus.OK);
		} catch (ExcecaoDeNegocios e) {
			return new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Seleciona todos os cartões pelo identificador do cliente.", response = CartaoDTO.class)
	@GetMapping("/cliente/{cliente}")
	public ResponseEntity<?> selecionarPorCliente(@PathVariable int cliente) {
		List<CartaoDTO> resposta = null;
		try {
			resposta = iCartaoAppService.selecionarPorCliente(cliente);
			return new ResponseEntity<>(resposta, HttpStatus.OK);
		} catch (ExcecaoDeNegocios e) {
			return new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Salva um cartão.", response = CartaoDTO.class)
	@PostMapping
	@Transactional
	public ResponseEntity<?> salvar(@RequestBody CartaoDTO cartao) {
		try {
			cartao = iCartaoAppService.salvar(cartao);
			return new ResponseEntity<>(cartao, HttpStatus.OK);
		} catch (ExcecaoDeNegocios e) {
			return new ResponseEntity<>(cartao, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Atualiza um cartão.", response = CartaoDTO.class)
	@PutMapping
	@Transactional
	public ResponseEntity<?> atualizar(@RequestBody CartaoDTO cartao) {
		try {
			cartao = iCartaoAppService.atualizar(cartao);
			return new ResponseEntity<>(cartao, HttpStatus.OK);
		} catch (ExcecaoDeNegocios e) {
			return new ResponseEntity<>(cartao, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Deleta um cartão.", response = CartaoDTO.class)
	@DeleteMapping
	@Transactional
	public ResponseEntity<?> deletar(@RequestBody CartaoDTO cartao) {
		try {
			cartao = iCartaoAppService.deletar(cartao);
			return new ResponseEntity<>(cartao, HttpStatus.OK);
		} catch (ExcecaoDeNegocios e) {
			return new ResponseEntity<>(cartao, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
