package com.algaworks.algalog.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 01/08/2022
 */
@Getter
@Setter
public class EntregaRequest {

	@Valid
	@NotNull
	private ClienteIdRequest cliente;

	@Valid
	@NotNull
	private DestinatarioRequest destinatario;

	@NotNull
	private BigDecimal taxa;

}