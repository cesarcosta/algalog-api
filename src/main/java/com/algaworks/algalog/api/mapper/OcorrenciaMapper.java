package com.algaworks.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.OcorrenciaResponse;
import com.algaworks.algalog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 01/08/2022
 */
@AllArgsConstructor
@Component
public class OcorrenciaMapper {

	private ModelMapper modelMapper;

	public OcorrenciaResponse toModel(Ocorrencia cliente) {
		return modelMapper.map(cliente, OcorrenciaResponse.class);
	}

	public List<OcorrenciaResponse> toCollectionModel(List<Ocorrencia> clientes) {
		return clientes.stream().map(this::toModel).collect(Collectors.toList());
	}
}