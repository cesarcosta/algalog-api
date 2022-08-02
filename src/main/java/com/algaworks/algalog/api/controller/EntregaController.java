package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.mapper.EntregaMapper;
import com.algaworks.algalog.api.model.EntregaRequest;
import com.algaworks.algalog.api.model.EntregaResponse;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.FinalizacaoEntregaService;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 31/07/2022
 */
@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	private FinalizacaoEntregaService finalizacaoEntregaService; 

	private EntregaRepository entregaRepository;

	private EntregaMapper entregaMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaResponse criar(@Valid @RequestBody EntregaRequest entrega) {
		Entrega novaEntrega = entregaMapper.toEntity(entrega);
		Entrega result = solicitacaoEntregaService.solicitar(novaEntrega);
		return entregaMapper.toModel(result);
	}

	@GetMapping
	public List<EntregaResponse> listar() {
		List<Entrega> entregas = entregaRepository.findAll();
		return entregaMapper.toCollectionModel(entregas);
	}

	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaResponse> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId).map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}
}