package ru.levelp.at.lesson05.selenium.waits;

import static org.openqa.selenium.By.xpath;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson05.selenium.SeleniumBaseTest;
import ru.levelp.at.lesson05.selenium.SeleniumSampleTest;

public class SeleniumImplicitVsExplicitWaitsTest extends SeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(SeleniumSampleTest.SBERBANK_URL);
    }

    @Test
    public void implicitWaitLessThanExplicitWaitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        long start = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[contains(@data-pid, 'RatesCalcMain1')]")));
        } finally {
            long end = System.currentTimeMillis();
            logTime("implicitWaitLessThanExplicitWaitTest", start, end);
        }
    }

    @Test
    public void implicitWaitGreaterThanExplicitWaitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        long start = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[contains(@data-pid, 'RatesCalcMain1')]")));
        } finally {
            long end = System.currentTimeMillis();
            logTime("implicitWaitGreaterThanExplicitWaitTest", start, end);
        }
    }

    @Test
    public void implicitWaitLessThanExplicitWait1Test() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        var wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        long start = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[contains(@data-pid, 'RatesCalcMain1')]")));
        } finally {
            long end = System.currentTimeMillis();
            logTime("implicitWaitGreaterThanExplicitWaitTest", start, end);
        }
    }

    @Test
    public void implicitWaitAndExplicitWaitTogetherTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        var wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        long start = System.currentTimeMillis();
        // Получаем
        Duration implicitWaitTimeout = driver.manage().timeouts().getImplicitWaitTimeout();
        // Зануляем
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        try {
            wait.until(ExpectedConditions
                .visibilityOfElementLocated(xpath("//*[contains(@data-pid, 'RatesCalcMain1')]")));
        } finally {
            long end = System.currentTimeMillis();
            logTime("implicitWaitGreaterThanExplicitWaitTest", start, end);
            // Возвращаем на место
            driver.manage().timeouts().implicitlyWait(implicitWaitTimeout);
            System.out.println(String.format("Implicit wai value was returned to %d seconds",
                driver.manage().timeouts().getImplicitWaitTimeout().toSeconds()));
        }
    }

    void logTime(String methodName, long start, long end) {
        System.out.println(String.format("%s wait duration %d millis", methodName, (end - start)));
    }
}
