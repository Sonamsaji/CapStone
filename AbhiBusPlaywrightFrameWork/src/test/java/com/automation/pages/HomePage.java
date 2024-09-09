package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.Locator;

public class HomePage extends BasePage {

    Locator searchTitle;
    Locator searchButton;
    Locator offers;
    Locator quickLink;
    Locator cancelBooking;
    Locator fromStation;
    Locator toStation;
    Locator dateInputField;
    Locator month;
    Locator forwardChangeOfMonth;
    Locator swapButton;
    Locator stationAfterSwap;

    public HomePage() {
        searchTitle = page.locator("//h1[@class='search-page-title']");
        searchButton = page.locator("#search-button");
        offers = page.locator("#offers-link");
        quickLink = page.locator("//button[text()=\"Quick Links\"]");
        cancelBooking = page.locator("//*[@id=\"footer-routes\"]//div[5]/a");
        fromStation = page.getByPlaceholder("From Station");
        toStation = page.getByPlaceholder("To Station");
        dateInputField = page.getByPlaceholder("Onward Journey Date");
        month = page.locator("//div[2]/div[1]/div[2]/span[1]");
        forwardChangeOfMonth = page.locator("//div[@class=' col auto'][2]/span[@class='calender-month-change']");
        swapButton = page.locator("#bi-direction");
        stationAfterSwap = page.locator("//li[1]/div/div[2]/div/div[1]");
    }

    public void openWebsite() {
        page.navigate(ConfigReader.getConfigValue("application.url"));
    }

    public Locator isUserOnHomePage() {
        return searchButton;
    }

    public void userClicksOffersIcon() {
        searchButton.waitFor();
        offers.click();
    }

    public void clickQuickLinks() {
        quickLink.click();
    }


    public void userCancelBooking() {
        cancelBooking.click();
    }

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

    public void userEntersToAndFromStation() {
        fromStation.click();
        String fromCity = "//div[text()='" + ConfigReader.getConfigValue("fromStation") + "']";
        page.locator(fromCity).click();
        toStation.click();
        String toCity = "//div[text()='" + ConfigReader.getConfigValue("toStation") + "']";
        page.locator(toCity).click();
    }

    public void userSetDate() {
        dateInputField.click();
        while (!month.textContent().equals(ConfigReader.getConfigValue("month") + " ")) {
            //System.out.println(month.textContent()+ConfigReader.getConfigValue("month"));
            forwardChangeOfMonth.click();
        }

        String dateXpath = "//div[2]/span[@data-date='" + ConfigReader.getConfigValue("day") + "' and @data-month='" + monthNumber() + "']";
        Locator date = page.locator(dateXpath);
        date.click();
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnSwapStationButton() {

        swapButton.click();
    }

    public boolean areStationSwapped() {
        fromStation.click();
        String fromStation = stationAfterSwap.textContent();
        toStation.click();
        String toStation = stationAfterSwap.textContent();
        return fromStation.equals(ConfigReader.getConfigValue("toStation")) && toStation.equals(ConfigReader.getConfigValue("fromStation"));
    }

    public Locator toStationInput() {
        return toStation;
    }

    public Locator fromStationInput() {
        return fromStation;
    }

}
