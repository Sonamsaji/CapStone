package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterFunctionalityTest extends BaseTest {

    @Test
    public void validateCancelTicketWithInvalidData() throws InterruptedException {
        homePage.openWebsite();
        homePage.isUserOnHomePage();
        homePage.clickQuickLinks();
        homePage.userCancelBooking();
        Assert.assertEquals(cancelBookingPage.userIsOnTheCancelBookingPage(), ConfigReader.getConfigProperty("cancel"));
        cancelBookingPage.userEntersAnInvalidData();
        Assert.assertEquals(cancelBookingPage.isErrorMessageDisplayed(), ConfigReader.getConfigProperty("error"));
    }

    @Test
    public void validateChatbotFunctionalityOnTheCancelBookingPage() throws InterruptedException {
        homePage.openWebsite();
        homePage.isUserOnHomePage();
        homePage.clickQuickLinks();
        homePage.userCancelBooking();
        Assert.assertEquals(cancelBookingPage.userIsOnTheCancelBookingPage(), ConfigReader.getConfigProperty("cancel"));
        cancelBookingPage.userEntersAnInvalidData();
        Assert.assertEquals(cancelBookingPage.isErrorMessageDisplayed(), ConfigReader.getConfigProperty("error"));
        cancelBookingPage.clicksChatBot();
        Assert.assertEquals(cancelBookingPage.isChatBotVisible(), ConfigReader.getConfigProperty("chatterbox"));
    }
}
