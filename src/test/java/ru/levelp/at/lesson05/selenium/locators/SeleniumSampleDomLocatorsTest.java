package ru.levelp.at.lesson05.selenium.locators;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson05.selenium.SeleniumBaseTest;
import ru.levelp.at.util.SleepUtil;

public class SeleniumSampleDomLocatorsTest extends SeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("http://users.bugred.ru/user/login/index.html");
    }

    @Test
    public void idDomSelectorTest() {
        System.out.println("idDomSelectorTest");
        WebElement element = driver.findElement(By.id("main-menu"));
        SleepUtil.sleep(1500);
        System.out.println(element.getText());
        System.out.println();
    }

    @Test
    public void classNameDomSelectorTest() {
        System.out.println("classNameDomSelectorTest");
        WebElement element = driver.findElement(By.className("nav-tabs"));
        SleepUtil.sleep(1500);
        System.out.println(element.getText());
        System.out.println();
    }

    @Test
    public void nameDomSelectorTest() {
        System.out.println("nameDomSelectorTest");
        WebElement element = driver.findElement(By.name("name"));
        SleepUtil.sleep(1500);
        element.sendKeys("Fedor");
        System.out.println(element.getAttribute("value"));
        SleepUtil.sleep(950);
        System.out.println();
    }

    @Test
    public void tagNameDomSelectorTest() {
        System.out.println("tagNameDomSelectorTest");
        List<WebElement> element = driver.findElements(By.tagName("a"));
        SleepUtil.sleep(1500);
        System.out.println("Size of a elements is " + element.size());
        System.out.println();
    }

    @Test
    public void linkTextDomSelectorTest() {
        System.out.println("linkTextDomSelectorTest");
        WebElement element = driver.findElement(By.linkText("О проекте"));
        SleepUtil.sleep(1500);
        System.out.println(element.getText());
        System.out.println();
    }

    @Test
    public void partialLinkTextDomSelectorTest() {
        System.out.println("partialLinkTextDomSelectorTest");
        WebElement element = driver.findElement(By.partialLinkText("Полная"));
        SleepUtil.sleep(1500);
        System.out.println(element.getText());
        System.out.println();
    }
}
