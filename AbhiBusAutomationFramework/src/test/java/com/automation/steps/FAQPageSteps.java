package com.automation.steps;

import com.automation.pages.web.FAQPageWeb;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FAQPageSteps {

    FAQPageWeb faqPage = new FAQPageWeb();

    @Then("verify user lands on FAQ page")
    public void verifyUserLandsOnFAQPage() {
        Assert.assertEquals(faqPage.onFAQPage(), "FAQ");
    }

    @When("the user clicks the keydown symbol for a specific FAQ item")
    public void theUserClicksTheKeydownSymbolForASpecificFAQItem() {
        faqPage.userClicksKeydown();
    }

    @Then("keydown symbol should be in the active or expanded state")
    public void keydownSymbolShouldBeInTheActiveOrExpandedState() {
        Assert.assertTrue(faqPage.isKeyDownWorking().contains("?"));
    }
}
