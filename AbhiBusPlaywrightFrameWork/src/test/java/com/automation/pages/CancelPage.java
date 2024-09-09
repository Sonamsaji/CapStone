package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.Locator;

public class CancelPage extends BasePage{

    Locator cancelText;
    Locator ticketNumber;
    Locator phoneNumber;
    Locator retrieveButton;
    Locator errorText;
    Locator chatBot;
    Locator botText;

    public CancelPage(){
        cancelText = page.locator("//div[@class=\"jrnytye\"]//h1");
        ticketNumber = page.locator("#ticket_num");
        phoneNumber = page.locator("#phonenum");
        retrieveButton = page.locator("//*[@id=\"Form1\"]//div[4]/input");
        errorText = page.locator("//*[@id=\"txtCanc\"]/div");
        chatBot = page.locator(".verloop-button");
        botText = page.locator("//*[@id='chat-window-wrapper']/div/div[1]/div[1]/span");
    }
    public Locator userIsOnTheCancelBookingPage() {
        return cancelText;
    }

    public void userEntersAnInvalidData()  {
        ticketNumber.fill("1234567");
        phoneNumber.fill("7894566783");
        retrieveButton.click();
        page.waitForTimeout(3000);
    }

    public Locator isErrorMessageDisplayed() {
        return errorText;
    }

    public void clicksChatBot() {
        while(!chatBot.isVisible()){
            page.reload();
        }
        chatBot.click();
    }

    public Locator isChatBotVisible() {

        /// Switch to the iframe containing the chatbot
        page.frameLocator("iframe#verloop-iframe").locator("//*[@id='chat-window-wrapper']/div/div[1]/div[1]/span").waitFor();
        return botText;
    }


}
