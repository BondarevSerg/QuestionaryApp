package ru.bondarev.questionary.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bondarev.questionary.dto.request.QuizRequest;
import ru.bondarev.questionary.dto.response.QuizResponse;
import ru.bondarev.questionary.entity.Quiz;
import ru.bondarev.questionary.mapper.QuestionMapper;
import ru.bondarev.questionary.mapper.QuizMapper;
import ru.bondarev.questionary.repositories.QuizRepository;
import ru.bondarev.questionary.service.QuizService;

import java.util.List;

/**
 * Сервис по работе с анкетой
 */
@Service
@RequiredArgsConstructor
public class QuizServiceImp implements QuizService {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    private final QuestionMapper questionMapper;


    /**
     * dto анкеты по id
     *
     * @param id идентификатор
     * @return
     */
    @Override
    public QuizResponse getQuizById(Long id) {
        var quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдена анкета по идентификатору: " + id));

        return quizMapper.entityToResponse(quiz);
    }

    /**
     * список всех анкет
     *
     * @return
     */
    @Override
    public List<QuizResponse> getAllQuiz() {
        List<Quiz> quizzes = quizRepository.findAll();

        return quizMapper.entityToResponseList(quizzes);
    }

    /**
     * сохранение анкеты
     *
     * @param quizRequest
     */
    @Override
    @Transactional
    public void saveQuiz(QuizRequest quizRequest) {
        quizRepository.save(quizMapper.requestToEntity(quizRequest));
    }

    /**
     * удаление анкеты по id
     * @param id
     */
    @Override
    @Transactional
    public void deleteQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдена анкета по идентификатору: " + id));
        quizRepository.delete(quiz);
    }

    /**
     * апдейт анкеты
     * @param quizRequest
     */
    @Override
    public void updateQuiz(QuizRequest quizRequest) {
        var quiz = quizRepository.findById(quizRequest.getId())
                .orElseThrow(() -> new RuntimeException("Не найдена анкета"));
        quiz.setTitle(quizRequest.getTitle());
        quiz.setQuestions(questionMapper.requestToEntityList(quizRequest.getQuestionRequestList()));

        quizRepository.save(quiz);
    }
}
