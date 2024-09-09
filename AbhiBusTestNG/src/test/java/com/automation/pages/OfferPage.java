package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OfferPage extends BasePage {

    //locator for clicking first view details option
    @FindBy(xpath = "//a[contains(@class, 'btn') and contains(@class, 'filled') and contains(@class, 'primary') and contains(@class, 'sm') and contains(@class, 'inactive')]/span[text()='View Details']")
    WebElement viewDetails;
    //locator for clicking copy code
    @FindBy(css = "button.btn.filled.primary.md.inactive.button[data-code='ABHIFIRST']")
    WebElement copyCode;
    //locator for getting code copied message
    @FindBy(xpath = "//div[@class='row text-success']")
    WebElement codeCopiedMessage;
    //locator for loading whole container
    @FindBy(id = "search-container")
    WebElement loadPage;

    public void clicksViewDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(loadPage));
        viewDetails.click();
    }

    public void clicksCopyCode() {
        copyCode.click();
    }

    public boolean isCodeCopied() {
        return isDisplayed(codeCopiedMessage);
    }
}
