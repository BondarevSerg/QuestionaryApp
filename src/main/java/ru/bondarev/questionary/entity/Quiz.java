package ru.bondarev.questionary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Анкета
 */
@Entity
@Table(name = "quizes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Quiz {

    /**
     * id анкеты
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Заголовок
     */
    @Column(name = "title")
    private String title;

    /**
     * Список вопросов
     */
    @OneToMany(mappedBy = "quiz")
    private List<Question> questions;




}
