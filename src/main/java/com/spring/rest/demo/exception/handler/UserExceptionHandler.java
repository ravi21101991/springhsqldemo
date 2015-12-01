package com.spring.rest.demo.exception.handler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.rest.demo.exception.UserException;
import com.spring.rest.demo.wrapper.UserExceptionWrapper;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(value = UserException.class)
	public @ResponseBody UserExceptionWrapper handleUserException(UserException userException, HttpServletResponse response) {
		UserExceptionWrapper userExceptionWrapper = new UserExceptionWrapper();
		userExceptionWrapper.setErrorCode(userException.getErrorCode());
		userExceptionWrapper.setErrorMessage(userException.getErrorMessage());
		response.setStatus(getStatusCode(userException.getErrorCode()));
		return userExceptionWrapper;
	}

	private int getStatusCode(String message) {
		String strStatus = message.substring(3);
		int status = Integer.parseInt(strStatus);
		return status;
	}
}
