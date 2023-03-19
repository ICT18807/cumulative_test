package com.cumulative_test.cumulative_test.steps;

import com.cumulative_test.cumulative_test.utilities.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LogoutSteps {
    @Given("Click on logout button")
    public void clickOnLogoutButton() {
        WebDriverManager.getDriver().findElement(By.id("logoutLink")).click();
    }

    @Then("User is logged out and on {string} page")
    public void userIsLoggedOutAndOnPagePage(String page) {
        String result = "";
        try {
            result = WebDriverManager.getDriver().findElement(By.id("loginButton")).getText();
        } catch (Exception ignore) {
        }
        Assert.assertEquals(result, page);
    }
}
