package ru.levelp.at.lesson06.page.object.sample;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.math.BigDecimal;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SberbankPersonPage {

    private static final String URL = "https://sberbank.ru";

    @FindBy(xpath = "//*[contains(@data-pid, 'RatesCalcMain')]")
    private WebElement ratesCalculatorWidget;

    @FindBy(xpath = "//*[@data-test-id='Input_RatesCalcMainSale']")
    private WebElement ratesCalculatorSaleInputField;

    @FindBy(xpath = "//*[@data-test-id='Input_RatesCalcMainGet']")
    private WebElement ratesCalculatorGetInputField;

    @FindBy(xpath = "//td[./div[@data-test-id='RatesCalcMain_EUR-title']]/following-sibling::td[2]")
    private WebElement eurSaleExchangeRateLabel;

    private final WebDriver driver;
    private WebDriverWait wait;

    public SberbankPersonPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(URL);
    }

    public void sendKeysToRatesSaleInputField(String amount) {
        ratesCalculatorWidget = wait.until(visibilityOf(ratesCalculatorWidget));
        new Actions(driver)
            .moveToElement(ratesCalculatorWidget)
            .build()
            .perform();

        wait.until(visibilityOf(ratesCalculatorSaleInputField)).clear();
        ratesCalculatorSaleInputField.sendKeys(amount);
    }

    public BigDecimal getRatesCalculatorGetInputFieldText() {
        String amount = wait.until(visibilityOf(ratesCalculatorGetInputField))
                            .getAttribute("value").replace(",", ".");
        return new BigDecimal(amount);
    }

    public BigDecimal getEurSaleExchangeRateLabelText() {
        String amount = wait.until(visibilityOf(eurSaleExchangeRateLabel))
                            .getText().replace(",", ".");
        return new BigDecimal(amount);
    }
}
