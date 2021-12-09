package ru.levelp.at.lesson12.design.pattern.factory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    private ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    protected abstract WebDriver createDriver();

    public void quit() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.remove();
        }
    }

    public WebDriver getDriver() {
        if (drivers.get() == null) {
            WebDriver driver = createDriver();
            drivers.set(driver);
        }

        return drivers.get();
    }
}
