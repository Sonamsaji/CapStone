package com.automation.pages.web;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.IntStream;

public class TrainsPageWeb extends BasePageWeb {

    //locator for getting Train page text for verification
    @FindBy(xpath = "//div[@class=\"banner-text-container\"]//h1")
    WebElement trainText;

    //locator for clicking search button
    @FindBy(xpath = "//span[@class=\"MuiButton-label\"]")
    WebElement search;

    //locator for getting filter text
    @FindBy(xpath = "//div[@class=\"train-filter\"]//div[@class=\"filter\"]")
    WebElement filter;

    //locator for clicking duration filter icon
    @FindBy(xpath = "//div[@class='item']//span[text()='Duration']")
    WebElement duration;
    //locator for loading the container
    @FindBy(xpath = "//div[@class='train']")
    WebElement loadContainer;
    //locator for container to be load
    @FindBy(className = "home-page-content")
    WebElement searchBoxLoads;
    //locator for storing list of time duration
    @FindBy(xpath = "//span[@class='duration']")
    List<WebElement> durationTimeList;

    //locator for selecting first option from origin station
    @FindBy(xpath = "//input[@type='checkbox' and @value='NZM']")
    WebElement originStation;
    // Locator for the text corresponding to the origin station checkbox
    @FindBy(xpath = "//input[@type='checkbox' and @value='NZM']/following::span[contains(@class, 'MuiTypography-root') and contains(@class, 'MuiFormControlLabel-label') and contains(@class, 'MuiTypography-body1')]")
    WebElement originStationLabel;
    //locator for selecting first option from destination station
    @FindBy(xpath = "//input[@type='checkbox' and @value='MMCT']")
    WebElement destinationStation;
    //locator for getting destination station text
    @FindBy(xpath = "//input[@type='checkbox' and @value='MMCT']/following::span[@class='MuiTypography-root MuiFormControlLabel-label jss18 MuiTypography-body1']")
    WebElement destinationStationLabel;


    // Locator for storing list of origin stations
    @FindBy(xpath = "//div[@class='trainTime']/span[1]")
    List<WebElement> originList;

    // Locator for storing list of destination stations
    @FindBy(xpath = "//div[@class='trainTime']/span[5]")
    List<WebElement> destinationList;

    //locator for clicking reset all option
    @FindBy(className = "reset")
    WebElement resetAll;

    public boolean verifyUserIsOnTheTrainTicketBookingPage() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBoxLoads));
        return isDisplayed(trainText);
    }

    public void userClicksTheSearchButton() {
        search.click();
    }

    public boolean filterAndSortIsDisplayed() {
        return isDisplayed(filter);
    }

    public void userClicksOnDurationIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(loadContainer));
        duration.click();
    }

    public boolean isDurationFilterWorking() {
        // Extract the text from each WebElement
        List<Integer> durationInMinutesList = durationTimeList.stream()
                .map(WebElement::getText)
                .map(time -> {
                    // Step 2: Split the time string into hours and minutes
                    String[] parts = time.split(" ");
                    int hours = Integer.parseInt(parts[0].replace("h", ""));
                    int minutes = Integer.parseInt(parts[1].replace("m", ""));
                    return hours * 60 + minutes; // Convert the total time to minutes
                })
                .toList();

        // Print each duration in minutes
//        for (int duration : durationInMinutesList) {
//            System.out.println(duration);
//        }

        // Step 3: Check if the list is sorted in ascending order
        return IntStream.range(0, durationInMinutesList.size() - 1)
                .allMatch(i -> durationInMinutesList.get(i) <= durationInMinutesList.get(i + 1));
    }

    public void userClicksOriginStationFilter() {
        if (!originStation.isSelected()) {
            originStation.click();
        }
    }

    public void userClicksOnDestinationStation() {
        if (!destinationStation.isSelected()) {
            destinationStation.click();
        }
    }

    public void verifyFilterWorked() {
        // Extract origin and destination station labels from the filters
        String originText = originStationLabel.getText();
        String destinationText = destinationStationLabel.getText();

        // Extract the text from the origin and destination lists
        List<String> originStationList = originList.stream()
                .map(WebElement::getText)
                .map(text -> text.split(" ")[1]) // Extract the station code "NZM" from "04:00 NZM"
                .toList();

        List<String> destinationStationList = destinationList.stream()
                .map(WebElement::getText)
                .map(text -> text.split(" ")[1]) // Extract the station code "MMCT" from "23:35 MMCT"
                .toList();
        // Verify that the origin and destination stations in the lists match the filter labels
        boolean isFilterCorrect = originStationList.contains(originText) && destinationStationList.contains(destinationText);
        Assert.assertTrue(isFilterCorrect);
    }

    public void clickResetButton() {
        resetAll.click();
    }

    public void filtersAreReset() {
        Assert.assertFalse(originStation.isSelected());
        Assert.assertFalse(destinationStation.isSelected());
    }
}
