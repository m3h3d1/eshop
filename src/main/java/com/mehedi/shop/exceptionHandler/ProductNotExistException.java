package com.mehedi.shop.exceptionHandler;

public class ProductNotExistException extends RuntimeException {
	private final String message;

	public ProductNotExistException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
