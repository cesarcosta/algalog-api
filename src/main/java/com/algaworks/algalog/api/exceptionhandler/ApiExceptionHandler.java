package com.algaworks.algalog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.exception.NegocioException;

import lombok.AllArgsConstructor;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 30/07/2022
 */
@ControllerAdvice
@AllArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ErrorHandler.Campo> campos = new ArrayList<>();

		for (ObjectError item : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) item).getField();
			campos.add(new ErrorHandler.Campo(nome, messageSource.getMessage(item, LocaleContextHolder.getLocale())));
		}

		ErrorHandler error = new ErrorHandler();
		error.setStatus(status.value());
		error.setDataHora(OffsetDateTime.now());
		error.setTitulo("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");
		error.setCampos(campos);

		return handleExceptionInternal(ex, error, headers, status, request);
	}
	
	/**
	 * @author César Rangel - cesarrangelfonseca@gmail.com
	 * @since 31/07/2022
	 */
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocioException(NegocioException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		ErrorHandler error = new ErrorHandler();
		error.setStatus(status.value());
		error.setDataHora(OffsetDateTime.now());
		error.setTitulo(ex.getMessage());
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> handleEntidadeNaoEncontradaException(NegocioException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		ErrorHandler error = new ErrorHandler();
		error.setStatus(status.value());
		error.setDataHora(OffsetDateTime.now());
		error.setTitulo(ex.getMessage());
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
	}
}