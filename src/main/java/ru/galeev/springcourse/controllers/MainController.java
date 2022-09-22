package ru.galeev.springcourse.controllers;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import ru.galeev.springcourse.models.Person;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MainController {
    private final WebClient webClient;

    public MainController() {
        this.webClient = WebClient.create("http://localhost:8080/api/auth");
    }

    @GetMapping
    public List<Person> getPeople() {
        Mono<List<Person>> response = webClient
                .get()
                .uri("/users")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });

        return response.block();
    }


    @GetMapping("/{id}")
    public Mono<Person> getPersonById(@PathVariable(value = "id") Long id) {
        return webClient
                .get()
                .uri("users/{id}", id)
                .retrieve()
                .bodyToMono(Person.class);
    }
}
