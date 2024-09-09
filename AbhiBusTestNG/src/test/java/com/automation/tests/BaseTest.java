package com.automation.tests;

import com.automation.pages.BusSearchResultPage;
import com.automation.pages.CancelBookingPage;
import com.automation.pages.Homepage;
import com.automation.pages.OfferPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    Homepage homePage;
    OfferPage offerPage;
    BusSearchResultPage busSearchResultPage;
    CancelBookingPage cancelBookingPage;

    @BeforeMethod
    public void setUp() {
        DriverManager.createDriver();
        ConfigReader.initConfig();
        homePage = new Homepage();
        offerPage = new OfferPage();
        busSearchResultPage = new BusSearchResultPage();
        cancelBookingPage = new CancelBookingPage();
    }

    @AfterMethod
    public void clearUp() {
        DriverManager.getDriver().quit();
    }
}
