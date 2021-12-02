package ru.levelp.at.lesson08.serialization.deserialization.model;

import java.io.Serializable;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private Integer age;
    private Address address;

    public Person(String firstName, String lastName, Integer age,
                  Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{"
            + "firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", age=" + age
            + ", address=" + address
            + '}';
    }
}
