package ru.levelp.at.lesson06.page.object.step.design.patern.step;

import org.openqa.selenium.WebDriver;

public abstract class UserBugRedBaseStep {

    protected WebDriver driver;

    protected UserBugRedBaseStep(WebDriver driver) {
        this.driver = driver;
    }
}
