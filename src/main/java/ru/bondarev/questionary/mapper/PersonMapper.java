package ru.bondarev.questionary.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.PersonRequest;
import ru.bondarev.questionary.dto.response.PersonResponse;
import ru.bondarev.questionary.entity.Person;
import ru.bondarev.questionary.repositories.PersonRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 маппер персона
 */
@Service
@RequiredArgsConstructor
public class PersonMapper {

    /**
     * из энтити в dto
     * @param person
     * @return personResponse
     */
   public PersonResponse entityToResponse(Person person){
        return PersonResponse.builder()
                .id(person.getId())
                .login(person.getLogin())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .build();
    }


    /**
     * список энтити в dto
     * @param personList
     * @return
     */
   public List<PersonResponse>  entityToResponseList(List<Person>personList){
        if (!personList.isEmpty()) {
            return personList.stream()
                    .map(this::entityToResponse)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }


    /**
     * из dto в ентити
     * @param
     * @return
     */
    public Person requestToEntity(PersonRequest personRequest){
        return Person.builder()
                .id(personRequest.getId())
                .login(personRequest.getLogin())
                .firstName(personRequest.getFirstName())
                .lastName(personRequest.getLastName())
                .build();
    }

}
