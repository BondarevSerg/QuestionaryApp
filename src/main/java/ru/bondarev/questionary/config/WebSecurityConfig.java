package ru.bondarev.questionary.config;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.bondarev.questionary.security.PersonDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Конфигурация Security
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    private final PersonDetailsService personDetailsService;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

         http
                .csrf().disable()
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HttpMethod.GET, "/persons").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/persons").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/persons").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.POST, "/persons").permitAll()
                        .requestMatchers(HttpMethod.GET, "/quiz").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.POST, "/quiz").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/quiz").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/quiz").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/questions").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.POST, "/questions").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/questions").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/questions").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/answers").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.POST, "/answers").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/answers").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/answers").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/quizresults").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/quizresults").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/quizresults").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/quizresults").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .userDetailsService(personDetailsService)
                .httpBasic(withDefaults());

         return http.build();
    }


    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
