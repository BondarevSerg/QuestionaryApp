package ru.bondarev.questionary.service;

import org.springframework.transaction.annotation.Transactional;
import ru.bondarev.questionary.dto.request.QuestionRequest;
import ru.bondarev.questionary.dto.response.QuestionResponse;
import ru.bondarev.questionary.entity.Question;

import java.util.List;

public interface QuestionService {



    /**
     * Получение вопроса по id вопроса и id анкеты
     *
     * @param id
     * @return
     */
    QuestionResponse getQuestionById(Long id);

    /**
     * Получения всех вопросов по id анкеты
     *
     * @return
     */
    List<QuestionResponse> getAllQuestion(Long quizId);

    /**
     * сохранение нового вопроса по id
     *
     * @param questionRequest
     */


    @Transactional
    void saveQuestion(QuestionRequest questionRequest);

    /**
     * удаление вопроса по id вопроса
     *
     * @param id
     */
    void deleteQuestion(Long id);

    /**
     * апдейт вопроса
     */
    void updateQuestion(QuestionRequest questionRequest);

}
