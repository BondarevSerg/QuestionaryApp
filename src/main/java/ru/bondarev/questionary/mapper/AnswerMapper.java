package ru.bondarev.questionary.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.AnswerRequest;
import ru.bondarev.questionary.dto.response.AnswerResponse;
import ru.bondarev.questionary.entity.Answer;
import ru.bondarev.questionary.entity.Question;



import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * маппер ответов
 *
 */
@Service
@RequiredArgsConstructor
public class AnswerMapper {


    /**
     * ответ из энтити в dto
     *
     * @param answer
     * @return AnswerResponse
     */
    public AnswerResponse entityToResponse(Answer answer) {
        return AnswerResponse.builder()
                .id(answer.getId())
                .title(answer.getTitle())
                .questionId(answer.getQuestion().getId())
                .build();
    }
    /**
     * список ответов  из энтити в dto
     *
     * @param answers
     * @return List<AnswerResponse>
     */
    public List<AnswerResponse> entityToResponseList(List<Answer> answers) {
        if (!answers.isEmpty()) {
            return answers.stream()
                    .map(this::entityToResponse)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }


    /**
     * ответ из dto в энтити
     *
     * @param answerRequest
     * @return ответ
     */
    public Answer requestToEntity(AnswerRequest answerRequest){
   return Answer.builder()
            .id(answerRequest.getId())
            .title(answerRequest.getTitle())
            .question(Question.builder()
                    .id(answerRequest.getQuestionId())
                    .build())
            .build();
    }

    /**
     * список ответов  из dto в энтити
     *
     * @param answerRequestList
     * @return List<Answer>
     */
    public List<Answer> requestToEntityList(List<AnswerRequest> answerRequestList) {
        if (!answerRequestList.isEmpty()) {
            return answerRequestList.stream()
                    .map(this:: requestToEntity)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
