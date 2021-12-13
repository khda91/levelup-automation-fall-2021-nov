package ru.levelp.at.lesson13.bdd.context;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static TestContext instance;

    private Map<String, Object> context = new HashMap<>();

    private TestContext() {

    }

    public void setObject(final String key, final Object object) {
        context.put(key, object);
    }

    public <T> T getObject(final String key, Class<T> objectClass) {
        return objectClass.cast(context.get(key));
    }

    public void cleanUp() {
        context.clear();
        instance = null;
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
