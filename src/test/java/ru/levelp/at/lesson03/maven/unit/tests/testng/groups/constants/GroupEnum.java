package ru.levelp.at.lesson03.maven.unit.tests.testng.groups.constants;

public enum GroupEnum {

    POSITIVE("POSITIVE"),
    NEGATIVE("NEGATIVE");

    String name;

    GroupEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
