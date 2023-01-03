package ru.bondarev.questionary.dto.response;

import lombok.Builder;
import lombok.Data;
import ru.bondarev.questionary.entity.Question;

import java.util.List;

/**
 * dto анкеты на фронт
 */
@Data
@Builder
public class QuizResponse {

    private Long id;

    private String title;

    private List<QuestionResponse> questions;

}
