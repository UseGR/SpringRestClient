package ru.galeev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.galeev.springcourse.models.Person;

import java.util.List;

@Component
public class PeopleServiceClient {
    private final RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/auth";

    @Autowired
    public PeopleServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<Person> getAllPeople() {
        ResponseEntity<List<Person>> responseEntity =
                restTemplate.exchange(URL + "/users", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
        return responseEntity.getBody();
    }

    public Person getPersonById(long id) {
        ResponseEntity<Person> responseEntity =
                restTemplate.exchange(URL + "/users/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
        return responseEntity.getBody();
    }

}
