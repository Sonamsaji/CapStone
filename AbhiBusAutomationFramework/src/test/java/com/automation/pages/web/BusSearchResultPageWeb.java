package com.automation.pages.web;

import com.automation.pages.interfaces.BusSearchResultPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BusSearchResultPageWeb extends BasePageWeb implements BusSearchResultPage {

    @FindBy(xpath = "//div[@class='title col auto']/span")
    WebElement sortByTitle;

    @FindBy(xpath = "//div[@id='seat-filter-clear-all']/p")
    WebElement filterTitle;

    @FindBy(xpath = "//div[@id='travel-distance-source-info']/div/div[3]")
    List<WebElement> busSearchFromStationResults;

    @FindBy(xpath = "//div[@id='travel-distance-destination-info']/div/div[3]")
    List<WebElement> busSearchToStationResults;

    @FindBy(id = "price-drop")
    WebElement priceDropFilter;

    @FindBy(xpath = "//small[@class='text-grey strike-through']")
    List<WebElement> originalPriceStrikeThrough;

    @FindBy(xpath = "//div/strong/span")
    List<WebElement> discountedPrice;

    @FindBy(xpath = "//div[@id='sorting-action']/div/div[2]/div/a[1]")
    WebElement sortByPrice;

    @FindBy(xpath = "//strong[@class='h5 fare']/span")
    List<WebElement> sortByPriceResults;

    @FindBy(xpath = "//div[@id='sorting-action']/div/div[2]/div/a[2]")
    WebElement sortBySeats;

    @FindBy(xpath = "//div[@class='text-grey']/small[1]")
    List<WebElement> sortBySeatsResults;

    @FindBy(xpath = "//div[@id='sorting-action']/div/div[2]/div/a[3]")
    WebElement sortByRatings;

    @FindBy(xpath = "//div[@class= 'container card service  md ']//div[@class='container service-rating ']//div[1]/span")
    List<WebElement> sortByRatingsResults;

    @FindBy(xpath = "//div[@id='sorting-action']/div/div[2]/div/a[4]")
    WebElement sortByArrivalTime;

    @FindBy(xpath = "//div[@class='destination-name text-grey col auto']")
    List<WebElement> sortByArrivalTimeResultsDate;

    @FindBy(xpath = "//span[@class='arrival-time']")
    List<WebElement> sortByArrivalTimeResultsTime;

    @FindBy(xpath = "//div[@id='sorting-action']/div/div[2]/div/a[5]")
    WebElement sortByDepartureTime;

    @FindBy(xpath = "//div[@class='source-name text-grey col auto']")
    List<WebElement> sortByDepartureTimeResultsDate;

    @FindBy(xpath = "//span[@class='departure-time']")
    List<WebElement> sortByDepartureTimeResultsTime;

    @FindBy(xpath = "//div[@class='operator-info col s12 m5 l5']/p")
    List<WebElement> filterByBusType;

    @FindBy(xpath = "//div[@class='horizontal-slider']")
    WebElement priceFilterSlider;

    @FindBy(xpath = "//div[@class='container price-range-header ']/span[1]")
    WebElement lowerLimitOfPriceFilter;

    @FindBy(xpath = "//div[@class='container price-range-header ']/span[2]")
    WebElement upperLimitOfPriceFilter;


    public boolean isUserOnSearchResultPage() {

        return isDisplayed(filterTitle) && isDisplayed(sortByTitle);
    }

    public boolean areSearchResultsCorrect() {

        for (int i = 0; i < busSearchFromStationResults.size(); i++) {

            if (!busSearchFromStationResults.get(i).getText().contains(ConfigReader.getConfigValue("fromStation")) && !busSearchToStationResults.get(i).getText().contains(ConfigReader.getConfigValue("toStation"))) {
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

    public void clickOnSortByArrivalTime() {
        sortByArrivalTime.click();
    }

    public boolean areResultsSortedByArrivalTime() {
        List<String> listOfArrivalTime = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM HH:mm");
        dateFormat.setLenient(false); // To ensure strict parsing

        for (int i = 0; i < sortByArrivalTimeResultsDate.size(); i++) {
            String dateTime = sortByArrivalTimeResultsDate.get(i).getText() + " " + sortByArrivalTimeResultsTime.get(i).getText();
            listOfArrivalTime.add(dateTime);
        }

        List<Date> dates = new ArrayList<>();

        // Parse each date string and add to the list
        for (String arrivalTime : listOfArrivalTime) {
            try {
                Date date = dateFormat.parse(arrivalTime.trim());
                dates.add(date);
            } catch (ParseException e) {
                System.out.println("Error parsing date: " + arrivalTime.trim());
            }
        }

        // Sort dates
        Collections.sort(dates);

        List<String> stringDates = new ArrayList<>();// to convert List in dates types to string type
        for (Date date : dates) {
            stringDates.add(dateFormat.format(date));
        }

        System.out.println(listOfArrivalTime + " actual");
        System.out.println(stringDates + " expected");

        return listOfArrivalTime.equals(stringDates);
    }

    public void clickOnSortByDepartureTime() {
        sortByDepartureTime.click();
    }

    public boolean areResultsSortedByDepartureTime() {
        List<String> listOfDepartureTime = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM HH:mm");
        dateFormat.setLenient(false); // To ensure strict parsing

        for (int i = 0; i < sortByDepartureTimeResultsDate.size(); i++) {
            String dateTime = sortByDepartureTimeResultsDate.get(i).getText() + " " + sortByDepartureTimeResultsTime.get(i).getText();
            listOfDepartureTime.add(dateTime);
        }

        List<Date> dates = new ArrayList<>();

        // Parse each date string and add to the list
        for (String departureTime : listOfDepartureTime) {
            try {
                Date date = dateFormat.parse(departureTime.trim());
                dates.add(date);
            } catch (ParseException e) {
                System.out.println("Error parsing date: " + departureTime.trim());
            }
        }
        // Sort dates
        Collections.sort(dates);

        List<String> stringDates = new ArrayList<>();// to convert List in dates types to string type
        for (Date date : dates) {
            stringDates.add(dateFormat.format(date));
        }

        System.out.println(listOfDepartureTime + " actual");
        System.out.println(stringDates + " expected");
        return listOfDepartureTime.equals(stringDates);
    }

    public void clickOnPriceDropFilter() {
        priceDropFilter.click();
    }

    public boolean isPriceDropDisplayed() {

        for (WebElement element : originalPriceStrikeThrough) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void clickOnBusTypeFilter(String busType) {
        String xpath = "//div[@id='seat-filter-bus-type']/a/span[text()='%s']";
        driver.findElement(By.xpath(String.format(xpath, busType))).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isBusTypeDisplayed(String busType) {

        for (WebElement filter : filterByBusType) {
            if (!filter.getText().contains(busType))
                return false;
        }
        return true;
    }


}
