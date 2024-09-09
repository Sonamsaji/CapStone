package com.automation.tests;

import org.testng.annotations.Test;

public class NavigationFunctionalityTest extends BaseTest {

    @Test
    public void applyDiscountOfferOnBusTicketBooking() {
        homePage.openWebsite();
        homePage.isUserOnHomePage();
        homePage.userClicksOffersIcon();
        offerPage.clicksViewDetails();
        offerPage.clicksCopyCode();
        offerPage.isCodeCopied();
    }

}
