package com.automation.pages.mob;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedBackPage extends BasePageMobile{

    //locator for writing Name in name text field
    @FindBy(xpath = "")
    WebElement nameField;
    //locator for entering invalid email
    @FindBy(xpath = "")
    WebElement emailField;
    //locator for getting error for email
    @FindBy(xpath = "")
    WebElement emailErrorText;
    //locator for entering invalid mobile number
    @FindBy(xpath = "")
    WebElement numberField;
    //locator for getting error for number
    @FindBy(xpath = "")
    WebElement numberErrorText;

    //locator for clicking submit button
    @FindBy(xpath = "")
    WebElement submitBtn;

    public boolean verifyUserIsOnFeedBackPage() {
        return submitBtn.isDisplayed();
    }

    public void userEnterValidName() {
        nameField.sendKeys("");
    }

    public void userEnterInValidEmail() {
        emailField.sendKeys("");
    }

    public void userClicksSubmitButton() {
        submitBtn.click();
    }

    public boolean verifyUserIsGettingErrorMessageForInvalidEmail() {
        return emailErrorText.isDisplayed();
    }

    public void userEnterInvalidMobileNumber() {
        numberField.sendKeys("");
    }

    public boolean verifyUserIsGettingErrorMessageForInvalidMobile() {
        return numberErrorText.isDisplayed();
    }
}
