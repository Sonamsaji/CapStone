package com.automation.pages.mob;

import com.automation.pages.interfaces.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageMobile extends BasePageMobile implements HomePage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Skip\"]\n")
    WebElement skipButton;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.app.abhibus:id/closeImageView\"]\n")
    WebElement closeLogin;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]\n")
    WebElement allowNotification;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Search\"]")
    WebElement searchButton;

    @FindBy(xpath = "//android.widget.HorizontalScrollView[@resource-id=\"com.app.abhibus:id/main_tab_layout\"]/android.widget.LinearLayout/android.widget.LinearLayout[1]")
    WebElement homeNavigationButton;

    //locator for clicking trains icon on navigation bar
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.app.abhibus:id/optionImageView\"])[2]")
    WebElement train;
    //locator for clicking train on mobile
    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.app.abhibus:id/optionImageView\"])[2]")
    WebElement clickTrain;
    //locator for clicking account
    @FindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.app.abhibus:id/tabMenuLottie\"]")
    WebElement account;

    public void openWebsite() {
        skipButton.click();
        closeLogin.click();
//            if(allowNotification.isDisplayed()) {
//                allowNotification.click();
//            }
    }


    public boolean isUserOnHomePage() {
        return isDisplayed(searchButton) && isDisplayed(homeNavigationButton);
    }

    public void enterFromAndToStation() {
    }

    public void enterDate() {
    }

    public void clickOnSwapStationButton() {
    }

    public boolean areStationSwapped() {
        return true;
    }

    public void clickOnTodayButton() {

    }

    public boolean isTodayDateDisplayed() {
        return true;
    }

    public void clickOnTomorrowButton() {

    }

    public boolean isTomorrowDateDisplayed() {
        return true;
    }

    public boolean isSearchErrorMessageDisplayed() {
        return true;
    }

    public void clickOnSearchButton() {
    }

    public void userClicksTrains() {
        train.click();
    }

    public void trainBooking() {
        clickTrain.click();
    }

    public void clickAccount() {
        account.click();
    }
}
