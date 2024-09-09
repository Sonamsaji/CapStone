package com.automation.steps;

import com.automation.pages.mob.AccountPageMobile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountSteps {

    AccountPageMobile accountPage = new AccountPageMobile();

    @Given("click on cancel Booking option")
    public void click_on_cancel_booking_option() {
        accountPage.clickCancel();
    }
    @When("the user clicks on the feedback icon")
    public void the_user_clicks_on_the_feedback_icon() {
       accountPage.clickFeedBack();
    }


}
