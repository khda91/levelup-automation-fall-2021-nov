package ru.levelp.at.lesson11.allure.step;

import org.openqa.selenium.WebDriver;

public abstract class UserBugRedBaseStep {

    protected WebDriver driver;

    protected UserBugRedBaseStep(WebDriver driver) {
        this.driver = driver;
    }
}
