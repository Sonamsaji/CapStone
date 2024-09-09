package com.automation.steps;

import com.automation.pages.OfferPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OfferSteps {

    OfferPage offerPage = new OfferPage();

    @When("the user clicks View Details button")
    public void the_user_clicks_view_details_button() {
        offerPage.clicksViewDetails();
    }

    @When("clicks the Copy Code icon")
    public void clicks_the_copy_code_icon() {
        offerPage.clicksCopyCode();
    }

    @Then("verify the message is displayed")
    public void verify_the_message_is_displayed() {
        assertThat(offerPage.isCodeCopied()).isVisible();
    }
}
