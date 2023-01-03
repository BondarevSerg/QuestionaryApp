package ru.bondarev.questionary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.questionary.entity.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {


    List<Question> findAllByQuizId(long quizId);
    Question findByQuizIdAndId(long quizId, long id );
}
