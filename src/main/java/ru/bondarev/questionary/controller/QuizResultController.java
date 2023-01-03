package ru.bondarev.questionary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.questionary.dto.request.QuizResultRequest;
import ru.bondarev.questionary.dto.response.QuizResultResponse;
import ru.bondarev.questionary.service.Imp.QuizResultServiceImp;


import java.util.List;

/**
 * контроллер результатов
 */
@RestController
@RequestMapping("/quizresult")
@RequiredArgsConstructor
public class QuizResultController {


    private  final QuizResultServiceImp quizResultService;
    /**
     * Получение списка результатов
     *
     * @param
     * @return
     */
    @GetMapping()
    public List<QuizResultResponse> getAllQuizResult() {
        return quizResultService.getAllQuizResult();
    }

    /**
     * Получение списка результатов по id персона
     *
     * @param
     * @return
     */
    @GetMapping("/{id}")
    public List<QuizResultResponse> getAllQuizResult(@PathVariable("id") Long personId) {
        return quizResultService.getQuizResultsByPersonId(personId);
    }

    /**
     * Сохранение результата
     *
     * @param quizResultRequest
     * @return
     */
    @PostMapping("/new_quizResult")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid QuizResultRequest quizResultRequest,
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
        quizResultService.saveQuizResult(quizResultRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * удаление результата
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete_quizresult/{id}")
    public ResponseEntity<HttpStatus> deleteQuizById(@PathVariable("id") Long id) {
        quizResultService.deleteQuizResult(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * апдейт результата
     *
     * @param quizResultRequest
     * @return
     */
    @PutMapping("/update_quizresult")
    public ResponseEntity<HttpStatus> updateQuizResult(
                                                       @RequestBody QuizResultRequest quizResultRequest) {
        quizResultService.updateQuizResult(quizResultRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
