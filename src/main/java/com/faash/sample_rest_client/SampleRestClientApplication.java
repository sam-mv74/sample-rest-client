package com.faash.sample_rest_client;

import com.faash.sample_rest_client.dto.PersonDTO;
import com.faash.sample_rest_client.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleRestClientApplication.class, args);
		PersonService personService=new PersonService("http://localhost:8080/person");
//		System.out.println(myRestClient.getPersonById(1));
		PersonDTO personDTO = new PersonDTO();
		personDTO.setFirstname("ali");
		personDTO.setLastname("alizadeh");
		personService.addPerson(personDTO,"whatever");
	}

}
