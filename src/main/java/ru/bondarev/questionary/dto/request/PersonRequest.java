package ru.bondarev.questionary.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class PersonRequest {

    private long id;

    private String login;

    private String firstName;

    private String lastName;
}
