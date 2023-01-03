package ru.bondarev.questionary.dto.response;


import lombok.Builder;
import lombok.Data;
import ru.bondarev.questionary.entity.Quiz;

import java.util.List;

@Data
@Builder
public class QuestionResponse {

    private Long id;

    private String title;

    private Long quizId;

    List<AnswerResponse> answerResponseList;
}
