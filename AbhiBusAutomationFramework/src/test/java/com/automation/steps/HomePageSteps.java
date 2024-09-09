package com.automation.steps;

import com.automation.pages.interfaces.HomePage;
import com.automation.pages.mob.HomePageMobile;
import com.automation.pages.web.CareerPageWeb;
import com.automation.pages.web.HomePageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageSteps {
     HomePage homePage;
     HomePageWeb homePageWeb = new HomePageWeb();
     HomePageMobile homePageMobile = new HomePageMobile();
     CareerPageWeb careerPageWeb=new CareerPageWeb();

    public HomePageSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            homePage = new HomePageMobile();
        }else{
            homePage = new HomePageWeb();
        }
    }

    @Given("user opens website")
    public void user_opens_website() {
        homePage.openWebsite();
    }

    @Then("verify user lands on website")
    public void verify_user_lands_on_website() {
        Assert.assertTrue(homePage.isUserOnHomePage());
    }

    @When("user enters from and to station")
    public void userEntersFromAndToStation() {
        homePage.enterFromAndToStation();
    }

    @When("user set date")
    public void user_set_date() {
        homePage.enterDate();
    }

    @When("click on search button")
    public void click_on_search_button() {
        homePage.clickOnSearchButton();

    }

    @And("user clicks on swap button")
    public void userClicksOnSwapButton() {
        homePage.clickOnSwapStationButton();
    }

    @Then("verify the to and from station places are swapped")
    public void verifyTheToAndFromStationPlacesAreSwapped() {
        Assert.assertTrue(homePage.areStationSwapped());

    }

    @When("user clicks on today")
    public void userClicksOnToday() {
        homePage.clickOnTodayButton();
    }

    @Then("verify todays date is displayed")
    public void verifyTodaysDateIsDisplayed() {
        Assert.assertTrue(homePage.isTodayDateDisplayed());
    }

    @When("user clicks on tomorrow")
    public void userClicksOnTomorrow() {
        homePage.clickOnTomorrowButton();
    }

    @Then("verify tomorrows date is displayed")
    public void verifyTomorrowsDateIsDisplayed() {

        Assert.assertTrue(homePage.isTomorrowDateDisplayed());

    }

    @Then("verify user is displayed with error message for not entering station")
    public void verifyUserIsDisplayedWithErrorMessageForNotEnteringStation() {
        Assert.assertTrue(homePage.isSearchErrorMessageDisplayed());
    }


    @When("user clicks on the Careers icon in the footer")
    public void userClicksOnTheCareersIconInTheFooter() {
        homePageWeb.scrollUntilFooter();
        homePageWeb.userClicksCareerIcon();
    }

    @When("the user clicks on the Quick Links icon in the footer")
    public void theUserClicksOnTheQuickLinksIconInTheFooter() {
        homePageWeb.scrollUntilFooter();
        homePageWeb.clickQuickLinks();

    }

    @And("the user clicks on the Cancel Booking option")
    public void theUserClicksOnTheCancelBookingOption() {
        homePageWeb.userCancelBooking();
    }

    @When("the user clicks on the FAQ icon in the footer")
    public void theUserClicksOnTheFAQIconInTheFooter() {
        homePageWeb.scrollUntilFooter();
        homePageWeb.userClicksFAQ();
    }

    @When("the user clicks on Offers from the navigation menu")
    public void theUserClicksOnOffersFromTheNavigationMenu() {
        homePageWeb.userClicksOffersIcon();
    }
    @When("the user clicks on Trains from the navigation menu")
    public void theUserClicksOnTrainsFromTheNavigationMenu() {
        homePage.userClicksTrains();
    }
    @When("the user clicks on the RSRTC icon")
    public void the_user_clicks_on_the_rsrtc_icon() {
        homePageWeb.scrollRSTC();
        homePageWeb.userClicksRSRTC();
        careerPageWeb.userSwitchToJobDescriptionPage();
    }

//    @Given("user is on homepage of AbhiBus")
//    public void userIsOnHomepageOfAbhiBus() {
//
//    }
    @When("the user clicks on the Train Booking option")
    public void the_user_clicks_on_the_train_booking_option() {
        homePageMobile.trainBooking();
    }
    @Given("user clicks on account button")
    public void user_clicks_on_account_button() {
        homePageMobile.clickAccount();
    }

}
