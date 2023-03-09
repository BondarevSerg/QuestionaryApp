package ru.bondarev.questionary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.bondarev.questionary.entity.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByLogin(String login);


    @Query("SELECT p FROM Person p JOIN p.roles r WHERE r.name = :role")

    List<Person> findAllUserPerson(String role);

}
