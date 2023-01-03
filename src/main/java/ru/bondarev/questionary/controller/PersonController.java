package ru.bondarev.questionary.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.questionary.dto.request.PersonRequest;
import ru.bondarev.questionary.dto.request.QuizRequest;
import ru.bondarev.questionary.dto.response.PersonResponse;
import ru.bondarev.questionary.dto.response.QuizResponse;
import ru.bondarev.questionary.service.Imp.PersonServiceImp;

import java.util.List;

/**
 * контроллер персон
 */
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private  final PersonServiceImp personService;

    /**
     * Получение списка персон
     *
     * @return
     */
    @GetMapping()
    public List<PersonResponse> getAllPerson() {
        return personService.getAllPerson();
    }

    /**
     * Получение  персона по id
     *
     * @return
     */
    @GetMapping("/{id}")
    public PersonResponse getPersonById(@PathVariable("id")Long id) {
        return personService.getPersonById(id);
    }


    @PostMapping("/new_person")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid PersonRequest personRequest,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append("-").append(error.getDefaultMessage())
                        .append(";");
            }

        }
        personService.savePerson(personRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    /**
     * удаление персона по id
     *
     * @return
     */
    @DeleteMapping ("/{id}")
    public ResponseEntity<HttpStatus> deletePersonById(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * апдейт персона
     *
     * @param
     * @return
     */
    @PutMapping("/update_person")
    public ResponseEntity<HttpStatus> updatePerson(@RequestBody PersonRequest personRequest) {
        personService.updatePerson(personRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
