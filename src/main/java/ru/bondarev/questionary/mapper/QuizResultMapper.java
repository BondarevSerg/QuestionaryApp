package ru.bondarev.questionary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.questionary.dto.request.QuizRequest;
import ru.bondarev.questionary.dto.request.QuizResultRequest;
import ru.bondarev.questionary.dto.response.QuizResponse;
import ru.bondarev.questionary.dto.response.QuizResultResponse;
import ru.bondarev.questionary.entity.Quiz;
import ru.bondarev.questionary.entity.QuizResult;

//@Mapper(uses = { AnswerMapper.class })
//@Mapper(uses = { PersonMapper.class })
//@Mapper(uses = { QuestionMapper.class })
@Mapper
public interface QuizResultMapper {
    QuizResultMapper INSTANCE = Mappers.getMapper(QuizResultMapper.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "quiz.id", target = "quizId")
    @Mapping(source = "question.id", target = "questionId")
    @Mapping(source = "answer.id", target = "answerId")
    QuizResultResponse toDTO(QuizResult quizResult);
    @Mapping(source = "personId", target = "person.id")
    @Mapping(source = "quizId", target = "quiz.id")
    @Mapping(source = "questionId", target = "question.id")
    @Mapping(source = "answerId", target = "answer.id")
    QuizResult toEntity(QuizResultRequest quizResultRequest);
}
