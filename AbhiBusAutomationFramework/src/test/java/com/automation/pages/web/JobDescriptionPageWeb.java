package com.automation.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobDescriptionPageWeb extends BasePageWeb {
    //locator for interested button
    @FindBy(id = "st-apply")
    WebElement interestedButton;
    //locator for filling firstName
    @FindBy(id = "first-name-input")
    WebElement firstName;
    //locator for lastName
    @FindBy(id = "last-name-input")
    WebElement lastName;
    //locator for email
    @FindBy(id = "email-input")
    WebElement email;
    //locator for confirmEmail
    @FindBy(id = "confirm-email-input")
    WebElement confirmEmail;
    //locator for next Button
    @FindBy(xpath = "//footer//button")
    WebElement nextButton;
    //locator for Notice Period
    @FindBy(id = "question_36d9a028-ee09-41e2-a458-3164bfff7f3b")
    WebElement noticePeriod;
    //locator for checkbox
    @FindBy(id = "noPolicy")
    WebElement checkbox;
    //locator for submit Button
    @FindBy(xpath = "//button[@data-test=\"footer-submit\"]")
    WebElement submit;
    //locator for successful message
    @FindBy(xpath = "//h2")
    WebElement successfulText;

    public void clickIMInterestedButton() {
        interestedButton.click();
    }

    public void userFillsDetails() {
        firstName.sendKeys("So");
        lastName.sendKeys("na");
        email.sendKeys("so@na3.com");
        confirmEmail.sendKeys("so@na3.com");
//        nextButton.click();
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void userFillsNoticePeriodDetails() {
        noticePeriod.sendKeys("1");
        checkbox.click();
        submit.click();
    }

    public String applicationSubmittedSuccessful() {
        return successfulText.getText();
    }
}

