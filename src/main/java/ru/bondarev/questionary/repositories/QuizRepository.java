package ru.bondarev.questionary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.questionary.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
