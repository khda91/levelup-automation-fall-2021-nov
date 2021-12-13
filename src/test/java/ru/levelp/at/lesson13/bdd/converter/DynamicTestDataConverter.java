package ru.levelp.at.lesson13.bdd.converter;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import java.util.HashMap;
import java.util.Map;

public class DynamicTestDataConverter {

    private static final Faker FAKER = new Faker();

    private static final String USERNAME = "{username}";
    private static final String EMAIL = "{email}";
    private static final String PASSWORD = "{password}";

    public Map<String, String> convertUserTestData(DataTable dataTable) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> userMap = dataTable.asMap();

        for (String key : userMap.keySet()) {
            String value = userMap.get(key);
            switch (key) {
                case "username":
                    if (USERNAME.equals(value)) {
                        value = FAKER.name().username();
                    }
                    break;
                case "email":
                    if (EMAIL.equals(value)) {
                        value = FAKER.internet().emailAddress();
                    }
                    break;
                case "password":
                    if (PASSWORD.equals(value)) {
                        value = FAKER.internet().password();
                    }
                    break;
            }
            map.put(key, value);
        }

        return map;
    }
}
