package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CancelBookingPage extends BasePage {

    //locator for getting cancel Ticket Text
    @FindBy(xpath = "//div[@class=\"jrnytye\"]//h1")
    WebElement cancelText;

    //locator for entering ticket number
    @FindBy(id = "ticket_num")
    WebElement ticketNumber;

    //locator for entering phone number
    @FindBy(id = "phonenum")
    WebElement phoneNumber;

    //locator for clicking retrieve button
    @FindBy(xpath = "//*[@id=\"Form1\"]//div[4]/input")
    WebElement retrieveButton;

    //locator for getting error text
    @FindBy(xpath = "//*[@id=\"txtCanc\"]/div")
    WebElement errorText;

    //locator for loading chatbot box
    @FindBy(className = "verloop-button")
    WebElement chatBot;

    //locator for getting chatbot box text
    @FindBy(xpath = "//*[@id='chat-window-wrapper']/div/div[1]/div[1]/span")
    WebElement botText;

    public String userIsOnTheCancelBookingPage() {
        return cancelText.getText();
    }

    public void userEntersAnInvalidData() throws InterruptedException {
        ticketNumber.sendKeys(ConfigReader.getConfigProperty("ticketNumber"));
        phoneNumber.sendKeys(ConfigReader.getConfigProperty("phoneNumber"));
        retrieveButton.click();
        Thread.sleep(3000);
    }

    public String isErrorMessageDisplayed() {
        return errorText.getText();
    }

    public void clicksChatBot() {
        while (!chatBot.isDisplayed()) {
            driver.navigate().refresh();
        }
        chatBot.click();
    }

    public String isChatBotVisible() {

        // Switch to the iframe using its XPath
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='verloop-iframe']")));
        wait.until(ExpectedConditions.elementToBeClickable(botText));
        return botText.getText();
    }
}
