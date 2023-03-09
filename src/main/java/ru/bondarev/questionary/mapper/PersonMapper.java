package ru.bondarev.questionary.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.questionary.dto.request.PersonRequest;
import ru.bondarev.questionary.dto.response.PersonResponse;
import ru.bondarev.questionary.entity.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );
    @Mapping(source = "id", target = "id")
   PersonResponse toDTO(Person person);

    Person toEntity(PersonRequest personRequest);
}
