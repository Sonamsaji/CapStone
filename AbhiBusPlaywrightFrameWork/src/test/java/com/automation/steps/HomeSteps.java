package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens website")
    public void user_opens_website() {
        homePage.openWebsite();
    }
    @Then("verify user lands on website")
    public void verify_user_lands_on_website() {
        assertThat(homePage.isUserOnHomePage());
    }

    @When("the user clicks on Offers from the navigation menu")
    public void the_user_clicks_on_offers_from_the_navigation_menu() {
        homePage.userClicksOffersIcon();
    }
    @When("the user clicks on the Quick Links icon in the footer")
    public void the_user_clicks_on_the_quick_links_icon_in_the_footer() {
        homePage.clickQuickLinks();
    }
    @When("the user clicks on the Cancel Booking option")
    public void the_user_clicks_on_the_cancel_booking_option() {
        homePage.userCancelBooking();
    }


}
