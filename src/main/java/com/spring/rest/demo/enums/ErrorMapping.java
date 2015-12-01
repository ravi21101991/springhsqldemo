package com.spring.rest.demo.enums;

public enum ErrorMapping {

	USER_NOT_FOUND("USR404", "The requested user was not found."), 
	INVALID_AGE("UAG400", "User age invalid."),
	INVALID_FIRST_NAME("UFN400", "Invalid first name."),
	INVALID_LAST_NAME("ULN400", "Invalid last name."),
	INVALID_FIRST_NAME_PATTERN("UFN400", "Only alphabets allowed in first name."),
	INVALID_MIDDLE_NAME_PATTERN("UMN400", "Only alphabets allowed in middle name."),
	INVALID_LAST_NAME_PATTERN("ULN400", "Only alphabets allowed in last name.");
	

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
