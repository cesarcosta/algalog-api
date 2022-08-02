package com.algaworks.algalog.api.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 01/08/2022
 */
@Getter
@Setter
public class ClienteIdRequest {

	@NotNull
	private Long id;
}
