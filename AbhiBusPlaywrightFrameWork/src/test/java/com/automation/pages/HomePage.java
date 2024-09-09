package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.Locator;

public class HomePage extends BasePage {

    Locator searchTitle;
    Locator searchButton;
    Locator offers;
    Locator quickLink;
    Locator cancelBooking;

    public HomePage() {
        searchTitle = page.locator("//h1[@class='search-page-title']");
        searchButton = page.locator("#search-button");
        offers = page.locator("#offers-link");
        quickLink = page.locator("//button[text()=\"Quick Links\"]");
        cancelBooking = page.locator("//*[@id=\"footer-routes\"]//div[5]/a");
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
}
