package ru.bondarev.questionary.dto.request;

import lombok.Data;

import java.util.List;


@Data
public class QuestionRequest {

    private Long id;

    private String title;

    private Long quizID;

    List<AnswerRequest> answerRequestList;


}
