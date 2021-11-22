package ru.levelp.at.lesson06.page.object.page.composite;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelp.at.lesson06.page.object.page.composite.component.SberbankCardComponent;

public class SberbankPersonalPage extends SberbankBasePage {

    @FindBy(xpath = "//*[@class='ps-carousel__cards']/a")
    private List<WebElement> recommendCards;

    public SberbankPersonalPage(WebDriver driver) {
        super(driver);
    }

    public List<SberbankCardComponent> getRecommendCards() {
        return recommendCards.stream()
            .map(card -> new SberbankCardComponent(driver, card))
            .collect(Collectors.toList());
    }
}
