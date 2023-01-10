package ru.bondarev.questionary.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Пользователь
 */
@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Person {

    /**
     * id пользователя
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Логин
     */
    @Column(name = "login")
    private String login;

    /**
     * Имя
     */
    @Column(name = "firstname")
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "lastname")
    private String lastName;


}
