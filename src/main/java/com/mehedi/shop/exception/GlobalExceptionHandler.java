package com.mehedi.shop.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.TransientPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<?> handleEntityNotFoundException() {
		return new ResponseEntity<>(new EntityNotFoundException("product or customer not found").getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ TransientPropertyValueException.class })
	public ResponseEntity<?> handleTransientPropertyValueException() {
		return new ResponseEntity<>(new ProductNotExistException("Customer is not found").getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ SQLIntegrityConstraintViolationException.class })
	public ResponseEntity<?> handleTSQLIntegrityConstraintViolationException() {
		return new ResponseEntity<>(
				new SQLIntegrityConstraintViolationException("You can't modify or delete").getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ ProductNotExistException.class })
	public ResponseEntity<?> handleProductNotExistException(ProductNotExistException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
