package ru.bondarev.questionary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.questionary.dto.request.QuizResultRequest;
import ru.bondarev.questionary.dto.response.QuizResultResponse;
import ru.bondarev.questionary.service.Imp.QuizResultServiceImp;


import java.util.List;

/**
 * контроллер результатов
 */
@RestController
@RequestMapping("/quizresults")
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
    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid QuizResultRequest quizResultRequest) {

        quizResultService.saveQuizResult(quizResultRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * удаление результата по id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
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
    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateQuizResult(@RequestBody QuizResultRequest quizResultRequest) {
        quizResultService.updateQuizResult(quizResultRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
