package ru.bondarev.questionary.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class PersonResponse {

    private Long id;

    private String login;

    private String firstName;

    private String lastName;

}
