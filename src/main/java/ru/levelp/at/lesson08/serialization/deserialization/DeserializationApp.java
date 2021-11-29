package ru.levelp.at.lesson08.serialization.deserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import ru.levelp.at.lesson08.serialization.deserialization.model.Person;

public class DeserializationApp {

    public static void main(String[] args) {
        Person vasya = null;
        Person petya = null;
        try (ObjectInputStream personOis =
                 new ObjectInputStream(new FileInputStream("lesson08/ser_output.txt"))) {

            vasya = (Person) personOis.readObject();
            petya = (Person) personOis.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(vasya);
        System.out.println("=========");
        System.out.println(petya);
    }
}
