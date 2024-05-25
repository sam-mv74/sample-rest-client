package com.faash.sample_rest_client.dto;

public class PersonDTO {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;


    public PersonDTO() {
    }

    public PersonDTO(String firstname, String lastname, String email, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
