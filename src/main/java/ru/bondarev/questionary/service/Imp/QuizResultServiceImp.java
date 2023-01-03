package ru.bondarev.questionary.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.QuizResultRequest;
import ru.bondarev.questionary.dto.response.QuizResultResponse;

import ru.bondarev.questionary.entity.*;

import ru.bondarev.questionary.mapper.QuizResultMapper;

import ru.bondarev.questionary.repositories.*;
import ru.bondarev.questionary.service.QuizResultService;

import java.util.List;

/**
 * сервис работы с результатом
 */
@Service
@RequiredArgsConstructor
public class QuizResultServiceImp implements QuizResultService {


    private final QuizResultRepository quizResultRepository;
  
    private final QuizResultMapper quizResultMapper;

    /**
     * список результатов
     *
     * @return List<QuizResultResponse>
     */
    @Override
    public List<QuizResultResponse> getAllQuizResult() {

        return quizResultMapper.listEntityToResponse(quizResultRepository.findAll());
    }

    /**
     * Список результатов по id Персона
     *
     * @param personId
     * @return List<QuizResultResponse>
     */
    @Override
    public List<QuizResultResponse> getQuizResultsByPersonId(Long personId) {

        return quizResultMapper.listEntityToResponse(quizResultRepository.findAllByPersonId(personId));
    }

    /**
     * сохранение результата
     * @param quizResultRequest
     */
    @Override
    public void saveQuizResult(QuizResultRequest quizResultRequest) {

        quizResultRepository.save(quizResultMapper.requestToEntity(quizResultRequest));


    }

    /**
     * удаление результата
     * @param id
     */
    @Override
    public void deleteQuizResult(Long id) {
        quizResultRepository.deleteById(id);
    }

    /**
     * апдейт результата
     * @param quizResultRequest
     */
    @Override
    public void updateQuizResult(QuizResultRequest quizResultRequest) {
        var quizResult = quizResultRepository.findById(quizResultRequest.getId())
                .orElseThrow(() -> new RuntimeException("Не найден результат по id"));

        quizResult.setPerson(Person.builder()
                .id(quizResultRequest.getPersonId())
                .build());
        quizResult.setQuiz(Quiz.builder()
                .id(quizResultRequest.getQuizId())
                .build());
        quizResult.setQuestion(Question.builder()
                .id(quizResultRequest.getQuestionId())
                .build());
        quizResult.setAnswer(Answer.builder()
                .id(quizResultRequest.getAnswerId())
                .build());

        quizResultRepository.save(quizResult);
    }
}
