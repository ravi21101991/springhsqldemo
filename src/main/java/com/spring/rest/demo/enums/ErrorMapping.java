package com.spring.rest.demo.enums;

public enum ErrorMapping {

	USER_NOT_FOUND("USR404","The requested user was not found.");
	private String errorCode;
	private String errorMessage;

	private ErrorMapping(String errorCode, String errorMessage) {
		this.setErrorCode(errorCode);
		this.setErrorMessage(errorMessage);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
