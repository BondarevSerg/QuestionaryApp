package ru.bondarev.questionary.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.questionary.dto.request.QuestionRequest;
import ru.bondarev.questionary.dto.response.QuestionResponse;
import ru.bondarev.questionary.service.QuestionService;

import java.util.List;

/**
 * Контроллер работы с вопросами
 */
@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

   private final QuestionService questionService;

    /**
     * Получение списка вопросов по id анкеты
     *
     * @param
     * @return
     */
    @GetMapping("/{quizid}")
    public List<QuestionResponse> getAllQuestion(@PathVariable("quizid") Long quizId) {
        return questionService.getAllQuestion(quizId);
    }

    /**
     * Получение  вопроса по id
     *
     * @param
     * @return
     */
    @GetMapping("question/{id}")
    public QuestionResponse getQuestion( @PathVariable("id") Long id) {
        return questionService.getQuestionById(id);
    }

    /**
     * Сохранение вопроса
     *
     * @param questionRequest
     * @return
     */
    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid QuestionRequest questionRequest) {

        questionService.saveQuestion(questionRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * удаление вопроса по id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteQuestionById(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * апдейт вопроса
     *
     * @param questionRequest
     * @return
     */
    @PutMapping("/question_update")
    public ResponseEntity<HttpStatus> updateQuestion(@RequestBody QuestionRequest questionRequest) {
        questionService.updateQuestion(questionRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
