package com.automation.pages.mob;

import com.automation.pages.interfaces.BusSearchResultPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BusSearchResultPageMobile extends BasePageMobile implements BusSearchResultPage {

    public boolean isUserOnSearchResultPage() {
        return true;
    }

    public boolean areSearchResultsCorrect() {
        return true;
    }


    public void clickOnSortByPrice() {
    }

    public boolean areResultsSortedByPrice() {
        return true;
    }

    public void clickOnSortBySeats() {
    }

    public boolean areResultsSortedBySeats() {
         return true;
    }

    public void clickOnSortByRatings() {
    }

    public boolean areResultsSortedByRatings() {
        return true;
    }

    public void clickOnSortByArrivalTime() {
    }

    public boolean areResultsSortedByArrivalTime() {
        return true;
    }

    public void clickOnSortByDepartureTime() {
    }

    public boolean areResultsSortedByDepartureTime() {
        return true;
    }

    public void clickOnPriceDropFilter() {
    }

    public boolean isPriceDropDisplayed() {
        return true;
    }

    public void clickOnBusTypeFilter(String busType) {
    }

    public boolean isBusTypeDisplayed(String busType) {
        return true;
    }

}
