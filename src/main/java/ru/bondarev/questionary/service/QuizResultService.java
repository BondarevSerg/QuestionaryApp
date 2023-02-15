package ru.bondarev.questionary.service;

import org.springframework.transaction.annotation.Transactional;
import ru.bondarev.questionary.dto.request.PersonRequest;
import ru.bondarev.questionary.dto.request.QuizResultRequest;
import ru.bondarev.questionary.dto.response.PersonResponse;
import ru.bondarev.questionary.dto.response.QuizResponse;
import ru.bondarev.questionary.dto.response.QuizResultResponse;
import ru.bondarev.questionary.entity.QuizResult;

import java.util.List;

public interface QuizResultService {
    /**
     * Получения всех результатов
     *
     * @return
     */
    List<QuizResultResponse> getAllQuizResult();

    /**
     * Получения результатов  по id персона!
     *
     * @return
     */
    List<QuizResultResponse> getQuizResultsByPersonId(Long personId);

    /**
     * сохранение нового результата
     *
     * @param
     */

    void saveQuizResult(QuizResultRequest quizResultRequest);

    /**
     * удаление результата по id
     *
     * @param id
     */
    void deleteQuizResult(Long id);

    /**
     * апдейт результата
     */


    void updateQuizResult(QuizResultRequest quizResultRequest);
}
