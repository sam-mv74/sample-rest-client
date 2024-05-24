package com.faash.sample_rest_client.service;

import com.faash.sample_rest_client.dto.PersonDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PersonService {
    private final String baseUrl;
    private final RestTemplate restTemplate;

    public PersonService(String baseUrl) {
        this.baseUrl = baseUrl;
        restTemplate = new RestTemplate();
    }
    public void addPerson(PersonDTO personDTO , String customHeaderValue){
        String url = baseUrl+"/add-person";
        HttpHeaders headers = new HttpHeaders();
        headers.set("sample",customHeaderValue);
        HttpEntity<PersonDTO> requestEntity = new HttpEntity<>(personDTO,headers);
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST,requestEntity,Void.class);
    }
    public PersonDTO getPersonById(Integer id){
        String url = baseUrl+"/get-person/"+id;
        ResponseEntity<PersonDTO> response = restTemplate.getForEntity(url, PersonDTO.class);
        return response.getBody();
    }
}
