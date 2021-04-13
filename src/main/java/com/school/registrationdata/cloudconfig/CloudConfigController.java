package com.school.registrationdata.cloudconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudConfigController {

	@Autowired
	Configuration config;
	
	@GetMapping("config/")
	public String getDataFromConfigServer() {
		return config.toString();
	}
	
}
