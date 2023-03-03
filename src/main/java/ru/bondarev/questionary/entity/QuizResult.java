package ru.bondarev.questionary.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Person person;

    /**
     * Анкета
     */
    @ManyToOne
    @JoinColumn(name = "quizid", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Quiz quiz;

    /**
     * Вопрос
     */
    @ManyToOne
    @JoinColumn(name = "questionid", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    /**
     * Ответ
     */
    @ManyToOne
    @JoinColumn(name = "answerid", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Answer answer;

}
