package ru.bondarev.questionary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Вопрос
 */
@Entity
@Table(name = "Questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Question {
    /**
     * id вопроса
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Текст вопроса
     */
    @Column(name = "title")
    private String title;

    /**
     * Анкета
     */
    @ManyToOne
    @JoinColumn(name = "quizID", referencedColumnName = "id")
    private Quiz quiz;


    /**
     * Список ответов
     */
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;







}
