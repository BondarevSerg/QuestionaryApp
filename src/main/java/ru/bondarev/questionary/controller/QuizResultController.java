package ru.bondarev.questionary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Результаты опроса",
        description = "Все методы для работы с результатом"
)
public class QuizResultController {


    private  final QuizResultServiceImp quizResultService;
    /**
     * Получение списка результатов
     *
     * @param
     * @return
     */
    @GetMapping()
    @Operation(summary = "Получение списка результатов опроса")
    public List<QuizResultResponse> getAllQuizResult() {
        return quizResultService.getAllQuizResult();
    }

    /**
     * Получение списка результатов по id пользователя
     *
     * @param
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получение списка результатов по id пользователя")
    public List<QuizResultResponse> getAllQuizResult(@Parameter(description = "id пользователя")@PathVariable("id") Long personId) {
        return quizResultService.getQuizResultsByPersonId(personId);
    }

    /**
     * Сохранение результата
     *
     * @param quizResultRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "Сохранение результата")
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
    @Operation(summary = "Удаление результата")
    public ResponseEntity<HttpStatus> deleteQuizById(@Parameter(description = "id пользователя")@PathVariable("id") Long id) {
        quizResultService.deleteQuizResult(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * обновление результата
     *
     * @param quizResultRequest
     * @return
     */
    @PutMapping("/{id}")
    @Operation(summary = "обновление результата по id")
    public ResponseEntity<HttpStatus> updateQuizResult(@Parameter(description = "id пользователя")
                                                           @PathVariable("id") Long id,
                                                           @RequestBody QuizResultRequest quizResultRequest) {
        quizResultService.updateQuizResult(id, quizResultRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
