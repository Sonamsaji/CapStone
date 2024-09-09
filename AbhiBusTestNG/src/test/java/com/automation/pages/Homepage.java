package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends BasePage {
    //locator for search button
    @FindBy(id = "search-button")
    WebElement searchButton;

    @FindBy(xpath = "//h1[@class='search-page-title']")
    WebElement searchTitle;

    //locator for clicking Offers Icon
    @FindBy(id = "offers-link")
    WebElement offers;

    @FindBy(id = "search-from")
    WebElement fromStation;

    @FindBy(id = "search-to")
    WebElement toStation;

    @FindBy(xpath = "//div[@class=' col auto'][2]/span[@class='calender-month-change']")
    WebElement forwardChangeOfMonth;

    @FindBy(xpath = "//div[2]/div[1]/div[2]/span[1]")
    WebElement month;

    @FindBy(xpath = "//input[@placeholder='Onward Journey Date']")
    WebElement dateInputField;

    //locator for quick links
    @FindBy(xpath = "//button[text()=\"Quick Links\"]")
    WebElement quickLink;

    //locator for clicking cancel booking
    @FindBy(xpath = "//*[@id=\"footer-routes\"]//div[5]/a")
    WebElement cancelBooking;

    public void openWebsite() {
        driver.get(ConfigReader.getConfigProperty("url"));
    }

    public boolean isUserOnHomePage() {
        return searchButton.isDisplayed() && searchTitle.isDisplayed();
    }

    public void userClicksOffersIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        offers.click();
    }

    public void enterFromAndToStation() {
        fromStation.click();
        String fromCity = "//div[text()='" + ConfigReader.getConfigProperty("fromStation") + "']";
        driver.findElement(By.xpath(fromCity)).click();
        toStation.click();
        String toCity = "//div[text()='" + ConfigReader.getConfigProperty("toStation") + "']";
        driver.findElement(By.xpath(toCity)).click();

    }

    public int monthNumber() {
        int c = 0;
        String[] listOfMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < listOfMonth.length; i++) {
            if (ConfigReader.getConfigProperty("month").equals(listOfMonth[i])) {
                c = i + 1;
                break;
            }
        }
        return c;
    }

    public void enterDate() {

        dateInputField.click();
        while (!month.getText().equals(ConfigReader.getConfigProperty("month"))) {
            forwardChangeOfMonth.click();
        }

        String dateXpath = "//div[2]/span[@data-date='" + ConfigReader.getConfigProperty("day") + "' and @data-month='" + monthNumber() + "']";
        WebElement date = driver.findElement(By.xpath(dateXpath));
        date.click();
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickQuickLinks() {
        quickLink.click();
    }

    public void userCancelBooking() {
        cancelBooking.click();
    }

}
