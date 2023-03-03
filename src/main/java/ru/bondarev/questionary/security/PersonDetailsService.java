package ru.bondarev.questionary.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.bondarev.questionary.entity.Person;
import ru.bondarev.questionary.repositories.PersonRepository;
@Service
@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final  Person person = personRepository.findByLogin(username);
        if (person == null)
            throw new UsernameNotFoundException("Пользователь не найден");

        return new PersonDetails(person);
    }
}
