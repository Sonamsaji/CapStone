package com.automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingPageWeb extends BasePageWeb {
    //locator for RSRTC text
    @FindBy(xpath = "//ul[@class='breadcrumb']//li[text()='RSRTC']")
    WebElement rsrtcText;
    //locator for loading container
    @FindBy(className = "c-cont")
    WebElement containerLoading;
    //locator for clicking selecting date
    @FindBy(id = "bookdatepicker0")
    WebElement selectDate;
    //locator for selecting date
    @FindBy(xpath = "//td[@data-handler='selectDay' and @data-month='9' and @data-year='2024']/a[text()='23']")
    WebElement clickDate;
    //locator for getting date on seat selecting page
    @FindBy(xpath = "//div[@id='scroll-element']/a[8]/span[2]")
    WebElement clickDateText;
    //locator for
    @FindBy(css = "a.btn.date.filled.primary.md.inactive.button span:nth-child(2)")
    WebElement actualDateText;
    //locator for
    @FindBy(id = "service-cards-container")
    WebElement cartLoading;
    //locator for clicking showSeat button
    @FindBy(xpath = "(//div[@class='row ']//button)[1]")
    WebElement showSeats ;
    //locator for clicking hideSeat button
    @FindBy(css = "button.btn.bus-info-btn.filled.primary.sm.inactive.button")
    WebElement hideSeats ;
    //locator for getting seat container
    @FindBy(id = "seating-container")
    WebElement  seatContainer;
    //locator for selecting a seat
    @FindBy(xpath = "//div[@class='container  ']//table//td[2]")
    WebElement  seat;
    // Locator for the SVG seat button
    @FindBy(xpath = "//svg")
    private WebElement seatSvg;
    //locator for clicking checkbox before continue button
    @FindBy(xpath = "//div[@id='place-select-container']//p")
    WebElement checkBox;
    //locator for clicking continue button
    @FindBy(xpath = "//div[text()='Continue']")
    WebElement continueButton;
    //locator for clicking skip button
    @FindBy(xpath = "//a[text()='Skip']")
    WebElement skip;
    //locator for entering name in name text field
    @FindBy(xpath = "//div[@id='passenger-detail-name']//input")
    WebElement name;
    //locator for entering age in age text box
    @FindBy(xpath = "//div[@id='passenger-detail-age']//input")
    WebElement age;
    //locator for entering mobile number
    @FindBy(xpath = "//div[@id='passenger-details-mob-input']//input")
    WebElement mobileNumber;
    //locator for entering email
    @FindBy(xpath = "//div[@id='passenger-details-email']//input")
    WebElement email;
    //locator for clicking continue to pay button
    @FindBy(xpath = "//div[@class='container card   md ']//button")
    WebElement payButton;
    //locator for verifying user is on payment page
    @FindBy(xpath = "//div[@id='payment-card-title']//h5")
    WebElement paymentText;
    public boolean isUserOnRSRTCPage() {
        return isDisplayed(rsrtcText);
    }

    public void clicksOnDateOption() {
        wait.until(ExpectedConditions.elementToBeClickable(containerLoading));
        selectDate.click();
    }

    public void selectDate() {
        clickDate.click();
    }

//    public boolean verifyDate() {
//        wait.until(ExpectedConditions.visibilityOf(cartLoading));
//        String clickedDate = clickDateText.getText().trim();
//        wait.until(ExpectedConditions.textToBePresentInElement(actualDateText, clickedDate));
//
//        String fullText = actualDateText.getText().trim(); // Ensure there's no extra whitespace
//        String actualDate = fullText.split(" ")[0]; // Extract the date part
//
//        System.out.println("Clicked Date: " + clickedDate);
//        System.out.println("Actual Date: " + actualDate);
//
//        return clickedDate.contains(actualDate);
//    }


    public void clicksShowSeats() {
        showSeats.click();
    }

    public boolean verifySeatDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(seatContainer));
        return isDisplayed(seatContainer);
    }
    public boolean verifySeatNotDisplayed() {
        return isDisplayed(seatContainer);
    }


    public void clickHideSeats() {
        hideSeats.click();
    }

    public void selectSeat() {

        WebElement svgRect = seat.findElement(By.cssSelector("svg rect"));
        String fillColor = svgRect.getAttribute("fill");

        // Check if the seat is available (white) or already selected (green)
        if ("white".equals(fillColor)) {
            seat.click();
            System.out.println("Seat selected successfully.");
        } else if ("#D8F2E2".equals(fillColor)) {
            System.out.println("Error: Seat is already selected by someone else.");
        } else {
            System.out.println("Unknown seat status.");
        }
    }

    public void clickContinueButton() {
        checkBox.click();
        continueButton.click();
    }

    public void userFillDetails() {
        name.sendKeys("test");
        age.sendKeys("25");
        mobileNumber.sendKeys("7994567898");
        email.sendKeys("test@test.com");
    }

    public void clickPayButton() {
        payButton.click();
    }

    public boolean verifyPaymentPage() {
        return isDisplayed(paymentText);
    }

    public void clickSkipButton() {
        skip.click();
    }
}
