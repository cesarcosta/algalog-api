package com.algaworks.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.ClienteRequest;
import com.algaworks.algalog.api.model.ClienteResponse;
import com.algaworks.algalog.domain.model.Cliente;

import lombok.AllArgsConstructor;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 01/08/2022
 */
@AllArgsConstructor
@Component
public class ClienteMapper {

	private ModelMapper modelMapper;

	public ClienteResponse toModel(Cliente cliente) {
		return modelMapper.map(cliente, ClienteResponse.class);
	}

	public List<ClienteResponse> toCollectionModel(List<Cliente> clientes) {
		return clientes.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Cliente toEntity(ClienteRequest request) {
		return modelMapper.map(request, Cliente.class);
	}
}