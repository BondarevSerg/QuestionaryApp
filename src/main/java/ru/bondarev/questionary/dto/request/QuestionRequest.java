package ru.bondarev.questionary.dto.request;

import lombok.Data;

import java.util.List;


@Data
public class QuestionRequest {

    private String title;

    private Long quizId;

    List<AnswerRequest> answerRequestList;


}
