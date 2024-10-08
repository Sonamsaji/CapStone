package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageWeb {

    WebDriver driver;
    WebDriverWait wait;

    public BasePageWeb() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickByUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


    public void waitForElementToPresent(String loc) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBePresentNotVisible(String loc) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loc)));
    }

    public void selectByValue(WebElement element, String value){
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public void waitForElementToBeInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresent(WebElement element) {
        try {
            setImplicitWait(15);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(30);
        }
    }

    public void setImplicitWait(long sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }
}
