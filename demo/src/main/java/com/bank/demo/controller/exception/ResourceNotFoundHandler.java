package com.bank.demo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.demo.service.exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceNotFoundHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
		ErrorResponse msg = new ErrorResponse();
		msg.setCode(1);
		msg.setMessage("Item Not found");
		msg.setDetails("The identifier you submitted doesn't exist");

		return new ResponseEntity<ErrorResponse>(msg, HttpStatus.NOT_FOUND);

	}
}
