package com.automation.steps;

import com.automation.pages.web.JobDescriptionPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class JobDescriptionPageSteps {

    JobDescriptionPageWeb jobDescriptionPage = new JobDescriptionPageWeb();

    @When("user clicks the I'm interested button")
    public void userClicksTheIMInterestedButton() throws InterruptedException {
        jobDescriptionPage.clickIMInterestedButton();
        Thread.sleep(6000);
    }

    @And("fills in the required details and clicks Next")
    public void fillsInTheRequiredDetailsAndClicksNext() throws InterruptedException {
        Thread.sleep(6000);
        jobDescriptionPage.userFillsDetails();
        Thread.sleep(4000);
        jobDescriptionPage.clickNextButton();
    }

    @And("fills in the notice period details and clicks Submit")
    public void fillsInTheNoticePeriodDetailsAndClicksSubmit() {
        jobDescriptionPage.userFillsNoticePeriodDetails();
    }

    @Then("verify the application is submitted")
    public void verifyTheApplicationIsSubmitted() {
        Assert.assertEquals(jobDescriptionPage.applicationSubmittedSuccessful(), ConfigReader.getConfigValue("success.message"));
    }
}
