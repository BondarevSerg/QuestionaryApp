package ru.bondarev.questionary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

/**
 * dto анкеты на фронт
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {

    private Long id;

    private String title;

    private List<QuestionResponse> questions;

}
