package ru.bondarev.questionary.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Пользователи",
        description = "Все методы для работы с пользователями"
)
public class PersonController {

    private  final PersonServiceImp personService;

    /**
     * Получение списка пользователей
     *
     * @return
     */
    @GetMapping()
    @Operation(summary = "Получение списка пользователей")
    public List<PersonResponse> getAllPerson() {
        return personService.getAllPerson();
    }

    /**
     * Получение  пользователя по id
     *
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получение  пользователя по id")
    public PersonResponse getPersonById( @Parameter(description = "id пользователя") @PathVariable("id")Long id) {
        return personService.getPersonById(id);
    }

    /**
     * сохранение(регистрация) нового пользователя
     * @param personRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "сохранение(регистрация) нового пользователя")
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
    @Operation(summary = "удаление пользователя по id")
    public ResponseEntity<HttpStatus> deletePersonById(@Parameter(description = "id пользователя") @PathVariable("id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * обновление  пользователя
     *
     * @param personRequest
     * @return
     */
    @PutMapping("/{id}")
    @Operation(summary = "обновление  пользователя")
    public ResponseEntity<HttpStatus> updatePerson(@Parameter(description = "id пользователя") @PathVariable("id") Long id,@RequestBody PersonRequest personRequest) {
        personService.updatePerson(id, personRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
