package ru.bondarev.questionary.controller;

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
public class AnswerController {

    public final AnswerServiceImp answerService;

    /**
     * Получение списка ответов по id вопроса
     *
     * @param questionId
     * @return
     */
    @GetMapping("/{questionId}")
    public List<AnswerResponse> getAllAnswers(@PathVariable("questionId") Long questionId) {
        return answerService.getAllAnswers(questionId);
    }

    /**
     * Получение ответа по id
     *
     * @param
     * @return
     */
    @GetMapping("/answer/{id}")
    public AnswerResponse getAnswer(@PathVariable("id") Long id) {
        return answerService.getAnswerById(id);
    }

    /**
     * Сохранение ответа
     *
     * @param answerRequest
     * @param
     * @return
     */
    @PostMapping("/new_answer")
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
    @DeleteMapping("/delete_answer/{id}")
    public ResponseEntity<HttpStatus> deleteAnswer(@PathVariable("id") Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * апдейт ответа
     *
     * @param
     * @return
     */
    @PutMapping("/update_answer")
    public ResponseEntity<HttpStatus> updateAnswer(@RequestBody AnswerRequest answerRequest) {
        answerService.updateAnswer(answerRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
