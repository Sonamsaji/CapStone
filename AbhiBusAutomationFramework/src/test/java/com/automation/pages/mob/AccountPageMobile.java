package com.automation.pages.mob;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageMobile extends BasePageMobile{

    //locator for clicking Cancel Booking
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.app.abhibus:id/nav_cancelticket\"]")
    WebElement clickCancel;
    //locator for clicking FeedBack
    @FindBy(xpath = "")
    WebElement feedBack;

    public void clickCancel(){
        clickCancel.click();
    }

    public void clickFeedBack() {

    }
}
