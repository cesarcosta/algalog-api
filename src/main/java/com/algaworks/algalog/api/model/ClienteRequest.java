package com.algaworks.algalog.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 01/08/2022
 */
@Getter
@Setter
public class ClienteRequest {
	
	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String telefone;
}
