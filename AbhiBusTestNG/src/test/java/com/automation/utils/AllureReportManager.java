package com.automation.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static com.automation.utils.DriverManager.getDriver;

public class AllureReportManager {

    public static void attachScreenShot() {
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        byte[] screenShot = ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("screenshot", new ByteArrayInputStream(screenShot));
    }

    public static void attachLog(String message) {
        Allure.addAttachment("Log", message);
    }
}
