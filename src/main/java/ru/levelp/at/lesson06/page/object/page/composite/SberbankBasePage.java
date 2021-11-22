package ru.levelp.at.lesson06.page.object.page.composite;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson06.page.object.page.composite.component.SberbankBaseComponent;

public abstract class SberbankBasePage extends SberbankBaseComponent {

    protected SberbankBasePage(WebDriver driver) {
        super(driver);
    }
}
