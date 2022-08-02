package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.model.DestinatarioResponse;
import com.algaworks.algalog.api.model.EntregaResponse;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	private EntregaRepository entregaRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega criar(@Valid @RequestBody Entrega entrega) {
		return solicitacaoEntregaService.solicitar(entrega);
	}
	
	@GetMapping
	public List<Entrega> listar() {
		return entregaRepository.findAll();
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaResponse> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> {
					EntregaResponse response = new EntregaResponse();
					response.setId(entrega.getId());
					response.setNomeCliente(entrega.getCliente().getNome());
					response.setDestinatario(new DestinatarioResponse());
					response.getDestinatario().setNome(entrega.getDestinatario().getNome());
					response.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
					response.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
					response.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
					response.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
					response.setTaxa(entrega.getTaxa());
					response.setStatus(entrega.getStatus());
					response.setDataPedido(entrega.getDataPedido());
					response.setDataFinalizacao(entrega.getDataFinalizacao());
					return ResponseEntity.ok(response);
				})
				.orElse(ResponseEntity.notFound().build());
	}
}