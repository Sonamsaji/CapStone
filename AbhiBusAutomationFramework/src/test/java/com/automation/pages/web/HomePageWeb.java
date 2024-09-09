package com.automation.pages.web;

import com.automation.pages.interfaces.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

public class HomePageWeb extends BasePageWeb implements HomePage {


    //locator for CareerIcon
    @FindBy(id = "carreers-link")
    WebElement careerIcon;

    //locator for quick links
    @FindBy(xpath = "//button[text()=\"Quick Links\"]")
    WebElement quickLink;

    //locator for clicking cancel booking
    @FindBy(xpath = "//*[@id=\"footer-routes\"]//div[5]/a")
    WebElement cancelBooking;

    //locator for FAQ icon
    @FindBy(xpath = "//a[text()='FAQ']")
    WebElement faq;

    //locator for clicking Offers Icon
    @FindBy(id = "offers-link")
    WebElement offers;

    //locator for clicking trains icon on navigation bar
    @FindBy(xpath = "//a[@id='train-link']/span[text()='Trains']")
    WebElement train;

    //locator for loading bus booking container loads
    @FindBy(id = "srtc-container")
    WebElement busContainerLoading;

    //locator for clicking RSRTC
    @FindBy(xpath = "//div[@id='operator-container']//h3[text()='RSRTC']")
    WebElement RSRTC;


    @FindBy(id = "search-from")
    WebElement fromStation;

    @FindBy(id = "search-to")
    WebElement toStation;

    @FindBy(id = "bi-direction")
    WebElement swapButton;

    @FindBy(id = "search-button")
    WebElement searchButton;

    @FindBy(xpath = "//input[@placeholder='Onward Journey Date']")
    WebElement dateInputField;

    @FindBy(xpath = "//span[@class=' selected']")
    WebElement selectedDate;

    @FindBy(xpath = "//div[2]/div[1]/div[2]/span[1]")
    WebElement month;

    @FindBy(xpath = "//div[1]/div[2]/span[2]")
    WebElement year;

    @FindBy(xpath = "//div[@class=' col auto'][2]/span[@class='calender-month-change']")
    WebElement forwardChangeOfMonth;

    @FindBy(xpath = "//li[1]/div/div[2]/div/div[1]")
    WebElement stationAfterSwap;

    @FindBy(xpath = "//button[@class='btn active text tertiary md active button'][1]")
    WebElement todayButton;

    @FindBy(xpath = "//button[@class='btn active text tertiary md active button'][2]")
    WebElement tomorrowButton;

    @FindBy(xpath = "//span[@class='error']")
    WebElement searchErrorMessage;

    @FindBy(xpath = "//h1[@class='search-page-title']")
    WebElement searchTitle;


    public int monthNumber() {
        int c = 0;
        String[] listOfMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < listOfMonth.length; i++) {
            if (ConfigReader.getConfigValue("month").equals(listOfMonth[i])) {
                c = i + 1;
                break;
            }
        }
        return c;
    }

    public void openWebsite() {
        driver.get(ConfigReader.getConfigValue("url"));

    }

    public boolean isUserOnHomePage() {
        return searchButton.isDisplayed() && searchTitle.isDisplayed();
    }

    public void enterFromAndToStation() {
        fromStation.click();
        String fromCity = "//div[text()='" + ConfigReader.getConfigValue("fromStation") + "']";
        driver.findElement(By.xpath(fromCity)).click();
        toStation.click();
        String toCity = "//div[text()='" + ConfigReader.getConfigValue("toStation") + "']";
        driver.findElement(By.xpath(toCity)).click();

    }

    public void enterDate() {

        dateInputField.click();
        while (!month.getText().equals(ConfigReader.getConfigValue("month"))) {
            forwardChangeOfMonth.click();
        }

        String dateXpath = "//div[2]/span[@data-date='" + ConfigReader.getConfigValue("day") + "' and @data-month='" + monthNumber() + "']";
        WebElement date = driver.findElement(By.xpath(dateXpath));
        date.click();
    }


    public void clickOnSwapStationButton() {

        swapButton.click();
    }

    public boolean areStationSwapped() {
        fromStation.click();
        String fromStation = stationAfterSwap.getText();
        toStation.click();
        String toStation = stationAfterSwap.getText();
        return fromStation.equals(ConfigReader.getConfigValue("toStation")) && toStation.equals(ConfigReader.getConfigValue("fromStation"));
    }

    public void clickOnTodayButton() {
        todayButton.click();
    }

    public boolean isTodayDateDisplayed() {

        dateInputField.click();

        // Get today's date
        LocalDate today = LocalDate.now();

        // Extract day, month, and year
        int presentDay = today.getDayOfMonth();
        int presentMonth = today.getMonthValue();
        int presentYear = today.getYear();

        String[] listOfMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String presentMonthInWords = listOfMonth[presentMonth - 1];
        String selectedDay = selectedDate.getText();

        return Integer.toString(presentDay).equals(selectedDay) && presentMonthInWords.equals(month.getText()) && Integer.toString(presentYear).equals(year.getText());
    }

    public void clickOnTomorrowButton() {
        tomorrowButton.click();
    }

    public boolean isTomorrowDateDisplayed() {

        dateInputField.click();
        // Get today's date
        LocalDate today = LocalDate.now();

        // Add one day to today's date to get tomorrow's date
        LocalDate tomorrow = today.plusDays(1);

        // Extract day, month and year
        int tomorrowDay = tomorrow.getDayOfMonth();
        int tomorrowMonth = tomorrow.getMonthValue();
        int tomorrowYear = tomorrow.getYear();

        String[] listOfMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String tomorrowMonthInWords = listOfMonth[tomorrowMonth - 1];

        return Integer.toString(tomorrowDay).equals(selectedDate.getText()) && tomorrowMonthInWords.equals(month.getText()) && Integer.toString(tomorrowYear).equals(year.getText());

    }

    public boolean isSearchErrorMessageDisplayed() {
        return isDisplayed(searchErrorMessage);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void userClicksCareerIcon() {
        careerIcon.click();
    }

    public void scrollUntilFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footerText = driver.findElement(By.xpath("//*[@id=\"footer-copyright\"]//div[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);", footerText);
        js.executeScript("arguments[0].click();", footerText);
    }

    public void clickQuickLinks() {
        quickLink.click();
    }

    public void userCancelBooking() {
        cancelBooking.click();
    }

    public void userClicksFAQ() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        faq.click();
    }

    public void userClicksOffersIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        offers.click();
    }

    public void userClicksTrains() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        clickByUsingJS(train);
    }
    public void scrollRSTC() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", busContainerLoading);
        js.executeScript("arguments[0].click();", busContainerLoading);
    }
    public void userClicksRSRTC() {
        RSRTC.click();
    }
}

