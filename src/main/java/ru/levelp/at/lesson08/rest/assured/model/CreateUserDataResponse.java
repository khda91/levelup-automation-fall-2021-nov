package ru.levelp.at.lesson08.rest.assured.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDataResponse {

    private Integer id;
    private String name;
    private String job;
    private String createdAt;
}
