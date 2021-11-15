package ru.levelp.at.util;

public final class SleepUtil {

    private SleepUtil() {
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
