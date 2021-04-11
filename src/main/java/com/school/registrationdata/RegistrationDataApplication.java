package com.school.registrationdata;

import com.school.registrationdata.repositories.RegistrationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RegistrationDataApplication implements CommandLineRunner {

	@Autowired
	private RegistrationDataRepository registrationDataRepository;

	public static void main(String[] args) {
		System.getProperties().put( "server.port", 8082 );
		SpringApplication.run(RegistrationDataApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


	}
}
