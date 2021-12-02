package ru.levelp.at.lesson10.jenkins.step;

import org.openqa.selenium.WebDriver;

public abstract class UserBugRedBaseStep {

    protected WebDriver driver;

    protected UserBugRedBaseStep(WebDriver driver) {
        this.driver = driver;
    }
}
