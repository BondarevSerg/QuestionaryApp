package ru.bondarev.questionary.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

/**
 * Роль пользователя (Для Security)
 */
@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Person> persons;
}
