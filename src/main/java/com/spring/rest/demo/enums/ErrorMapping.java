package com.spring.rest.demo.enums;

public enum ErrorMapping {

	USER_NOT_FOUND("USR404", "The requested user was not found."),
	USERS_NOT_FOUND("USS404", "No users found."),
	INVALID_AGE("UAG400", "User age invalid."),
	INVALID_FIRST_NAME("UFN400", "Invalid first name."),
	INVALID_LAST_NAME("ULN400", "Invalid last name."),
	INVALID_FIRST_NAME_PATTERN("UFN400", "Only alphabets allowed in first name."),
	INVALID_MIDDLE_NAME_PATTERN("UMN400", "Only alphabets allowed in middle name."),
	INVALID_LAST_NAME_PATTERN("ULN400", "Only alphabets allowed in last name."),
	EMPTY_PHONE_NUMBER("PHE400", "Phone number cannot be empty."),
	INVALID_PHONE_NUMBER("INP400", "Invalid phone number."),
	INVALID_PHONE_NUMBER_LENGTH("IPL400", "Phone number length must be 10."),
	GENDER_MANDATORY("GEN400", "Gender is mandatory."),
	INVALID_GENDER("GEV400", "Invalid gender only M or F allowed."),
	USER_ALREADY_EXISTS("USR400", "User with given first and last name already exists.");
	

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
