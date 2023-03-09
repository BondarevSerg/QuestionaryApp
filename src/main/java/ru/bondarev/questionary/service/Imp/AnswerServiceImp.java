package ru.bondarev.questionary.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.AnswerRequest;
import ru.bondarev.questionary.dto.response.AnswerResponse;
import ru.bondarev.questionary.entity.Answer;
import ru.bondarev.questionary.entity.Question;
import ru.bondarev.questionary.mapper.AnswerMapper;
import ru.bondarev.questionary.mapper.PersonMapper;
import ru.bondarev.questionary.repositories.AnswerRepository;
import ru.bondarev.questionary.service.AnswerService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис по работе с ответами
 */

@Service
@RequiredArgsConstructor

public class AnswerServiceImp implements AnswerService {

    public final AnswerRepository answerRepository;



    /**
     * dto ответа по id
     *
     * @param id
     * @return
     */
    @Override
    public AnswerResponse getAnswerById(Long id) {
        var answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден вопрос по идентификатору: " + id));

        return AnswerMapper.INSTANCE.toDTO(answer);
    }

    /**
     * список  ответов dto по id вопроса
     *
     * @param questionId
     * @return List<AnswerResponse>
     */
    @Override
    public List<AnswerResponse> getAllAnswers(Long questionId) {
        List<Answer> answers = answerRepository.findAllByQuestionId(questionId);
        return answers.stream()
                .map(answer -> AnswerMapper.INSTANCE.toDTO(answer))
                .collect(Collectors.toList());
    }


    /** сохранение ответа
     *
     * @param answerRequest
     */
    @Override
    public void saveAnswer(AnswerRequest answerRequest) {
        answerRepository.save(
                AnswerMapper.INSTANCE.toEntity(answerRequest));
    }

    /**
     * Удаление ответа по id
     * @param id
     */
    @Override
    public void deleteAnswer(Long id) {
        var answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден ответ по идентификатору: " + id));
        answerRepository.delete(answer);
    }

    /**
     * обновление ответа
     * @param answerRequest
     */
    @Override
    public void updateAnswer(Long id, AnswerRequest answerRequest) {
        var answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден ответ по идентификатору: "));

        answer.setTitle(answerRequest.getTitle());
        answer.setQuestion(Question.builder()
                .id(answerRequest.getQuestionId())
                .build());
        answerRepository.save(answer);
    }

}
