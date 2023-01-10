package ru.bondarev.questionary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private Question question;

    /**
     * Текст ответа
     */
    @Column(name = "answer")
    private String title;



}
