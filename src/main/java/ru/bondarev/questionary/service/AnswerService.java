package ru.bondarev.questionary.service;

import org.springframework.transaction.annotation.Transactional;
import ru.bondarev.questionary.dto.request.AnswerRequest;
import ru.bondarev.questionary.dto.request.QuestionRequest;
import ru.bondarev.questionary.dto.response.AnswerResponse;
import ru.bondarev.questionary.dto.response.QuestionResponse;
import ru.bondarev.questionary.entity.Answer;

import java.util.List;

public interface AnswerService {



    /**
     * Получения всех ответов по id вопроса
     *
     * @return
     */
    List<AnswerResponse> getAllAnswers(Long questionId);

    /**
     * Получения  ответа по id
     *
     * @return
     */
    AnswerResponse getAnswerById(Long id);

    /**
     * сохранение нового ответа
     *
     * @param
     */

    void saveAnswer(AnswerRequest answerRequest);

    /**
     * удаление ответа по id
     *
     * @param id
     */
    void deleteAnswer(Long id);

    /**
     * апдейт вопроса
     */
    void updateAnswer(AnswerRequest answerRequest);

}


