package com.school.registrationdata.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegistrationDataNotFoundException extends RuntimeException {

	public RegistrationDataNotFoundException(String message) {
		super(message);
	}
	
}
