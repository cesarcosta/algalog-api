package com.algaworks.algalog.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 01/08/2022
 */
@Getter
@Setter
public class OcorrenciaResponse {

	private Long id;
	
	private String descricao;
	
	private OffsetDateTime dataRegistro;
}
