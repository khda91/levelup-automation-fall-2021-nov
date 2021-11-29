package ru.levelp.at.lesson08.serialization.deserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import ru.levelp.at.lesson08.serialization.deserialization.model.Address;
import ru.levelp.at.lesson08.serialization.deserialization.model.Person;

public class SerializationApp {

    public static void main(String[] args) {
        Address addressVasya = new Address("Невский пр.", "40", "Санкт-Петербург");
        Address addressPetya = new Address("Ленинский пр.", "89", "Екатеринбург");
        var vasya = new Person("Vasya", "Vasiliev", 23, addressVasya);
        var petya = new Person("Petya", "Petrov", 28, addressPetya);

        ObjectOutputStream personOos = null;
        try {
            // не забыть создать lesson08 директорию в корне проекта
            personOos = new ObjectOutputStream(new FileOutputStream("lesson08/ser_output.txt"));
            personOos.writeObject(vasya);
            personOos.writeObject(petya);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (personOos != null) {
                try {
                    personOos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
