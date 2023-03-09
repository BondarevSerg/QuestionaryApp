package ru.bondarev.questionary.dto.request;

import lombok.Data;

@Data
public class AnswerRequest {

    private String title;

    private long questionId;
}
