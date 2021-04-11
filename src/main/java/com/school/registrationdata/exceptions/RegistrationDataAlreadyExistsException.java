package com.school.registrationdata.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RegistrationDataAlreadyExistsException extends RuntimeException {

	public RegistrationDataAlreadyExistsException(String message) {
		super(message);
	}
	
}
