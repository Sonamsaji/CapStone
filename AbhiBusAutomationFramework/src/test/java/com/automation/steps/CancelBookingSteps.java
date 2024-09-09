package com.automation.steps;

import com.automation.pages.mob.CancelBookingPageMobile;
import com.automation.pages.web.CancelBookingPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CancelBookingSteps {

    CancelBookingPageWeb cancelBookingPage = new CancelBookingPageWeb();
    CancelBookingPageMobile cancelBookingPageMobile = new CancelBookingPageMobile();

    @Then("verify the user is on the Cancel Booking page")
    public void verifyTheUserIsOnTheCancelBookingPage() {
        Assert.assertEquals(cancelBookingPage.userIsOnTheCancelBookingPage(), ConfigReader.getConfigValue("cancel"));
    }

    @And("the user enters an invalid {string} and {string}")
    public void theUserEntersAnInvalidAnd(String arg0, String arg1) throws InterruptedException {
        cancelBookingPage.userEntersAnInvalidData();
    }

    @Then("verify an appropriate error message is displayed to the user")
    public void verifyAnAppropriateErrorMessageIsDisplayedToTheUser() {
        Assert.assertEquals(cancelBookingPage.isErrorMessageDisplayed(), ConfigReader.getConfigValue("error"));
    }

    @When("the user clicks the chatbot icon")
    public void theUserClicksTheChatbotIcon() throws InterruptedException {
        cancelBookingPage.clicksChatBot();
    }

    @Then("verify the chatbot box loads successfully")
    public void verifyTheChatbotBoxLoadsSuccessfully() {
        Assert.assertEquals(cancelBookingPage.isChatBotVisible(), ConfigReader.getConfigValue("chatterbox"));
    }

    @Then("verify the user is on Cancel Booking page")
    public void verifyTheUserIsOnCancelBookingPage() {
        Assert.assertTrue(cancelBookingPageMobile.verifyUserIsOnCancelBookingPage());
    }

    @And("user enters an invalid {string} and {string}")
    public void userEntersAnInvalidAnd(String arg0, String arg1) {
        cancelBookingPageMobile.userEnterDetails();
    }

    @Then("verify an appropriate error message is displayed")
    public void verifyAnAppropriateErrorMessageIsDisplayed() {
        Assert.assertTrue(cancelBookingPageMobile.errorTextDisplaying());
    }
}
