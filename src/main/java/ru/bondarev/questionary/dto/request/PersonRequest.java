package ru.bondarev.questionary.dto.request;


import lombok.Data;

@Data
public class PersonRequest {

    private String login;

    private String firstName;

    private String lastName;

    private  String password;
}
