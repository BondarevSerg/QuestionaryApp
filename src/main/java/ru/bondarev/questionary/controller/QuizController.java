package ru.bondarev.questionary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@Tag(
        name = "Анкета",
        description = "Все методы для работы с анкетами"
)
public class QuizController {
    private final QuizServiceImp quizService;

    /**
     * Получение списка анкет
     *
     * @return
     */
    @GetMapping()
    @Operation(summary = "Получение списка анкет")
    public List<QuizResponse> getAllQuiz() {
        return quizService.getAllQuiz();
    }

    /**
     * Получение анкеты по id
     *
     * @return
     */

    @GetMapping("/{id}")
    @Operation(summary = "Получение анеты по id")
    public QuizResponse getQuizById(@Parameter(description = "id анкеты") @PathVariable("id") Long id) {
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
    @Operation(summary = "Сохранение анкеты")
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
    @Operation(summary = "Удаление анкеты")
    public ResponseEntity<HttpStatus> deleteQuizById(@Parameter(description = "id анкеты")@PathVariable("id") Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * обновление анкеты
     *
     * @param
     * @return
     */
    @PutMapping("/{id}")
    @Operation(summary = "Обновление анкеты")
    public ResponseEntity<HttpStatus> updateQuiz(@Parameter(description = "id пользователя") @PathVariable("id") Long id,@RequestBody QuizRequest quizRequest) {
        quizService.updateQuiz(id, quizRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
