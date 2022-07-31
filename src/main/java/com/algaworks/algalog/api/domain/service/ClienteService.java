package com.algaworks.algalog.api.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.api.domain.exception.NegocioException;
import com.algaworks.algalog.api.domain.model.Cliente;
import com.algaworks.algalog.api.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 31/07/2022
 */
@Service
@AllArgsConstructor
public class ClienteService {

	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este email!");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Optional<Cliente> buscarPorId(Long id) {
		return clienteRepository.findById(id);
	}
	
	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}
	
	public boolean existsById(Long id) {
		return clienteRepository.existsById(id);
	}
}
