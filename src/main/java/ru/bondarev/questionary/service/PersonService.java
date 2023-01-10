package ru.bondarev.questionary.service;

import org.springframework.transaction.annotation.Transactional;
import ru.bondarev.questionary.dto.request.AnswerRequest;
import ru.bondarev.questionary.dto.request.PersonRequest;
import ru.bondarev.questionary.dto.response.AnswerResponse;
import ru.bondarev.questionary.dto.response.PersonResponse;
import ru.bondarev.questionary.entity.Person;

import java.util.List;

public interface PersonService {


    /**
     * Получения всех персон
     *
     * @return
     */
    List<PersonResponse> getAllPerson();

    /**
     * Получения персона по id
     *
     * @return
     */
    PersonResponse getPersonById(Long id);

    /**
     * сохранение нового персона
     *
     * @param
     */

    void savePerson(PersonRequest personRequest);

    /**
     * удаление персона по id
     *
     * @param id
     */
    void deletePerson(Long id);

    /**
     * апдейт персона
     */
    void updatePerson(PersonRequest personRequest);
}
