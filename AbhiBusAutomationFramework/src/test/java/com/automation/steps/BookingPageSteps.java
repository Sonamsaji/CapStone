package com.automation.steps;

import com.automation.pages.web.BookingPageWeb;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BookingPageSteps {

    BookingPageWeb bookingPage = new BookingPageWeb();

    @Then("verify the user is on the RSRTC page")
    public void verify_the_user_is_on_the_rsrtc_page() {
        Assert.assertTrue(bookingPage.isUserOnRSRTCPage());
    }

    @When("the user clicks on the select date option and selects a date")
    public void the_user_clicks_on_the_select_date_option_and_selects_a_date() {
        bookingPage.clicksOnDateOption();
        bookingPage.selectDate();
    }
//    @Then("verify the user is getting results for the selected date")
//    public void verify_the_user_is_getting_results_for_the_selected_date() {
//        Assert.assertTrue(bookingPage.verifyDate());
//    }
    @When("the user clicks on the Show Seats option")
    public void theUserClicksOnTheShowSeatsOption() {
        bookingPage.clicksShowSeats();
    }

    @Then("verify the seats are displayed")
    public void verify_the_seats_are_displayed() {
        Assert.assertTrue(bookingPage.verifySeatDisplayed());
    }
    @When("the user clicks on Hide Seats")
    public void the_user_clicks_on_hide_seats() {
        bookingPage.clickHideSeats();
    }
    @Then("verify the seats are hidden")
    public void verify_the_seats_are_hidden() {
        Assert.assertFalse(bookingPage.verifySeatNotDisplayed());
//        bookingPage.verifySeatIsHidden();
    }

    @Then("the user selects a seat and check whether the seat is booked or not")
    public void theUserSelectsASeatAndCheckWhetherTheSeatIsBookedOrNot() {
        bookingPage.selectSeat();
    }
    @When("the user selects a seat and clicks the continue button")
    public void the_user_selects_a_seat_and_clicks_the_continue_button() {
        bookingPage.selectSeat();
        bookingPage.clickContinueButton();
        bookingPage.clickSkipButton();
    }
    @When("fills in the trip details and billing address")
    public void fills_in_the_trip_details_and_billing_address() {
        bookingPage.userFillDetails();
    }
    @When("clicks on the continue to pay button")
    public void clicks_on_the_continue_to_pay_button() {
        bookingPage.clickPayButton();
    }
    @Then("verify the payment page is loading")
    public void verify_the_payment_page_is_loading() {
        Assert.assertTrue(bookingPage.verifyPaymentPage());
    }



}
