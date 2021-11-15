package ru.levelp.at.lesson05.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.levelp.at.util.SleepUtil;

public class SeleniumSampleTest {

    public static final String SBERBANK_URL = "https://www.sberbank.ru/ru/person";

    @Test
    public void sampleTest() {
        // System.setProperty("webdriver.chrome.driver", "<тут должен быть путь до бинарников драйвера,"
        // + "которые скачиваются по ссылкам>");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        SleepUtil.sleep(2000);

        driver.navigate().to(SBERBANK_URL);

        SleepUtil.sleep(2000);

        assertThat(driver.getTitle()).isEqualTo("Частным клиентам — СберБанк");

        driver.quit();
    }
}
