package com.spring.rest.demo.exception;

import com.spring.rest.demo.enums.ErrorMapping;

public class UserException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String errorCode;
	private String errorMessage;

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

	public UserException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public UserException(ErrorMapping errorMapping) {
		this.errorCode = errorMapping.getErrorCode();
		this.errorMessage = errorMapping.getErrorMessage();
	}
}
