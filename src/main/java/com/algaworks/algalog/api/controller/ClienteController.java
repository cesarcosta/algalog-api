package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.service.ClienteService;

import lombok.AllArgsConstructor;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 30/07/2022
 */
@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteService clienteService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@Valid @RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}

	@GetMapping
	public List<Cliente> listar() {
		return clienteService.buscarTodos();
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long clienteId) {
		return clienteService.buscarPorId(clienteId).map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> alterar(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {
		var clienteEncontrado = clienteService.existsById(clienteId);

		if (!clienteEncontrado) {
			return ResponseEntity.notFound().build();
		}

		cliente.setId(clienteId);
		cliente = clienteService.salvar(cliente);

		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> excluir(@PathVariable Long clienteId) {
		var clienteEncontrado = clienteService.existsById(clienteId);

		if (!clienteEncontrado) {
			return ResponseEntity.notFound().build();
		}
		
		clienteService.excluir(clienteId);
		
		return ResponseEntity.noContent().build();
	}
}