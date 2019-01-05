package com.cg.mps.exception;

public class MobilePurchaseSystemException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String message;

	public MobilePurchaseSystemException() {
		super();
	}

	public MobilePurchaseSystemException(String message) {
		super();
		this.message = message;
	}
	

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "MobilePurchaseSystemException message=" + message;
	}
	

}
