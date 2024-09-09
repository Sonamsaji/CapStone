package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.Locator;

public class OfferPage extends BasePage {
    Locator viewDetails;
    Locator copyCode;
    Locator codeCopiedMessage;

    public OfferPage() {
        viewDetails = page.locator("(//div[@class=' col auto']//a)[2]");
        copyCode = page.locator("//button[normalize-space(text())='Copy Code']");
        codeCopiedMessage = page.locator("//div[@class='row text-success']");
    }

    public void clicksViewDetails() {
        page.locator("#search-container").waitFor();
        viewDetails.click();
    }

    public void clicksCopyCode() {
        copyCode.click();
    }

    public Locator isCodeCopied() {
        return codeCopiedMessage;
    }
}
