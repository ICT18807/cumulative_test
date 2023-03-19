package com.cumulative_test.cumulative_test.steps;

import com.cumulative_test.cumulative_test.constant.EnvironmentConstants;
import com.cumulative_test.cumulative_test.utilities.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginSteps {

    @Given("Launch actitime Login page")
    public void launch_actitime_login_page() {
        WebDriverManager.getDriver().navigate().to("https://demo.actitime.com/login.do");
    }

    @When("Input {string} and {string}")
    public void inputEmailAndPassword(String user, String pwd) {
        WebDriverManager.getDriver().findElement(By.name("username")).sendKeys(user);
        WebDriverManager.getDriver().findElement(By.name("pwd")).sendKeys(pwd);
        EnvironmentConstants.manualwait(3);
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        WebDriverManager.getDriver().findElement(By.id("loginButton")).click();
        EnvironmentConstants.manualwait(3);
    }

    @Then("User is logged in")
    public void userIsLoggedIn() {
        String result = "";
        try {
            result = WebDriverManager.getDriver().findElement(By.xpath("//a[normalize-space()=\"Logout\"]")).getText();
        } catch (Exception ignore) {
        }
        Assert.assertEquals(result, "Logout");
    }

    @Then("User is not logged in")
    public void userIsNotLoggedIn() {
        String result = "";
        try {
            result = WebDriverManager.getDriver().findElement(By.className("errormsg")).getText();
        } catch (Exception ignore) {
        }
        Assert.assertEquals(result, "Username or Password is invalid. Please try again.");
    }
}
