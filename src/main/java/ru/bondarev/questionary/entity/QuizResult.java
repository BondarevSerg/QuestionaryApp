package ru.bondarev.questionary.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Результат опроса
 */
@Entity
@Table(name = "quizresult")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class QuizResult {

    /**
     * id результата
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Пользователь
     */
    @ManyToOne
    @JoinColumn(name = "personid", referencedColumnName = "id")
    private Person person;

    /**
     * Анкета
     */
    @ManyToOne
    @JoinColumn(name = "quizid", referencedColumnName = "id")
    private Quiz quiz;

    /**
     * Вопрос
     */
    @ManyToOne
    @JoinColumn(name = "questionid", referencedColumnName = "id")
    private Question question;

    /**
     * Ответ
     */
    @ManyToOne
    @JoinColumn(name = "answerid", referencedColumnName = "id")
    private Answer answer;

}
