package com.automation.steps;

import com.automation.pages.BusSearchResultPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BusSearchResultSteps {

    BusSearchResultPage busSearchResultPage = new BusSearchResultPage();

    @Then("verify user is on search result page")
    public void verify_user_is_on_search_result_page() {
        assertThat(busSearchResultPage.filterTitle()).isVisible();
    }

    @When("user click on sort by price")
    public void userClickOnSortByPrice() {
        busSearchResultPage.clickOnSortByPrice();
    }

    @Then("verify buses are sorted by price")
    public void verifyBusesAreSortedByPrice() {
        Assert.assertTrue(busSearchResultPage.areResultsSortedByPrice());
    }

}
