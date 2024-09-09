package com.automation.steps;

import com.automation.pages.mob.FeedBackPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FeedBackSteps {

    FeedBackPage feedBackPage = new FeedBackPage();

    @Then("the user is navigated to the feedback page")
    public void the_user_is_navigated_to_the_feedback_page() {
        Assert.assertTrue(feedBackPage.verifyUserIsOnFeedBackPage());
    }

    @When("the user enters a valid name")
    public void the_user_enters_a_valid_name() {
        feedBackPage.userEnterValidName();
    }

    @When("the user enters an invalid email address")
    public void the_user_enters_an_invalid_email_address() {
        feedBackPage.userEnterInValidEmail();
    }

    @When("clicks the submit button")
    public void clicks_the_submit_button() {
        feedBackPage.userClicksSubmitButton();
    }

    @Then("verify that an error message is displayed for the invalid email")
    public void verify_that_an_error_message_is_displayed_for_the_invalid_email() {
        Assert.assertTrue(feedBackPage.verifyUserIsGettingErrorMessageForInvalidEmail());
    }

    @And("the user enters an invalid mobile number")
    public void theUserEntersAnInvalidMobileNumber() {
        feedBackPage.userEnterInvalidMobileNumber();
    }

    @Then("verify that an error message is displayed for the invalid mobile number")
    public void verifyThatAnErrorMessageIsDisplayedForTheInvalidMobileNumber() {
        Assert.assertTrue(feedBackPage.verifyUserIsGettingErrorMessageForInvalidMobile());
    }
}
