package ru.levelp.at.lesson03.maven.unit.tests;

import java.util.List;
import java.util.stream.Collectors;

public class StreamApplication {

    public static void main(String[] args) {
        List<String> lst = List.of("son", "sun", "SOS", "VOZ");

        List<String> finalCollection = lst.stream()
                                  .map(item -> item.replaceAll("s|S", ""))
                                  .collect(Collectors.toList());

        System.out.println("Initial list -> " + lst);
        System.out.println("Result -> " + finalCollection);
    }

    void someMethod() {

    }
}
