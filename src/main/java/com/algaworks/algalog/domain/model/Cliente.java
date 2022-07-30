package com.algaworks.algalog.domain.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 30/07/2022
 */
@Getter
@Setter
public class Cliente {

	private Long id;

	private String nome;

	private String email;

	private String telefone;

}