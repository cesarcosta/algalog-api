package com.algaworks.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.EntregaRequest;
import com.algaworks.algalog.api.model.EntregaResponse;
import com.algaworks.algalog.domain.model.Entrega;

import lombok.AllArgsConstructor;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 01/08/2022
 */
@AllArgsConstructor
@Component
public class EntregaMapper {

	private ModelMapper modelMapper;

	public EntregaResponse toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaResponse.class);
	}

	public List<EntregaResponse> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaRequest request) {
		return modelMapper.map(request, Entrega.class);
	}
}