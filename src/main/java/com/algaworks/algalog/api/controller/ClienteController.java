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

import com.algaworks.algalog.api.mapper.ClienteMapper;
import com.algaworks.algalog.api.model.ClienteRequest;
import com.algaworks.algalog.api.model.ClienteResponse;
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
	
	private ClienteMapper clienteMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponse salvar(@Valid @RequestBody ClienteRequest cliente) {
		Cliente novoCliente = clienteMapper.toEntity(cliente);
		Cliente clienteSalvo = clienteService.salvar(novoCliente);
		return clienteMapper.toModel(clienteSalvo);
	}

	@GetMapping
	public List<ClienteResponse> listar() {
		List<Cliente> clientes = clienteService.buscarTodos();
		return clienteMapper.toCollectionModel(clientes);
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<ClienteResponse> buscarPorId(@PathVariable Long clienteId) {
		return clienteService.findById(clienteId).map(cliente -> ResponseEntity.ok(clienteMapper.toModel(cliente)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{clienteId}")
	public ResponseEntity<ClienteResponse> alterar(@PathVariable Long clienteId, @Valid @RequestBody ClienteRequest cliente) {
		var clienteEncontrado = clienteService.existsById(clienteId);

		if (!clienteEncontrado) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente clienteAlterado = clienteMapper.toEntity(cliente);
		clienteAlterado.setId(clienteId);

		clienteAlterado = clienteService.salvar(clienteAlterado);

		return ResponseEntity.ok(clienteMapper.toModel(clienteAlterado));
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