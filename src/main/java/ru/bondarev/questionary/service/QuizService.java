package ru.bondarev.questionary.service;

import ru.bondarev.questionary.dto.request.QuizRequest;
import ru.bondarev.questionary.dto.response.QuizResponse;


import java.util.List;

public interface QuizService {



    /**
     * Получение анкеты по идентификатору
     *
     * @param id идентификатор
     * @return
     */
    QuizResponse getQuizById(Long id);

    /**
     * Получения всех анкет
     *
     * @return список анкет
     */
    List<QuizResponse> getAllQuiz();

    /**
     * сохранение новой анкеты
     *
     * @param quizRequest
     */
    void saveQuiz(QuizRequest quizRequest);

    /**
     * удаление анкеты по Id
     *
     * @param id
     */
    void deleteQuiz(Long id);

    /**
     * апдейт анкеты
     */
    void updateQuiz(Long id, QuizRequest quizRequest);

}
