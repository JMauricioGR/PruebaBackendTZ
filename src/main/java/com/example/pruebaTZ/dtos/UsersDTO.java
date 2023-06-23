package com.example.pruebaTZ.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
