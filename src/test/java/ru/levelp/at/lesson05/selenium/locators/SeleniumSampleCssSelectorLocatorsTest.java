package ru.levelp.at.lesson05.selenium.locators;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson05.selenium.SeleniumBaseTest;
import ru.levelp.at.util.SleepUtil;

public class SeleniumSampleCssSelectorLocatorsTest extends SeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("http://users.bugred.ru/user/login/index.html");
    }

    @Test
    public void idCssSelectorTest() {
        System.out.println("idCssSelectorTest");
        // WebElement element = driver.findElement(By.cssSelector("[id = 'main-menu']"));
        WebElement element = driver.findElement(By.cssSelector("#main-menu"));
        SleepUtil.sleep(1500);
        System.out.println(element.getText());
        System.out.println();
    }

    @Test
    public void classNameCssSelectorTest() {
        System.out.println("classNameCssSelectorTest");
        // WebElement element = driver.findElement(By.cssSelector("[class = 'nav-tabs']"));
        WebElement element = driver.findElement(By.cssSelector(".nav-tabs"));
        SleepUtil.sleep(1500);
        System.out.println(element.getText());
        System.out.println();
    }

    @Test
    public void nameCssSelectorTest() {
        System.out.println("nameCssSelectorTest");
        WebElement element = driver.findElement(By.cssSelector("[name = 'name']"));
        SleepUtil.sleep(1500);
        element.sendKeys("Fedor");
        System.out.println(element.getAttribute("value"));
        SleepUtil.sleep(950);
        System.out.println();
    }

    @Test
    public void tagNameCssSelectorTest() {
        System.out.println("tagNameCssSelectorTest");
        List<WebElement> element = driver.findElements(By.cssSelector("a"));
        SleepUtil.sleep(1500);
        System.out.println("Size of a elements is " + element.size());
        System.out.println();
    }

    @Test
    public void combinedCssSelectorTest() {
        System.out.println("combinedCssSelectorTest");
        WebElement element = driver.findElement(By
            .cssSelector("form[action='/user/register/index.html'] [name='password']"));
        SleepUtil.sleep(1500);
        element.sendKeys("Fedor");
        System.out.println(element.getAttribute("value"));
        SleepUtil.sleep(950);
        System.out.println();
    }
}
