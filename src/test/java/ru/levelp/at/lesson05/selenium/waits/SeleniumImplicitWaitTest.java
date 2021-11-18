package ru.levelp.at.lesson05.selenium.waits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.xpath;

import java.math.BigDecimal;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson05.selenium.SeleniumBaseTest;
import ru.levelp.at.lesson05.selenium.SeleniumSampleTest;

public class SeleniumImplicitWaitTest extends SeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(SeleniumSampleTest.SBERBANK_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
    }

    @Test
    public void currencyConverterTest() {
        WebElement element = driver.findElement(xpath("//*[contains(@data-pid, 'RatesCalcMain')]"));

        new Actions(driver)
            .moveToElement(element)
            .build()
            .perform();

        WebElement saleCurrencyTextField =
            driver.findElement(xpath("//*[@data-test-id='Input_RatesCalcMainSale']"));
        saleCurrencyTextField.clear();
        saleCurrencyTextField.sendKeys("7000");

        WebElement getCurrencyTextField = driver.findElement(xpath("//*[@data-test-id='Input_RatesCalcMainGet']"));
        String actualGetCurrencyValue = getCurrencyTextField.getAttribute("value");
        var actualAmount = new BigDecimal(actualGetCurrencyValue.replace(",", "."));
        WebElement saleCurrencyExchangeRate = driver
            .findElement(xpath("//td[./div[@data-test-id='RatesCalcMain_EUR-title']]/following-sibling::td"));
        String saleCurrencyExchangeRateText = saleCurrencyExchangeRate.getText();
        var expectedAmount = new BigDecimal("7000")
            .divide(new BigDecimal(saleCurrencyExchangeRateText.replace(",", ".")));

        assertThat(actualAmount).isEqualTo(expectedAmount);
    }

    @Test
    public void currencyConverterFailTest() {
        WebElement element = driver.findElement(xpath("//*[contains(@data-pid, 'RatesCalcMain')]"));

        new Actions(driver)
            .moveToElement(element)
            .build()
            .perform();

        WebElement saleCurrencyTextField =
            driver.findElement(xpath("//*[@data-test-id='Input_RatesCalcMainSale1']"));
        saleCurrencyTextField.clear();
        saleCurrencyTextField.sendKeys("7000");

        WebElement getCurrencyTextField = driver.findElement(xpath("//*[@data-test-id='Input_RatesCalcMainGet']"));
        String actualGetCurrencyValue = getCurrencyTextField.getAttribute("value");
        double actualAmount = Double.parseDouble(actualGetCurrencyValue.replace(",", "."));
        WebElement saleCurrencyExchangeRate = driver
            .findElement(xpath("//td[./div[@data-test-id='RatesCalcMain_EUR-title']]/following-sibling::td"));
        String saleCurrencyExchangeRateText = saleCurrencyExchangeRate.getText();
        double expectedAmount = Double.parseDouble("7000")
            / Double.parseDouble(saleCurrencyExchangeRateText.replace(",", "."));

        assertThat(actualAmount).isEqualTo(expectedAmount);
    }

    @Test
    public void currencyConverterFailWithFindElementsTest() {
        WebElement element = driver.findElement(xpath("//*[contains(@data-pid, 'RatesCalcMain')]"));

        new Actions(driver)
            .moveToElement(element)
            .build()
            .perform();

        WebElement saleCurrencyTextField =
            driver.findElement(xpath("//*[@data-test-id='Input_RatesCalcMainSale']"));
        saleCurrencyTextField.clear();
        saleCurrencyTextField.sendKeys("7000");

        WebElement getCurrencyTextField = driver.findElement(xpath("//*[@data-test-id='Input_RatesCalcMainGet']"));
        String actualGetCurrencyValue = getCurrencyTextField.getAttribute("value");
        double actualAmount = Double.parseDouble(actualGetCurrencyValue.replace(",", "."));
        var saleCurrencyExchangeRate = driver
            .findElements(xpath("//td[./div[@data-test-id='RatesCalcMain_EUR-title1']]/following-sibling::td"));
        String saleCurrencyExchangeRateText = saleCurrencyExchangeRate.get(0).getText();
        double expectedAmount = Double.parseDouble("7000")
            / Double.parseDouble(saleCurrencyExchangeRateText.replace(",", "."));

        assertThat(actualAmount).isEqualTo(expectedAmount);
    }
}
