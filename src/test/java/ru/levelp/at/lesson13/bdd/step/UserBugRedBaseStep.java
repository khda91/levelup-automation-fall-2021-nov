package ru.levelp.at.lesson13.bdd.step;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson13.bdd.context.TestContext;

public abstract class UserBugRedBaseStep {

    protected WebDriver driver;

    public UserBugRedBaseStep() {
        this.driver = TestContext.getInstance().getObject("webDriver", WebDriver.class);
    }
}
