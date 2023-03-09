package ru.bondarev.questionary.dto.request;

import lombok.Data;
import ru.bondarev.questionary.dto.response.QuestionResponse;

import java.util.List;

/**
 * dto c фронта
 */
@Data
public class QuizRequest {

    private String title;

    private List<QuestionRequest> questions;
}
