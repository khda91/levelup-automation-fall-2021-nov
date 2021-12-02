package ru.levelp.at.lesson05.selenium.additional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.xpath;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import ru.levelp.at.lesson05.selenium.SeleniumBaseTest;
import ru.levelp.at.util.SleepUtil;

public class SeleniumScreenshotTest extends SeleniumBaseTest {

    @Test
    public void screenshotTest() {
        SleepUtil.sleep(2000);
        WebElement element = driver.findElement(xpath("//*[contains(@data-pid, 'RatesCalcMain')]"));

        new Actions(driver)
            .moveToElement(element)
            .build()
            .perform();

        SleepUtil.sleep(2000);

        try {
            WebElement saleCurrencyTextField =
                driver.findElement(xpath("//*[@data-test-id='Input_RatesCalcMainSale']"));
            saleCurrencyTextField.clear();
            saleCurrencyTextField.sendKeys("7000");

            SleepUtil.sleep(2000);
            WebElement getCurrencyTextField = driver.findElement(xpath("//*[@data-test-id='Input_RatesCalcMainGet']"));
            String actualGetCurrencyValue = getCurrencyTextField.getAttribute("value");
            String expectedGetCurrencyValue = "100.00";

            assertThat(actualGetCurrencyValue).isEqualTo(expectedGetCurrencyValue);
        } finally {
            TakesScreenshot ts = (TakesScreenshot) this.driver;
            File screenshot = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File("target/mysceen.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
