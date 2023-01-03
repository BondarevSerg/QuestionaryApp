package ru.bondarev.questionary.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.QuizRequest;
import ru.bondarev.questionary.dto.response.QuestionResponse;
import ru.bondarev.questionary.dto.response.QuizResponse;
import ru.bondarev.questionary.entity.Question;
import ru.bondarev.questionary.entity.Quiz;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * маппер анкеты
 */
@Service
@RequiredArgsConstructor
public class QuizMapper {

   private final QuestionMapper questionMapper;

    /**
     * ентити в dto
     *
     * @param quiz
     * @return QuizResponse
     */

    public QuizResponse entityToResponse(Quiz quiz) {
        return QuizResponse.builder()
                .id(quiz.getId())
                .title(quiz.getTitle())
                .questions(questionMapper.entityToResponse(quiz.getQuestions()))
                .build();
    }


    /**
     * список ентити в dto
     *
     * @param quizzes
     * @return
     */
    public List<QuizResponse> entityToResponseList(List<Quiz> quizzes) {
        if (!quizzes.isEmpty()) {
            return quizzes.stream()
                    .map(this::entityToResponse)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
    /**
     * из dto в энтити
     *
     * @param quizRequest
     * @return Quiz
     */
    public Quiz requestToEntity(QuizRequest quizRequest){
        return Quiz.builder()
                .id(quizRequest.getId())
                .title(quizRequest.getTitle())
                .questions(questionMapper.requestToEntityList(quizRequest.getQuestionRequestList()))
                .build();
    }
}
