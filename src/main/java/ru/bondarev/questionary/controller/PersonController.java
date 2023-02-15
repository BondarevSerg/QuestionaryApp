package ru.bondarev.questionary.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.questionary.dto.request.PersonRequest;
import ru.bondarev.questionary.dto.response.PersonResponse;
import ru.bondarev.questionary.service.Imp.PersonServiceImp;

import java.util.List;

/**
 * контроллер пользователей
 */
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private  final PersonServiceImp personService;

    /**
     * Получение списка пользователей
     *
     * @return
     */
    @GetMapping()
    public List<PersonResponse> getAllPerson() {
        return personService.getAllPerson();
    }

    /**
     * Получение  пользователя по id
     *
     * @return
     */
    @GetMapping("/{id}")
    public PersonResponse getPersonById(@PathVariable("id")Long id) {
        return personService.getPersonById(id);
    }

    /**
     * сохранение(регистрация) нового пользователя
     * @param personRequest
     * @return
     */
    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody  PersonRequest personRequest) {

        personService.savePerson(personRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    /**
     * удаление пользователя по id
     *
     * @return
     */
    @DeleteMapping ("/{id}")
    public ResponseEntity<HttpStatus> deletePersonById(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * апдейт пользователя
     *
     * @param personRequest
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updatePerson(@PathVariable("id") Long id,@RequestBody PersonRequest personRequest) {
        personService.updatePerson(id, personRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
