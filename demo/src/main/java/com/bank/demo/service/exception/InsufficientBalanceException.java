package com.bank.demo.service.exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends RuntimeException {

	public InsufficientBalanceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
