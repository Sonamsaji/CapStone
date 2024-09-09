package com.automation.pages.interfaces;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public interface BusSearchResultPage {

      boolean isUserOnSearchResultPage();

      boolean areSearchResultsCorrect();

      void clickOnSortByPrice()  ;

      boolean areResultsSortedByPrice()  ;

      void clickOnSortBySeats();

      boolean areResultsSortedBySeats();

      void clickOnSortByRatings()  ;

      boolean areResultsSortedByRatings() ;

      void clickOnSortByArrivalTime();

      boolean areResultsSortedByArrivalTime()  ;

      void clickOnSortByDepartureTime();

      boolean areResultsSortedByDepartureTime() ;

      void clickOnPriceDropFilter() ;

      boolean isPriceDropDisplayed();

      void clickOnBusTypeFilter(String busType);

      boolean isBusTypeDisplayed(String busType);

}
