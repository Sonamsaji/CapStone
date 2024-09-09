package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusSearchResultPage extends BasePage {

    // Locating elements related to "From" station search results
    @FindBy(xpath = "//div[@id='travel-distance-source-info']/div/div[3]")
    List<WebElement> busSearchFromStationResults;

    // Locating elements related to "To" station search results
    @FindBy(xpath = "//div[@id='travel-distance-destination-info']/div/div[3]")
    List<WebElement> busSearchToStationResults;

    // Locating the "Sort by Price" button
    @FindBy(xpath = "//div[@id='sorting-action']/div/div[2]/div/a[1]")
    WebElement sortByPrice;

    // Locating all search result prices
    @FindBy(xpath = "//strong[@class='h5 fare']/span")
    List<WebElement> sortByPriceResults;

    // Locating the "Sort by Seats" button
    @FindBy(xpath = "//div[@id='sorting-action']/div/div[2]/div/a[2]")
    WebElement sortBySeats;

    // Locating seat availability info in search results
    @FindBy(xpath = "//div[@class='text-grey']/small[1]")
    List<WebElement> sortBySeatsResults;

    // Locating the "Sort by Ratings" button
    @FindBy(xpath = "//div[@id='sorting-action']/div/div[2]/div/a[3]")
    WebElement sortByRatings;

    // Locating service ratings in search results
    @FindBy(xpath = "//div[@class= 'container card service  md ']//div[@class='container service-rating ']//div[1]/span")
    List<WebElement> sortByRatingsResults;

    public boolean areSearchResultsCorrect() {

        for (int i = 0; i < busSearchFromStationResults.size(); i++) {

            if (!busSearchFromStationResults.get(i).getText().contains(ConfigReader.getConfigProperty("fromStation")) && !busSearchToStationResults.get(i).getText().contains(ConfigReader.getConfigProperty("toStation"))) {
                return false;
            }
        }
        return true;
    }

    public void clickOnSortByPrice() {
        sortByPrice.click();
    }

    public boolean areResultsSortedByPrice() {
        List<Integer> prices = new ArrayList<>();
        List<Integer> copyOfPrices = new ArrayList<>();

        for (WebElement sortByPriceResult : sortByPriceResults) {
            String text = sortByPriceResult.getText();
            int price = Integer.parseInt(text.replaceAll("[^0-9]", ""));
            prices.add(price);
            copyOfPrices.add(price);
        }

        Collections.sort(copyOfPrices);

        System.out.println(prices + " actual");
        System.out.println(copyOfPrices + " expected");

        return prices.equals(copyOfPrices);
    }

    public void clickOnSortByRatings() {
        sortByRatings.click();
    }

    public boolean areResultsSortedByRatings() {
        List<Double> ratings = new ArrayList<>();
        for (WebElement sortByRatingsResult : sortByRatingsResults) {
            String text = sortByRatingsResult.getText();
            double rating = Double.parseDouble(text);
            ratings.add(rating);
        }
        List<Double> copyOfRatings = new ArrayList<>(ratings);
        Collections.sort(copyOfRatings);     //sort ratings
        Collections.reverse(copyOfRatings); //to make the sort in descending order

        System.out.println(ratings + " actual");
        System.out.println(copyOfRatings + " expected");

        return ratings.equals(copyOfRatings);
    }

    public void clickOnSortBySeats() {
        sortBySeats.click();
    }

    public boolean areResultsSortedBySeats() {
        List<Integer> seats = new ArrayList<>();

        for (WebElement sortBySeatsResult : sortBySeatsResults) {
            String text = sortBySeatsResult.getText();
            int seat = Integer.parseInt(text.replaceAll("[^0-9]", ""));
            seats.add(seat);
        }
        List<Integer> copyOfSeats = new ArrayList<>(seats);

        Collections.sort(copyOfSeats); // to sort
        Collections.reverse(copyOfSeats);// to convert sort into descending order;

        System.out.println(seats + " actual");
        System.out.println(copyOfSeats + " expected");

        return seats.equals(copyOfSeats);
    }
}
