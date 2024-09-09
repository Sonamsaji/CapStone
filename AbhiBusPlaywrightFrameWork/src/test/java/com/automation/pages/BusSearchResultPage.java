package com.automation.pages;

import com.microsoft.playwright.Locator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusSearchResultPage extends BasePage {

    Locator sortByTitle;
    Locator filterTitle;
    Locator sortByPrice;
    Locator sortByPriceResults;


    public BusSearchResultPage() {
        filterTitle = page.locator("//div[@id='seat-filter-clear-all']/p");
        sortByTitle = page.locator("//div[@class='title col auto']/span");
        sortByPrice = page.locator("//div[@id='sorting-action']/div/div[2]/div/a[1]");
        sortByPriceResults = page.locator("//strong[@class='h5 fare']/span");
    }

    public Locator filterTitle() {
        return filterTitle;
    }

    public Locator sortTitle() {
        return sortByTitle;
    }

    public void clickOnSortByPrice() {
        sortByPrice.click();
    }

    public boolean areResultsSortedByPrice() {
        List<Integer> prices = new ArrayList<>();
        List<Integer> copyOfPrices = new ArrayList<>();

        System.out.println(sortByPriceResults.count());
        for (int i = 0; i < sortByPriceResults.count(); i++) {
            String text = sortByPriceResults.nth(i).innerText();
            int price = Integer.parseInt(text.replaceAll("[^0-9]", ""));
            prices.add(price);
            copyOfPrices.add(price);
        }

        Collections.sort(copyOfPrices);

        System.out.println(prices + " actual");
        System.out.println(copyOfPrices + " expected");

        return prices.equals(copyOfPrices);
    }
}
