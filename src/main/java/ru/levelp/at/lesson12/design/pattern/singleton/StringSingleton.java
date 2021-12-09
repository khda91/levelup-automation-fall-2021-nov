package ru.levelp.at.lesson12.design.pattern.singleton;

import java.util.Objects;

public final class StringSingleton {

    private static StringSingleton instance;
    private String value;

    private StringSingleton() {
        value = "String singleton example";
    }

    public String getValue() {
        return value;
    }

    public static StringSingleton getInstance() {
        if (Objects.isNull(instance)) {
            System.out.println("new instance was created");
            instance = new StringSingleton();
        }
        return instance;
    }
}
