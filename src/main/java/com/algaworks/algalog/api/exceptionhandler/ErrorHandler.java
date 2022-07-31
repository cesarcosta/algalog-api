package com.algaworks.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 30/07/2022
 */
@Data
@JsonInclude(Include.NON_NULL)
public class ErrorHandler {

	private Integer status;
	
	private LocalDateTime dataHora;
	
	private String titulo;
	
	private List<Campo> campos;
	
	@AllArgsConstructor
	@Getter
	public static class Campo {
		
		private String nome;
		
		private String mensagem;
	}
}
