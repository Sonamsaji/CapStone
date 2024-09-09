package com.automation.pages.mob;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class TrainsPageMobile extends BasePageMobile {
    //locator for entering source
    @FindBy(xpath = "//android.view.View[@resource-id=\"root\"]/android.view.View[2]/android.view.View[2]")
    WebElement source;
    //locator for enter source
    @FindBy(xpath = "//android.view.View[@resource-id=\"station-list-item-0\"][1]")
    WebElement enterSource;
    @FindBy(xpath = "//android.widget.TextView[@text=\"New Delhi NDLS\"]")
    WebElement clickDelhi;
    //locator for entering destination
    @FindBy(xpath = "//android.view.View[@text=\"Enter To\"]")
    WebElement destination;
    //locator for enter destination
    @FindBy(xpath = "//android.widget.TextView[@text=\"MUMBAI CENTRAL MMCT\"]")
    WebElement enterDestination;
    //locator clicking search button
    @FindBy(xpath = "//android.widget.Button[@text=\"SEARCH TRAINS\"]")
    WebElement searchBtn;
    //locator for container
    @FindBy(xpath = "//android.view.View[@resource-id=\"root\"]/android.view.View[5]")
    WebElement verifyContainer;
    //locator for clicking today
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"today\"]")
    WebElement todayDate;
    //locator for clicking tomorrow
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"tomorrow\"]")
    WebElement tomorrowDate;
    //locator for clicking day after
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"dayAfter\"]")
    WebElement dayAfter;
    //locator for getting getDate
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"journey-date\"]")
    WebElement dateElement;
    //locator for loading container
    @FindBy(xpath = "new UiSelector().className(\"android.widget.EditText\")")
    WebElement sentTextToSource;

    public boolean isUserOnTrainBookingPage() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        return searchBtn.isDisplayed();
    }

    public void userEnterSource() {
        source.click();
        sentTextToSource.sendKeys("New Delhi");
        enterSource.click();
    }

    public void userEnterDestination() {
        destination.click();
//        sentTextToSource.sendKeys("Mumbai");
//        enterSource.click();
        enterDestination.click();
    }

    public void userClickSearchButton() {
        searchBtn.click();
    }

    public boolean verifyTrainResults() {
        return verifyContainer.isDisplayed();
    }

    public void clickToday() {
        todayDate.click();
    }

    public void verifyTodayDateIsShowing() {
        // Get today's date in yyyy-MM-dd format
        LocalDate today = LocalDate.now();
        System.out.println("today date: " + today);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM");
        String expectedDate = today.format(formatter);
        // Retrieve the date displayed in the application
        String actualDate = dateElement.getText().trim();
        // Check if the actual date matches the expected date
        System.out.println(actualDate);
        System.out.println(expectedDate);
        assert actualDate.equals(expectedDate) : "Expected date: " + expectedDate + " but found: " + actualDate;
    }


    public void clickTomorrow() {
        tomorrowDate.click();
    }

    public void verifyTomorrow() {
        // Get tomorrow's date
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM");
        String expectedDate = tomorrow.format(formatter);
        String actualDate = dateElement.getText().trim();
        System.out.println(actualDate);
        System.out.println(expectedDate);
        assert actualDate.equals(expectedDate) : "Expected tomorrow date: " + expectedDate + " but found: " + actualDate;
    }

    public void clickDayAfter() {
        dayAfter.click();
    }

    public void verifyDayAfter() {
        // Get tomorrow's date
        LocalDate tomorrow = LocalDate.now().plusDays(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM");
        String expectedDate = tomorrow.format(formatter);
        String actualDate = dateElement.getText().trim();
        System.out.println(actualDate);
        System.out.println(expectedDate);
        assert actualDate.equals(expectedDate) : "Expected tomorrow date: " + expectedDate + " but found: " + actualDate;
    }
}
