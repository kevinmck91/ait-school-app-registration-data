package com.school.registrationdata.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class RegistrationDataGenericException extends RuntimeException {

	public RegistrationDataGenericException(String message) {
		super(message);
	}
	
}
