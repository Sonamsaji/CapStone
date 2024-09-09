package com.automation.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FAQPageWeb extends BasePageWeb {

    //locator for
    @FindBy(css = "div.row.collapsible-header > div.col")
    WebElement faqData;
    //locator for FAQ text
    @FindBy(css = "div.row.card-header.lighter > h5\n")
    WebElement faqText;
    //locator for content inside faq
    @FindBy(css = ".collapsible-body")
    WebElement faqContent;
    //locator for whole faq box to load
    @FindBy(className = "faq")
    WebElement faqWait;

    public String onFAQPage() {
        return faqText.getText();
    }

    public void userClicksKeydown() {
        wait.until(ExpectedConditions.elementToBeClickable(faqWait));
        faqData.click();
    }

    public String isKeyDownWorking() {
        return faqContent.getText();
    }
}
