package ru.bondarev.questionary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.questionary.entity.Answer;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAllByQuestionId(long questionId);


}
