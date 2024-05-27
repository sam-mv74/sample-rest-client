package com.faash.sample_rest_client.controller;

import com.faash.sample_rest_client.dto.PersonDTO;
import com.faash.sample_rest_client.http.HttpHeader;
import com.faash.sample_rest_client.http.ResponseBodyModel;
import com.faash.sample_rest_client.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person-client")
@Tag(name = "Person Client", description = "person client APIs")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Operation(
            summary = "Add a Person ",
            description = "adds a person by required fields , by calling person server APIs")
    @PostMapping("/add-person")
    public ResponseEntity<ResponseBodyModel<Void>> addPerson(@RequestHeader(name = HttpHeader.SAMPLE) String header, @RequestBody PersonDTO personDTO) {
        return personService.addPerson(personDTO, header);
    }

    @Operation(
            summary = "Retrieve a Person ",
            description = "retrieves a person by required fields , by calling person server APIs")
    @GetMapping("/get-person/{personId}")
    public ResponseEntity<ResponseBodyModel<PersonDTO>> getPerson(@PathVariable Integer personId) {
        return personService.getPersonById(personId);
    }
}
