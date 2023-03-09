package ru.bondarev.questionary.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.QuestionRequest;
import ru.bondarev.questionary.dto.response.QuestionResponse;
import ru.bondarev.questionary.entity.Quiz;
import ru.bondarev.questionary.mapper.AnswerMapper;
import ru.bondarev.questionary.mapper.QuestionMapper;
import ru.bondarev.questionary.repositories.QuestionRepository;
import ru.bondarev.questionary.service.QuestionService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис работы с вопросами
 */
@Service
@RequiredArgsConstructor
public class QuestionServiceImp implements QuestionService {

    private final QuestionRepository questionRepository;




    /**
     * вопрос по id
     *
     * @param id
     * @return QuestionResponse
     */
    @Override
    public QuestionResponse getQuestionById(Long id) {
        var question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден вопрос по id"));

        return QuestionMapper.INSTANCE.toDTO(question);

    }

    /**
     * Список вопросов по id анкеты
     *
     * @param quizId
     * @return List<QuestionResponse>
     */
    @Override
    public List<QuestionResponse> getAllQuestion(Long quizId) {
        return questionRepository.findAllByQuizId(quizId).stream()
                .map(question -> QuestionMapper.INSTANCE.toDTO(question))
                .collect(Collectors.toList());


    }

    /**
     * Сохранение вопроса
     *
     * @param questionRequest
     */
    @Override

    public void saveQuestion(QuestionRequest questionRequest) {

        questionRepository.save(QuestionMapper.INSTANCE.toEntity(questionRequest));
    }

    /**
     * удаление вопроса по id
     *
     * @param id
     */
    @Override

    public void deleteQuestion(Long id) {
        var question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден вопрос по id"));
        questionRepository.delete(question);

    }

    /**
     * апдейт вопроса
     *
     * @param questionRequest
     */
    @Override
    public void updateQuestion(Long id, QuestionRequest questionRequest) {

        var question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден вопрос по id"));

        question.setTitle(questionRequest.getTitle());
        question.setQuiz(Quiz.builder()
                .id(questionRequest.getQuizId())
                .build());
        question.setAnswers(questionRequest.getAnswerRequestList().stream()
                .map(answerRequest -> AnswerMapper.INSTANCE.toEntity(answerRequest))
                .collect(Collectors.toList()));

        questionRepository.save(question);


    }
}
