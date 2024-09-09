package com.automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class CareerPageWeb extends BasePageWeb {

//    //locator for getting Career text on career page
//    @FindBy(xpath = "//div[@class='col-md-10 pl-0']//h2")
//    WebElement career;
//    //locator for getting job title on career page
//    @FindBy(xpath = "//*[@id=\"smartWidget0\"]//tr[3]")
//    WebElement job;
//
//    @FindBy(xpath = "//main[@class=\"jobad-main job\"]//h1")
//    WebElement jobTitle;
//
//    public String userIsOnTheCareersPage() {
//        return career.getText();
//    }
//
//    public void userClicksJobTitle() {
//        job.click();
//    }
//
//    public void userSwitchToJobDescriptionPage() {
//        String originalWindow = driver.getWindowHandle();
//        Set<String> listOfWindow = driver.getWindowHandles();
//
//        for (String window : listOfWindow) {
//            if (!window.equals(originalWindow)) {
//                driver.switchTo().window(window);
//                break;
//            }
//        }
//    }
//
//    public String userIsOnJobDescriptionPage() {
//        return jobTitle.getText();
//    }
//
//    public void scrollUntilTextComes() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement headerText = driver.findElement(By.className("headerarrow"));
//        js.executeScript("arguments[0].scrollIntoView(true);", headerText);
//        js.executeScript("arguments[0].click();", headerText);
//    }
// Locator for getting Career text on career page
@FindBy(xpath = "//div[@class='col-md-10 pl-0']//h2")
WebElement career;

    // Locator for job titles on the career page (update if needed to match multiple jobs)
    @FindBy(xpath = "//*[@id=\"smartWidget0\"]//tr")
    List<WebElement> jobList;

    @FindBy(xpath = "//main[@class=\"jobad-main job\"]//h1")
    WebElement jobTitle;

    public String userIsOnTheCareersPage() {
        return career.getText();
    }

    public boolean isJobTitleAvailable() {
        return !jobList.isEmpty(); // Return true if there are job titles present
    }

    public void userClicksJobTitle() {
        if (!jobList.isEmpty()) {
            jobList.get(0).click(); // Click the first available job title
        }
    }

    public void userSwitchToJobDescriptionPage() {
        String originalWindow = driver.getWindowHandle();
        Set<String> listOfWindow = driver.getWindowHandles();

        for (String window : listOfWindow) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public String userIsOnJobDescriptionPage() {
        return jobTitle.getText();
    }

    public void scrollUntilTextComes() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement headerText = driver.findElement(By.className("headerarrow"));
        js.executeScript("arguments[0].scrollIntoView(true);", headerText);
        js.executeScript("arguments[0].click();", headerText);
    }

}
