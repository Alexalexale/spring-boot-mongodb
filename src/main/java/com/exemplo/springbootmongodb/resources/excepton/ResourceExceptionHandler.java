package com.exemplo.springbootmongodb.resources.excepton;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exemplo.springbootmongodb.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objecNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;

		StandardError standardError = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado",
				e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(standardError);
	}

}