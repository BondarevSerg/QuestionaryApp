package ru.bondarev.questionary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.questionary.dto.request.QuizRequest;
import ru.bondarev.questionary.dto.response.QuizResponse;
import ru.bondarev.questionary.entity.Quiz;

@Mapper(uses = { QuestionMapper.class })
public interface QuizMapper {

    QuizMapper INSTANCE = Mappers.getMapper( QuizMapper.class );

    @Mapping(source = "id", target = "id")
    QuizResponse toDTO(Quiz quiz);
    @Mapping(source = "questions", target = "questions")
    @Mapping(source = "title", target = "title")
    Quiz toEntity(QuizRequest quizRequest);
}
