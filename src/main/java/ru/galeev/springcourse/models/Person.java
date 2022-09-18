package ru.galeev.springcourse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import java.util.List;


@Data
public class Person extends BaseEntity {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private int age;

    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private List<Role> roles;

    private List<Book> books;

}
