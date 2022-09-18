package ru.galeev.springcourse.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class Book extends BaseEntity {
    private Long id;

    @JsonIgnore
    private Person person;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bookDate;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", person=" + person.getFirstName() +
                ", name='" + name + '\'' +
                ", created=" + (bookDate.getYear() + 1900) +
                '}';
    }
}
