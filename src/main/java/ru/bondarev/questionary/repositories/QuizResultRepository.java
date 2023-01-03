package ru.bondarev.questionary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.questionary.entity.QuizResult;

import java.util.List;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {


    List<QuizResult> findAllByPersonId(Long id);
}
