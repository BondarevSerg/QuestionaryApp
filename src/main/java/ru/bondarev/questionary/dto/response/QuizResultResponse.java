package ru.bondarev.questionary.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuizResultResponse {

    private Long id;

    private Long personId;

    private Long quizId;

    private Long questionId;

    private Long answerId;
}
