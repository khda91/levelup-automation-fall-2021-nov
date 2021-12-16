package ru.levelp.at.taf.example.trello.service.page.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrelloHeaderComponent extends TrelloBaseComponent {

    @FindBy(css = "[data-test-id='header-member-menu-button']")
    private WebElement headerMemberMenuButton;

    public TrelloHeaderComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderMemberMenuButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(headerMemberMenuButton)).isDisplayed();
    }

}
