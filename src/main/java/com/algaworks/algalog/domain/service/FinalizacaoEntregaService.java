package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 01/08/2022
 */
@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

	private BuscaEntregaService buscaEntregaService;
	
	private EntregaRepository entregaRepository;
	
	@Transactional
	public void finalizar(Long idEntrega) {
		Entrega entrega = buscaEntregaService.buscar(idEntrega);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}
}
