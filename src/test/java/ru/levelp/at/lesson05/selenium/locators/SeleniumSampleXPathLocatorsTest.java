package ru.levelp.at.lesson05.selenium.locators;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson05.selenium.SeleniumBaseTest;
import ru.levelp.at.util.SleepUtil;

public class SeleniumSampleXPathLocatorsTest extends SeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("http://users.bugred.ru/user/login/index.html");
    }

    @Test
    public void idXPathSelectorTest() {
        System.out.println("idXPathSelectorTest");
        // WebElement element = driver.findElement(By.cssSelector("#main-menu"));
        WebElement element = driver.findElement(By.xpath("//*[@id='main-menu']"));
        SleepUtil.sleep(1500);
        System.out.println(element.getText());
        System.out.println();
    }

    @Test
    public void classNameXPathSelectorTest() {
        System.out.println("classNameXPathSelectorTest");
        // WebElement element = driver.findElement(By.cssSelector(".nav-tabs"));
        WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'nav-tabs')]"));
        SleepUtil.sleep(1500);
        System.out.println(element.getText());
        System.out.println();
    }

    @Test
    public void nameXPathSelectorTest() {
        System.out.println("nameXPathSelectorTest");
        WebElement element = driver.findElement(By.xpath("//*[@name='name']"));
        SleepUtil.sleep(1500);
        element.sendKeys("Fedor");
        System.out.println(element.getAttribute("value"));
        SleepUtil.sleep(950);
        System.out.println();
    }

    @Test
    public void tagNameXPathSelectorTest() {
        System.out.println("tagNameXPathSelectorTest");
        List<WebElement> element = driver.findElements(By.xpath("//a"));
        SleepUtil.sleep(1500);
        System.out.println("Size of a elements is " + element.size());
        System.out.println();
    }

    @Test
    public void combinedXpathSelectorTest() {
        System.out.println("combinedXpathSelectorTest");
        // cssSelector("form[action='/user/register/index.html'] [name='password']")
        WebElement element = driver.findElement(By
            .xpath("//form[@action='/user/register/index.html']//*[@name='password']"));
        SleepUtil.sleep(1500);
        element.sendKeys("Fedor");
        System.out.println(element.getAttribute("value"));
        SleepUtil.sleep(950);
        System.out.println();
    }

    @Test
    public void parentXpathSelectorTest() {
        System.out.println("parentXpathSelectorTest");
        WebElement element = driver.findElement(By
            .xpath("//form[@action='/user/register/index.html']//*[@name='password']/../.."));
        SleepUtil.sleep(1500);
        System.out.println(element.getText());
        System.out.println(element.getTagName());
        System.out.println();
    }
}
