package com.automation.steps;

import com.automation.pages.web.OfferPageWeb;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OfferPageSteps {
    OfferPageWeb offerPage = new OfferPageWeb();

    @And("the user clicks View Details button")
    public void theUserClicksViewDetailsButton() {
        offerPage.clicksViewDetails();
    }

    @And("clicks the Copy Code icon")
    public void clicksTheCopyCodeIcon() {
        offerPage.clicksCopyCode();
    }

    @Then("verify the message is displayed")
    public void verifyTheMessageIsDisplayed() {
        offerPage.isCodeCopied();
    }
}
