package com.automation.steps;

import com.automation.pages.mob.TrainsPageMobile;
import com.automation.pages.web.TrainsPageWeb;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TrainsPageSteps {
    TrainsPageWeb trainsPageWeb = new TrainsPageWeb();
    TrainsPageMobile trainsPageMobile = new TrainsPageMobile();

    @Then("verify the user is on the Train Ticket Booking page")
    public void verifyTheUserIsOnTheTrainTicketBookingPage() {
        Assert.assertTrue(trainsPageWeb.verifyUserIsOnTheTrainTicketBookingPage());
    }

    @And("the user clicks the search button")
    public void theUserClicksTheSearchButton() {
        trainsPageWeb.userClicksTheSearchButton();
    }

    @Then("verify search result is displayed")
    public void verifySearchResultIsDisplayed() {
        Assert.assertTrue(trainsPageWeb.filterAndSortIsDisplayed());
    }

    @And("the user clicks on duration filter")
    public void theUserClicksOnDurationFilter() {
        trainsPageWeb.userClicksOnDurationIcon();
    }

    @Then("the filtered list of trains should be displayed correctly")
    public void theFilteredListOfTrainsShouldBeDisplayedCorrectly() {
        // Step 4: Assert that the list is sorted in ascending order
        Assert.assertTrue(trainsPageWeb.isDurationFilterWorking());
    }

    @And("the user applies some filters")
    public void theUserAppliesSomeFilters() {
        trainsPageWeb.userClicksOriginStationFilter();
        trainsPageWeb.userClicksOnDestinationStation();
    }

    @Then("verify the filtered list of trains is displayed")
    public void verifyTheFilteredListOfTrainsIsDisplayed() {
        trainsPageWeb.verifyFilterWorked();
    }

    @And("the user clicks the Reset All button")
    public void theUserClicksTheResetAllButton() {
        trainsPageWeb.clickResetButton();
    }

    @Then("verify all filters are reset")
    public void verifyAllFiltersAreReset() {
        trainsPageWeb.filtersAreReset();
    }
    
    //mobile
    @Then("the user should be on the Train Booking page")
    public void the_user_should_be_on_the_train_booking_page() {
            Assert.assertTrue(trainsPageMobile.isUserOnTrainBookingPage());
    }
    @When("the user enters the source station")
    public void theUserEntersTheSourceStation() {
        trainsPageMobile.userEnterSource();
    }
    @And("the user enters the destination station")
    public void theUserEntersTheDestinationStation() {
        trainsPageMobile.userEnterDestination();
    }
    @When("the user clicks the Search button")
    public void the_user_clicks_the_search_button() {
        trainsPageMobile.userClickSearchButton();
    }
    @Then("the user should be on the Train Results page")
    public void the_user_should_be_on_the_train_results_page() {
        Assert.assertTrue(trainsPageMobile.verifyTrainResults());
    }
    @When("the user clicks the today button")
    public void the_user_clicks_the_today_button() {
        trainsPageMobile.clickToday();
    }
    @Then("verify today's date is showing")
    public void verify_today_s_date_is_showing() {
        trainsPageMobile.verifyTodayDateIsShowing();
    }
    @Then("the user clicks the tomorrow date button")
    public void the_user_clicks_the_tomorrow_date_button() {
        trainsPageMobile.clickTomorrow();
    }
    @Then("verify tomorrow's date is showing")
    public void verify_tomorrow_s_date_is_showing() {
        trainsPageMobile.verifyTomorrow();
    }
    @Then("the user clicks the day after tomorrow date button")
    public void the_user_clicks_the_day_after_tomorrow_date_button() {
        trainsPageMobile.clickDayAfter();
    }
    @Then("verify the day after tomorrow's date is showing")
    public void verify_the_day_after_tomorrow_s_date_is_showing() {
        trainsPageMobile.verifyDayAfter();
    }

}
