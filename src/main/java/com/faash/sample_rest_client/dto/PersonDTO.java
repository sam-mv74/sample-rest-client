package com.faash.sample_rest_client.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PersonDTO {
    private String firstname;

    private String lastname;

    private String email;

    private String phoneNumber;
}
