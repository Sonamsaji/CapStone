package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterAndSortTest extends BaseTest {

    @Test
    public void validationOfSortByPrice() {
        homePage.openWebsite();
        homePage.isUserOnHomePage();
        homePage.enterFromAndToStation();
        homePage.enterDate();
        homePage.clickOnSearchButton();
        Assert.assertTrue(busSearchResultPage.areSearchResultsCorrect());
        busSearchResultPage.clickOnSortByRatings();
        Assert.assertTrue(busSearchResultPage.areResultsSortedByRatings());
    }

    @Test
    public void validationOfSeatBySeats() {
        homePage.openWebsite();
        homePage.isUserOnHomePage();
        homePage.enterFromAndToStation();
        homePage.enterDate();
        homePage.clickOnSearchButton();
        Assert.assertTrue(busSearchResultPage.areSearchResultsCorrect());
        busSearchResultPage.clickOnSortBySeats();
        Assert.assertTrue(busSearchResultPage.areResultsSortedBySeats());
    }

}
