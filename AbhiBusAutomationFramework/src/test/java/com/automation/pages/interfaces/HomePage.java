package com.automation.pages.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public interface HomePage {

    void openWebsite();

    boolean isUserOnHomePage();

    void enterFromAndToStation();

    void enterDate();

    void clickOnSwapStationButton();

    boolean areStationSwapped();

    void clickOnTodayButton();

    boolean isTodayDateDisplayed();

    void clickOnTomorrowButton();

    boolean isTomorrowDateDisplayed();

    boolean isSearchErrorMessageDisplayed();

    void clickOnSearchButton();

    void userClicksTrains();
}
