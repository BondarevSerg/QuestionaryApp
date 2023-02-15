package ru.bondarev.questionary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.questionary.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByLogin(String login);
}
