package ru.galeev.springcourse.models;

import lombok.Data;

import java.util.List;


@Data
public class Role extends BaseEntity {
    private Long id;
    private String name;

    private List<Person> people;

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
