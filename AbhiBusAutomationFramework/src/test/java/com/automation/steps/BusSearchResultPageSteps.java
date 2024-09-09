package com.automation.steps;

import com.automation.pages.interfaces.BusSearchResultPage;
import com.automation.pages.mob.BusSearchResultPageMobile;
import com.automation.pages.web.BusSearchResultPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusSearchResultPageSteps {
    BusSearchResultPage busSearchResultPage;

    public BusSearchResultPageSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            busSearchResultPage = new BusSearchResultPageMobile();
        }else{
             busSearchResultPage = new BusSearchResultPageWeb();
        }
    }

    @Then("verify user is on search result page")
    public void verify_user_is_on_search_result_page() {
        Assert.assertTrue(busSearchResultPage.isUserOnSearchResultPage());
    }

    @Then("verify user is displayed with correct search results")
    public void verifyUserIsDisplayedWithCorrectSearchResults() {
        Assert.assertTrue(busSearchResultPage.areSearchResultsCorrect());
    }

    @When("user clicks on price drop filter")
    public void userClicksOnPriceDropFilter() {
        busSearchResultPage.clickOnPriceDropFilter();
    }

    @Then("verify price drop results are displayed")
    public void verifyPriceDropResultsAreDisplayed() {
        Assert.assertTrue(busSearchResultPage.isPriceDropDisplayed());
    }

    @When("user click on sort by price")
    public void userClickOnSortByPrice() {
        busSearchResultPage.clickOnSortByPrice();
    }

    @Then("verify buses are sorted by price")
    public void verifyBusesAreSortedByPrice() {
        Assert.assertTrue(busSearchResultPage.areResultsSortedByPrice());
    }

    @When("user clicks on sort by seats")
    public void userClicksOnSortBySeats() {
        busSearchResultPage.clickOnSortBySeats();
    }

    @Then("verify buses are sorted by seats")
    public void verifyBusesAreSortedBySeats() {
        Assert.assertTrue(busSearchResultPage.areResultsSortedBySeats());

    }

    @When("user clicks on sort by rating")
    public void userClicksOnSortByRating() {
        busSearchResultPage.clickOnSortByRatings();
    }

    @Then("verify buses are sorted by rating")
    public void verifyBusesAreSortedByRating() {
        Assert.assertTrue(busSearchResultPage.areResultsSortedByRatings());
    }

    @When("user clicks on sort by arrival time")
    public void userClicksOnSortByArrivalTime() {

        busSearchResultPage.clickOnSortByArrivalTime();
        
    }

    @Then("verify buses are sorted by its arrival time")
    public void verifyBusesAreSortedByItsArrivalTime() {
        Assert.assertTrue(busSearchResultPage.areResultsSortedByArrivalTime());
    }

    @When("user clicks on sort by departure time")
    public void userClicksOnSortByDepartureTime() {
        busSearchResultPage.clickOnSortByDepartureTime();
    }

    @Then("verify buses are sorted by its departure time")
    public void verifyBusesAreSortedByItsDepartureTime() {
        Assert.assertTrue(busSearchResultPage.areResultsSortedByDepartureTime());
    }

    @When("user clicks on {string} filter")
    public void userClicksOnFilter(String busType) {
       busSearchResultPage.clickOnBusTypeFilter(busType);
    }

    @Then("verify {string} results are displayed")
    public void verifyResultsAreDisplayed(String busType) {
        Assert.assertTrue(busSearchResultPage.isBusTypeDisplayed(busType));
    }

}
