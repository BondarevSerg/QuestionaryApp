package ru.bondarev.questionary.dto.request;

import lombok.Data;

@Data
public class QuizResultRequest {

//    private Long id;

    private Long personId;

    private Long quizId;

    private Long questionId;

    private Long answerId;
}
