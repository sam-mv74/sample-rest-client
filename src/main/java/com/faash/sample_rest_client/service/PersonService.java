package com.faash.sample_rest_client.service;

import com.faash.sample_rest_client.dto.PersonDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {
    private final String baseUrl = "http://localhost:8081/person-server";
    private final RestTemplate restTemplate;

    public PersonService() {
        restTemplate = new RestTemplate();
    }

    public ResponseEntity<Void> addPerson(PersonDTO personDTO, String customHeaderValue) {
        String url = baseUrl + "/add-person";
        HttpHeaders headers = new HttpHeaders();
        headers.set("sample", customHeaderValue);
        HttpEntity<PersonDTO> requestEntity = new HttpEntity<>(personDTO, headers);
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Void.class);
        return response;
    }

    public ResponseEntity<PersonDTO> getPersonById(Integer id) {
        String url = baseUrl + "/get-person/" + id;
        ResponseEntity<PersonDTO> response = restTemplate.getForEntity(url, PersonDTO.class);
        return response;
    }
}
