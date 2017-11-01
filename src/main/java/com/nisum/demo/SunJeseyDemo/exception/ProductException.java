package com.nisum.demo.SunJeseyDemo.exception;

public class ProductException extends Exception {

	private String errorCode;
	private String errorMessage;

	public ProductException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProductException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductException(String message, String errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = message;
	}

	public ProductException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
