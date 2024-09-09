package com.automation.steps;

import com.automation.pages.CancelPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CancelSteps {
    CancelPage cancelPage = new CancelPage();

    @Then("verify the user is on the Cancel Booking page")
    public void verify_the_user_is_on_the_cancel_booking_page() {
        cancelPage.userIsOnTheCancelBookingPage().isVisible();
    }

    @Then("the user enters an invalid {string} and {string}")
    public void the_user_enters_an_invalid_and(String arg0, String arg1) {
        cancelPage.userEntersAnInvalidData();
    }

    @Then("verify an appropriate error message is displayed to the user")
    public void verify_an_appropriate_error_message_is_displayed_to_the_user() {
        cancelPage.isErrorMessageDisplayed().isVisible();
    }
    @When("the user clicks the chatbot icon")
    public void theUserClicksTheChatbotIcon() throws InterruptedException {
        cancelPage.clicksChatBot();
    }

    @Then("verify the chatbot box loads successfully")
    public void verifyTheChatbotBoxLoadsSuccessfully() {
        cancelPage.isChatBotVisible().isVisible();
    }
}
