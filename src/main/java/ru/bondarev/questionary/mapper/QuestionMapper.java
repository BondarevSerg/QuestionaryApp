package ru.bondarev.questionary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.questionary.dto.request.QuestionRequest;
import ru.bondarev.questionary.dto.response.QuestionResponse;
import ru.bondarev.questionary.entity.Question;

@Mapper(uses = { AnswerMapper.class })
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper( QuestionMapper.class );
   @Mapping(source = "id", target = "id")
    @Mapping(source = "quiz.id", target = "quizId")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "answers", target = "answerResponseList")
    QuestionResponse toDTO(Question question);
    @Mapping(source = "quizId", target = "quiz.id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "answerRequestList", target = "answers")
    Question toEntity(QuestionRequest questionRequest);


}

