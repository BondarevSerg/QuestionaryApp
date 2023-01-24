package ru.bondarev.questionary.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.AnswerRequest;
import ru.bondarev.questionary.dto.request.QuestionRequest;
import ru.bondarev.questionary.dto.response.AnswerResponse;
import ru.bondarev.questionary.dto.response.QuestionResponse;
import ru.bondarev.questionary.entity.Answer;
import ru.bondarev.questionary.entity.Question;
import ru.bondarev.questionary.entity.Quiz;
import ru.bondarev.questionary.repositories.QuizRepository;
import ru.bondarev.questionary.service.Imp.AnswerServiceImp;
import ru.bondarev.questionary.service.Imp.QuestionServiceImp;
import ru.bondarev.questionary.service.Imp.QuizServiceImp;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * маппер вопросов
 */
@Service
@RequiredArgsConstructor
public class QuestionMapper {

    //    private final AnswerMapper answerMapper;
//    private  final  QuizMapper quizMapper;


    /**
     * вопрос из энтити в dto
     *
     * @param question
     * @return
     */
    public QuestionResponse entityToResponse(Question question) {
        return QuestionResponse.builder()
                .id(question.getId())
                .title(question.getTitle())
                .quizId(question.getQuiz().getId())
                .answerResponseList(question.getAnswers().stream()
                        .map(a -> AnswerResponse.builder()
                                .id(a.getId())
                                .title(a.getTitle())
                                .questionId(a.getQuestion().getId())
                                .build())
                              .collect(Collectors.toList()))
                .build();
    }

    /**
     * список вопросов  из энтити в dto
     *
     * @param questions
     * @return
     */
    public List<QuestionResponse> entityToResponse(List<Question> questions) {
        if (!questions.isEmpty()) {
            return questions.stream()
                    .map(this::entityToResponse)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    /**
     * ответ из dto в энтити
     *
     * @param questionRequest
     * @return вопрос
     */
    public Question requestToEntity(QuestionRequest questionRequest) {
        return Question.builder()
                .id(questionRequest.getId())
                .title(questionRequest.getTitle())
                .quiz(Quiz.builder()
                        .id(questionRequest.getQuizID())
                        .build())
               .answers(questionRequest.getAnswerRequestList().stream()
                       .map(a -> Answer.builder()
                               .id(a.getId())
                               .build())
                       .collect(Collectors.toList()))
                .build();
    }


    /**
     * список вопросов  из dto в энтити
     *
     * @param questions
     * @return
     */
    public List<Question> requestToEntityList(List<QuestionRequest> questions) {
        if (!questions.isEmpty()) {
            return questions.stream()
                    .map(this::requestToEntity)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

}
