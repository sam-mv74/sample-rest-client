package com.faash.sample_rest_client.service;

import com.faash.sample_rest_client.dto.PersonDTO;
import com.faash.sample_rest_client.model.ResponseBodyModel;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {
    private final String baseUrl = "http://localhost:8081/person-server";
    private final RestTemplate restTemplate;

    public PersonService() {
        restTemplate = new RestTemplate();
    }

    public ResponseEntity<ResponseBodyModel> addPerson(PersonDTO personDTO, String customHeaderValue) {
        String url = baseUrl + "/add-person";
        HttpHeaders headers = new HttpHeaders();
        headers.set("sample", customHeaderValue);
        HttpEntity<PersonDTO> requestEntity = new HttpEntity<>(personDTO, headers);
        ResponseEntity<ResponseBodyModel> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ResponseBodyModel.class);
        return response;
    }

    public ResponseEntity<ResponseBodyModel> getPersonById(Integer id) {
        String url = baseUrl + "/get-person/" + id;
        ResponseEntity<ResponseBodyModel> response;
        try {
            response = restTemplate.getForEntity(url, ResponseBodyModel.class);
            return response;
        }catch (HttpServerErrorException e ){
            ResponseBodyModel responseModel = new ResponseBodyModel();
            responseModel.setSuccess(false);
            String message = e.getStatusCode().value() == 400 ? "Bad Request" : "Internal Server Error";
            responseModel.setMessage(message);
            responseModel.setResponseCode(String.valueOf((e.getStatusCode().value())));
            HttpStatus httpStatus = e.getStatusCode().value() == 400 ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(responseModel,httpStatus);
        }
    }
}
