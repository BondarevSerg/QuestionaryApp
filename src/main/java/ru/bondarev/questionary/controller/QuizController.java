package ru.bondarev.questionary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.questionary.dto.request.QuizRequest;
import ru.bondarev.questionary.dto.response.QuizResponse;
import ru.bondarev.questionary.service.Imp.QuizServiceImp;

import java.util.List;

/**
 * Контроллер работы с анкетами
 */
@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizServiceImp quizService;

    /**
     * Получение списка анкет
     *
     * @return
     */
    @GetMapping()
    public List<QuizResponse> getAllQuiz() {
        return quizService.getAllQuiz();
    }

    /**
     * Получение анкеты по id
     *
     * @return
     */

    @GetMapping("/{id}")
    public QuizResponse getQuizById(@PathVariable("id") Long id) {
        return quizService.getQuizById(id);
    }

    /**
     * Сохранение анкеты
     *
     * @param quizRequest
     * @param
     * @return
     */
    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid QuizRequest quizRequest) {
        quizService.saveQuiz(quizRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * удаление анкеты по id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteQuizById(@PathVariable("id") Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * апдейт анкеты
     *
     * @param
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateQuiz(@RequestBody QuizRequest quizRequest) {
        quizService.updateQuiz(quizRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
