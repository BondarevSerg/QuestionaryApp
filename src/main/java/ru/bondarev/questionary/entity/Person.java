package ru.bondarev.questionary.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Person {

    /**
     * id персона
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
     * имя
     */
    @Column(name = "firstname")
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "lastname")
    private String lastName;


}
