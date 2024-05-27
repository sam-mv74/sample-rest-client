package com.faash.sample_rest_client.service;

import com.faash.sample_rest_client.dto.PersonDTO;
import com.faash.sample_rest_client.http.HttpHeader;
import com.faash.sample_rest_client.http.ResponseBodyModel;
import org.springframework.core.ParameterizedTypeReference;
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

    public ResponseEntity<ResponseBodyModel<Void>> addPerson(PersonDTO personDTO, String customHeaderValue) {
        String url = baseUrl + "/add-person";
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeader.SAMPLE, customHeaderValue);
        HttpEntity<PersonDTO> requestEntity = new HttpEntity<>(personDTO, headers);
        ParameterizedTypeReference<ResponseBodyModel<Void>> responseType = new ParameterizedTypeReference<>(){};
        ResponseEntity<ResponseBodyModel<Void>>response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);

        return response;
    }

    public ResponseEntity<ResponseBodyModel<PersonDTO>> getPersonById(Integer id) {
        String url = baseUrl + "/get-person/" + id;
        ResponseEntity<ResponseBodyModel<PersonDTO>> response;
        ParameterizedTypeReference<ResponseBodyModel<PersonDTO>> responseType = new ParameterizedTypeReference<>(){};
        try {
            response = restTemplate.exchange(url,HttpMethod.GET,null, responseType);
            return response;
        }catch (HttpServerErrorException e ){
            ResponseBodyModel <PersonDTO> responseModel = new ResponseBodyModel<>();
            responseModel.setSuccess(false);
            responseModel.setResult(null);
            String message = e.getStatusCode().value() == 400 ? "Bad Request" : "Internal Server Error";
            responseModel.setMessage(message);
            responseModel.setResponseCode(String.valueOf((e.getStatusCode().value())));
            HttpStatus httpStatus = e.getStatusCode().value() == 400 ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(responseModel,httpStatus);
        }
    }
}
