package ru.bondarev.questionary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Вопросы",
        description = "Все методы для работы с вопросами"
)
public class QuestionController {

   private final QuestionService questionService;

    /**
     * Получение списка вопросов по id анкеты
     *
     * @param
     * @return
     */
    @GetMapping("/{quizid}")
    @Operation(summary = "Получение списка вопросов по id анкеты")
    public List<QuestionResponse> getAllQuestion(@Parameter(description = "id анкеты")@PathVariable("quizid") Long quizId) {
        return questionService.getAllQuestion(quizId);
    }

    /**
     * Получение  вопроса по id
     *
     * @param
     * @return
     */
    @GetMapping("question/{id}")
    @Operation(summary = "Получение  вопроса по id")
    public QuestionResponse getQuestion(@Parameter(description = "id вопроса") @PathVariable("id") Long id) {
        return questionService.getQuestionById(id);
    }

    /**
     * Сохранение вопроса
     *
     * @param questionRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "Сохранение вопроса")
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
    @Operation(summary = "Удаление вопроса")
    public ResponseEntity<HttpStatus> deleteQuestionById(@Parameter(description = "id вопроса")@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * обновление вопроса
     *
     * @param questionRequest
     * @return
     */
    @PutMapping("/question_update")
    @Operation(summary = "Обновление вопроса")
    public ResponseEntity<HttpStatus> updateQuestion(@Parameter(description = "id вопроса")
                                                         @PathVariable("id") Long id,
                                                         @RequestBody QuestionRequest questionRequest) {
        questionService.updateQuestion(id, questionRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
