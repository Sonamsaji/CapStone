package com.automation.steps;

import com.automation.pages.web.CareerPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CareerPageSteps {

    CareerPageWeb careerPage = new CareerPageWeb();

    @Then("verify user is on the Careers page")
    public void verifyUserIsOnTheCareersPage() throws InterruptedException {
        Assert.assertEquals(careerPage.userIsOnTheCareersPage(), ConfigReader.getConfigValue("careers.text"));
        Thread.sleep(5000);
    }

//    @And("user clicks on any job title")
//    public void userClicksOnAnyJobTitle() throws InterruptedException {
//        careerPage.scrollUntilTextComes();
//        Thread.sleep(5000);
//        careerPage.userClicksJobTitle();
//        careerPage.userSwitchToJobDescriptionPage();
//    }
//
//    @Then("verify user is on the job description page")
//    public void verifyUserIsOnTheJobDescriptionPage() throws InterruptedException {
//        Assert.assertEquals(careerPage.userIsOnJobDescriptionPage(), ConfigReader.getConfigValue("job.text"));
//        Thread.sleep(4000);
//    }
//
//    @But("if there are no job openings, print No job openings available")
//    public void ifThereAreNoJobOpeningsPrintNoJobOpeningsAvailable() {
//
//    }
@And("user clicks on any job title")
public void userClicksOnAnyJobTitle() throws InterruptedException {
    careerPage.scrollUntilTextComes();
    Thread.sleep(5000);

    // Check if any job titles are available before proceeding
    if (careerPage.isJobTitleAvailable()) {
        careerPage.userClicksJobTitle();
        careerPage.userSwitchToJobDescriptionPage();
    }
//    else {
//        System.out.println("No job openings available.");
//    }
}

    @Then("verify user is on the job description page")
    public void verifyUserIsOnTheJobDescriptionPage() throws InterruptedException {
        Assert.assertEquals(careerPage.userIsOnJobDescriptionPage(), ConfigReader.getConfigValue("job.text"));
        Thread.sleep(4000);
    }

    @But("if there are no job openings, print No job openings available")
    public void ifThereAreNoJobOpeningsPrintNoJobOpeningsAvailable() {
        if (!careerPage.isJobTitleAvailable()) {
            System.out.println("No job openings available.");
        }
    }
}
