package ru.bondarev.questionary.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.PersonRequest;
import ru.bondarev.questionary.dto.response.PersonResponse;
import ru.bondarev.questionary.entity.Person;
import ru.bondarev.questionary.mapper.PersonMapper;
import ru.bondarev.questionary.repositories.PersonRepository;
import ru.bondarev.questionary.service.PersonService;

import java.util.List;

/**
 * сервис работы с пользователем
 */
@Service
@RequiredArgsConstructor
public class PersonServiceImp implements PersonService {

    private final PersonRepository personRepository;

    private  final PersonMapper personMapper;

    /**
     * поиск персона по id
     * @param id
     * @return PersonResponse
     */
    @Override
    public PersonResponse getPersonById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден персон по идентификатору: " + id));
        return personMapper.entityToResponse(person);
    }

    /**
     * список всех персонов
     * @return
     */
    @Override
    public List<PersonResponse> getAllPerson() {
        List<Person>personList = personRepository.findAll();

        return personMapper.entityToResponseList(personList);
    }


    /**
     * сохранение персона
     * @param personRequest
     */
    @Override
    public void savePerson(PersonRequest personRequest) {
        personRepository.save(personMapper.requestToEntity(personRequest));

    }
    /**
     * удаление  персона по id
     * @param id
     */
    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден персон по идентификатору: " + id));
        personRepository.delete(person);
    }
    /**
     * апдейт персона
     * @param personRequest
     */
    @Override
    public void updatePerson(PersonRequest personRequest) {
       var person = personRepository.findById(personRequest.getId())
                .orElseThrow(() -> new RuntimeException("Не найден персон по идентификатору"));
        person.setLogin(personRequest.getLogin());
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        personRepository.save(person);
    }
}
