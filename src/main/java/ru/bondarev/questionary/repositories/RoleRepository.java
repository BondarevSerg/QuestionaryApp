package ru.bondarev.questionary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.questionary.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
