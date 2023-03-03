package ru.bondarev.questionary.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

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
    @Size(min=2, max=30)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "lastname")
    private String lastName;
    /**
     * пароль
     */
    @Column(name = "password")
    private String password;


    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "person_roles",joinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

}
