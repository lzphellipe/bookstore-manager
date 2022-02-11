package com.valdir.bookstore.controller.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException exception) {
		return builResponseEntity(HttpStatus.NOT_FOUND, exception.getMessage(),
				Collections.singletonList(exception.getMessage()));
	}

	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<Object> entityEntityExistsException(EntityExistsException exception) {
		return builResponseEntity(HttpStatus.BAD_REQUEST, exception.getMessage(),
				Collections.singletonList(exception.getMessage()));
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		ex.getBindingResult().getFieldErrors().forEach(fieldError -> errors
				.add("Field " + fieldError.getField().toUpperCase() + " " + fieldError.getDefaultMessage()));
		
		ex.getBindingResult().getGlobalErrors().forEach(globalError -> errors
				.add("Object " + globalError.getObjectName() + " " + globalError.getDefaultMessage()));
		return builResponseEntity(HttpStatus.BAD_REQUEST, "Informed argument(s) validation error(s)", errors);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return builResponseEntity(HttpStatus.BAD_REQUEST, "Malformad error JSON body and/or field error", Collections.singletonList(ex.getLocalizedMessage()));
	}

	private ResponseEntity<Object> builResponseEntity(HttpStatus httpStatus, String message, List<String> errors) {
		StandardError error = new StandardError(LocalDateTime.now(), httpStatus.getReasonPhrase(), message, errors);
		return ResponseEntity.status(httpStatus).body(error);
	}
}
