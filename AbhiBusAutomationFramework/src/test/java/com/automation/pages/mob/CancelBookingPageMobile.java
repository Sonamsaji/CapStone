package com.automation.pages.mob;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CancelBookingPageMobile extends BasePageMobile{
    //locator for getting booking page text
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.app.abhibus:id/cancelTicketTextView\"]")
    WebElement ticketText;
    //locator for entering bookingID
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.app.abhibus:id/abhibusTicketEditText\"]")
    WebElement bookingIdTextArea;
    //locator for entering mobile  number
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.app.abhibus:id/cancelMobileEditText\"]")
    WebElement mobileNumberTextArea;
    //locator for clicking submit button
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.app.abhibus:id/searchButton\"]")
    WebElement submitBtn;
    //locator for clicking submit button
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
    WebElement errorText;


    public boolean verifyUserIsOnCancelBookingPage() {
        return ticketText.isDisplayed();
    }

    public void userEnterDetails() {
        bookingIdTextArea.sendKeys(ConfigReader.getConfigValue("ticketNumber"));
        mobileNumberTextArea.sendKeys(ConfigReader.getConfigValue("phoneNumber"));
        submitBtn.click();
    }

    public boolean errorTextDisplaying() {
        return errorText.isDisplayed();
    }
}
