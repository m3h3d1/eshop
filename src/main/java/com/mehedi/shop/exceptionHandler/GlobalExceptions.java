package com.mehedi.shop.exceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.TransientPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<?> handleEntityNotFoundException() {
		return new ResponseEntity<>(
				new EntityNotFoundException("product or customer not found").getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ TransientPropertyValueException.class })
	public ResponseEntity<?> handleTransientPropertyValueException() {
		return new ResponseEntity<>(
				new ProductNotExistException("Customer is not found").getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ SQLIntegrityConstraintViolationException.class })
	public ResponseEntity<?> handleTSQLIntegrityConstraintViolationException() {
		return new ResponseEntity<>(
				new SQLIntegrityConstraintViolationException("Can't be modified or deleted").getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ ProductNotExistException.class })
	public ResponseEntity<?> handleProductNotExistException(ProductNotExistException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
