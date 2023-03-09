package ru.bondarev.questionary.dto.response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerResponse {

    private Long id;

    private String title;

    private Long questionId;
}
