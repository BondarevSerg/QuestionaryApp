package ru.bondarev.questionary.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.dto.request.PersonRequest;
import ru.bondarev.questionary.dto.response.PersonResponse;
import ru.bondarev.questionary.entity.Person;
import ru.bondarev.questionary.entity.Role;
import ru.bondarev.questionary.mapper.PersonMapper;
import ru.bondarev.questionary.repositories.PersonRepository;
import ru.bondarev.questionary.repositories.RoleRepository;
import ru.bondarev.questionary.service.PersonService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * сервис работы с пользователем
 */
@Service
@RequiredArgsConstructor
public class PersonServiceImp implements PersonService {

    private final PersonRepository personRepository;
    private  final RoleRepository roleRepository;


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
        return PersonMapper.INSTANCE.toDTO(person);
    }

    /**
     * список всех пользователей
     *
     * @return
     */
    @Override
    public List<PersonResponse> getAllPerson() {
        List<Person> personList = personRepository.findAll();
        return personList.stream()
                .map(person -> PersonMapper.INSTANCE.toDTO(person))
                .collect(Collectors.toList());

    }

    /**
     * список всех пользователей c ролью USER
     *
     * @return
     */
    @Override
    public List<PersonResponse> getAllUserPerson() {
        List<Person> personUserList = personRepository.findAllUserPerson("ROLE_USER");
        return personUserList.stream()
                .map(person -> PersonMapper.INSTANCE.toDTO(person))
                .collect(Collectors.toList());

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
            Person newPerson = PersonMapper.INSTANCE.toEntity(personRequest);
            newPerson.setRoles(Collections.singleton(roleRepository.findByName("ROLE_USER")));
            personRepository.save(newPerson);
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
