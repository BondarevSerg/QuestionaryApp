package ru.bondarev.questionary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.questionary.dto.request.AnswerRequest;
import ru.bondarev.questionary.dto.response.AnswerResponse;
import ru.bondarev.questionary.entity.Answer;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper( AnswerMapper.class );
    @Mapping(source = "id", target = "id")
    @Mapping(source = "question.id", target = "questionId")

    AnswerResponse toDTO(Answer answer);

    @Mapping(source = "questionId", target = "question.id")
    @Mapping(source = "title", target = "title")
    Answer toEntity(AnswerRequest answerRequest);
}
