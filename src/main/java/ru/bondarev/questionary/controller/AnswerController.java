package ru.bondarev.questionary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.questionary.dto.request.AnswerRequest;
import ru.bondarev.questionary.dto.response.AnswerResponse;
import ru.bondarev.questionary.service.Imp.AnswerServiceImp;
import java.util.List;

/**
 * контроллер ответов
 */
@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
@Tag(
        name = "Ответы",
        description = "Все методы для работы с ответами"
)
public class AnswerController {

    public final AnswerServiceImp answerService;

    /**
     * Получение списка ответов по id вопроса
     *
     * @param questionId
     * @return
     */
    @GetMapping("/{questionId}")
    @Operation(summary = "Получение списка ответов по id вопроса")
    public List<AnswerResponse> getAllAnswers(@Parameter(description = "id вопроса")@PathVariable("questionId") Long questionId) {
        return answerService.getAllAnswers(questionId);
    }

    /**
     * Получение ответа по id
     *
     * @param
     * @return
     */
    @GetMapping("/answer/{id}")
    @Operation(summary = "Получение ответа по id")
    public AnswerResponse getAnswer(@Parameter(description = "id ответа")@PathVariable("id") Long id) {
        return answerService.getAnswerById(id);
    }

    /**
     * Сохранение ответа
     *
     * @param answerRequest
     * @param
     * @return
     */
    @PostMapping()
    @Operation(summary = "Создание ответа")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid AnswerRequest answerRequest) {

        answerService.saveAnswer(answerRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * удаление ответа по id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление ответа по id")
    public ResponseEntity<HttpStatus> deleteAnswer(@Parameter(description = "id ответа")@PathVariable("id") Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * обновление ответа
     *
     * @param
     * @return
     */
    @PutMapping("/{id}")
    @Operation(summary = "обновление ответа по id")
    public ResponseEntity<HttpStatus> updateAnswer(@Parameter(description = "id ответа") @PathVariable("id") Long id, @RequestBody AnswerRequest answerRequest) {
        answerService.updateAnswer(id, answerRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
