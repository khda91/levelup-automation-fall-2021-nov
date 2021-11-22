package ru.levelp.at.lesson06.page.object.page.composite;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.testng.annotations.Test;
import ru.levelp.at.lesson06.page.object.SeleniumBaseTest;
import ru.levelp.at.lesson06.page.object.page.composite.component.SberbankCardComponent;

public class SberbankRecommendCardTest extends SeleniumBaseTest {

    @Test
    public void recommendCardTest() {
        SberbankPersonalPage page = new SberbankPersonalPage(driver);

        List<SberbankCardComponent> recommendCards = page.getRecommendCards();

        recommendCards.get(1).clickTakeACreditButton();

        String actualTitle = driver.getTitle();

        assertThat(actualTitle).contains("Калькулятор Ипотеки в 2021");
    }
}
