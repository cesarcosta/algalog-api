package com.algaworks.algalog.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 31/07/2022
 */
@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private EntregaRepository entregaRepository;
	
	private ClienteService clienteService;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteService.buscarPorId(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		return entregaRepository.save(entrega);
	}
}