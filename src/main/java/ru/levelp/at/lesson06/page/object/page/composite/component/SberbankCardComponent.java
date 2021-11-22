package ru.levelp.at.lesson06.page.object.page.composite.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SberbankCardComponent extends SberbankBaseComponent {

    private static final String TAKE_A_CREDIT = "./*[@class='ps-recommendcard__info']"
        + "//*[@class='ps-recommendcard__buttons']/a[text()='Подать заявку']";
    private static final String GET_MORE_INFO = "./*[@class='ps-recommendcard__info']"
        + "//*[@class='ps-recommendcard__buttons']/a[contains(text(), 'Подробнее')]";

    private WebElement root;

    public SberbankCardComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public void clickTakeACreditButton() {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root, By.xpath(TAKE_A_CREDIT))).click();
    }

    public void clickGetMoreInfoButton() {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root, By.xpath(GET_MORE_INFO))).click();
    }
}
