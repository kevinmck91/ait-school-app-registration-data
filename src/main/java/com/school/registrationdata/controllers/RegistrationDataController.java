package com.school.registrationdata.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.school.registrationdata.exceptions.RegistrationDataAlreadyExistsException;
import com.school.registrationdata.exceptions.RegistrationDataGenericException;
import com.school.registrationdata.exceptions.RegistrationDataNotFoundException;
import com.school.registrationdata.dtos.RegistrationData;
import com.school.registrationdata.repositories.RegistrationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RegistrationDataController {

	@Autowired
	private RegistrationDataRepository registrationDataRepository;

	@GetMapping("registration-data/")
	public List<RegistrationData> getAllRegistrationData() {
		return registrationDataRepository.findAll();
	}
	
	@GetMapping("registration-data/{studentNumber}/")
	public Optional<RegistrationData> getRegistrationDataByStudentNumber(@PathVariable String studentNumber) {
		
		Optional<RegistrationData> RegistrationData = registrationDataRepository.findByStudentNumber(studentNumber);
		
		if(RegistrationData.isPresent()){
			return RegistrationData;
		}
		else{
			throw new RegistrationDataNotFoundException("Student number : " + studentNumber + " not found");
		}
		
	}

	@PostMapping("registration-data/")
	public ResponseEntity createStudent(@RequestBody RegistrationData newRegistrationData) {

		if (newRegistrationData.getStudentNumber().length() != 5)
			throw new RegistrationDataGenericException("Student number must be exactly 5 characters");

		// Check to see if the Student number already exists
		Optional<RegistrationData> foundRegistrationData = registrationDataRepository.findByStudentNumber(newRegistrationData.getStudentNumber());

		if (!foundRegistrationData.isPresent())		// student does not exist
		{
			registrationDataRepository.save(newRegistrationData);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newRegistrationData.getId()).toUri();
			return ResponseEntity.created(location).build();
		}
		else
		{
			throw new RegistrationDataAlreadyExistsException("The student number already exists : " + newRegistrationData.getStudentNumber());
		}

	}


}
