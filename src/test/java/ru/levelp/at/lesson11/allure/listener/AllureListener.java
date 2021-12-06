package ru.levelp.at.lesson11.allure.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.levelp.at.lesson11.allure.SeleniumBaseTest;

public class AllureListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Started -> " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished -> " + context.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // attachScreenshot(SeleniumBaseTest.driver); так делать не надо!!!
        var driver = (WebDriver) result.getTestContext().getAttribute("web.driver");
        attachScreenshot(driver);
    }

    @Attachment
    private byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
