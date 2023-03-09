package ru.bondarev.questionary.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



/**
 * Ответ
 */
@Entity
@Table(name = "answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Answer {
    /**
     * id ответа
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Вопрос
     */
    @ManyToOne
    @JoinColumn(name = "questionID", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    /**
     * Текст ответа
     */
    @Column(name = "answer")
    private String title;



}
