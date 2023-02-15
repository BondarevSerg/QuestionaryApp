package ru.bondarev.questionary.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.QuizResultRequest;
import ru.bondarev.questionary.dto.response.PersonResponse;
import ru.bondarev.questionary.dto.response.QuizResultResponse;
import ru.bondarev.questionary.entity.*;
import ru.bondarev.questionary.repositories.*;
import ru.bondarev.questionary.service.Imp.AnswerServiceImp;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 маппер результата
 */
@Service
@RequiredArgsConstructor
public class QuizResultMapper {


    /**
     * из энтити в dto
     * @param quizResult
     * @return QuizResponse
     */
    public QuizResultResponse entityToResponse(QuizResult quizResult){
        return QuizResultResponse.builder()
                .id(quizResult.getId())
                .personId(quizResult.getPerson().getId())
                .quizId(quizResult.getQuiz().getId())
                .questionId(quizResult.getQuestion().getId())
                .answerId(quizResult.getAnswer().getId())
                .build();
    }
    /**
     * список из энтити в dto
     * @param quizResultList
     * @return List<QuizResultResponse>
     */
    public List<QuizResultResponse> listEntityToResponse(List<QuizResult>quizResultList){
        if (!quizResultList.isEmpty()) {
            return quizResultList.stream()
                    .map(this::entityToResponse)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
    /**
     * из dto в энтити
     * @param quizResultRequest
     * @return QuizResult
     */
    public QuizResult requestToEntity(QuizResultRequest quizResultRequest){
        return QuizResult.builder()
                .id(quizResultRequest.getId())
                .person(Person.builder()
                        .id(quizResultRequest.getPersonId())
                        .build())
                .quiz(Quiz.builder()
                        .id(quizResultRequest.getQuizId())
                        .build())
                .question(Question.builder()
                        .id(quizResultRequest.getQuestionId())
                        .build())
                .answer(Answer.builder()
                        .id(quizResultRequest.getAnswerId())
                        .build())
                .build();
    }
}
