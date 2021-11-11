package ru.levelp.at.lesson03.maven.unit.tests.junit.data.provider;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NullEmptyExampleTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    public void nullTest(String text) {
        System.out.println("text = \"" + text + "\"");
        assertTrue(text == null || text.trim().isEmpty());
    }
}
