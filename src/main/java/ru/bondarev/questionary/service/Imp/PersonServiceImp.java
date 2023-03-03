package ru.bondarev.questionary.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.PersonRequest;
import ru.bondarev.questionary.dto.response.PersonResponse;
import ru.bondarev.questionary.entity.Person;
import ru.bondarev.questionary.entity.Role;
import ru.bondarev.questionary.mapper.PersonMapper;
import ru.bondarev.questionary.repositories.PersonRepository;
import ru.bondarev.questionary.service.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * сервис работы с пользователем
 */
@Service
@RequiredArgsConstructor
public class PersonServiceImp implements PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    /**
     * поиск пользователя по id
     *
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
     * список всех пользователей
     *
     * @return
     */
    @Override
    public List<PersonResponse> getAllPerson() {
        List<Person> personList = personRepository.findAll();

        return personMapper.entityToResponseList(personList);
    }


    /**
     * сохранение(регистрация) нового пользователя
     *
     * @param personRequest
     */
    @Override
    public void savePerson(PersonRequest personRequest) {

        Optional<Person> person = Optional.ofNullable(personRepository.findByLogin(personRequest.getLogin()));

        if (person.isEmpty()) {
            personRepository.save(personMapper.requestToEntity(personRequest));
        }
    }

    /**
     * удаление  пользователя по id
     *
     * @param id
     */
    @Override
    public void deletePerson(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден персон по идентификатору: " + id));
        //админ не может себя удалить
        Set<String> roles = person.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());

        if (!(roles.contains("ROLE_ADMIN"))) {
            personRepository.delete(person);
        }
    }

    /**
     * апдейт пользователя
     *
     * @param personRequest
     */
    @Override
    public void updatePerson(Long id, PersonRequest personRequest) {
        var person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден персон по идентификатору"));

        person.setLogin(personRequest.getLogin());
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setPassword(personRequest.getPassword());
        personRepository.save(person);
    }
}
