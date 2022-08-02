package com.algaworks.algalog.api.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 01/08/2022
 */
@Getter
@Setter
public class DestinatarioRequest {

	private String nome;

	private String logradouro;

	private String numero;

	private String complemento;

	private String bairro;
}