package ru.galeev.springcourse.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.Date;

@Data
public class BaseEntity {
    @JsonIgnore
    private Date created;
    @JsonIgnore
    private Date updated;

    private Status status;
}
