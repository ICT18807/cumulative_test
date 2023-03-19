package com.cumulative_test.cumulative_test.steps;

import com.cumulative_test.cumulative_test.constant.EnvironmentConstants;
import com.cumulative_test.cumulative_test.utilities.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CreateUserSteps {
    @Given("Navigate to user panel")
    public void navigateToUserPanel() {
        WebDriverManager.getDriver().findElement(By.id("container_users")).click();
        EnvironmentConstants.manualwait(3);
    }

    @When("Click on new user button")
    public void clickOnNewUserButton() {
        WebDriverManager.getDriver().findElement(By.xpath("//div[normalize-space()=\"New User\"]")).click();
        EnvironmentConstants.manualwait(3);
    }

    @And("Fill the mandatory fields {string} , {string} ,{string}")
    public void fillTheMandatoryFieldsFirstnameLastnameEmail(String Fname,String Lname,String Email) {
        WebDriverManager.getDriver().findElement(By.id("createUserPanel_firstNameField")).sendKeys(Fname);
        WebDriverManager.getDriver().findElement(By.id("createUserPanel_lastNameField")).sendKeys(Lname);
        WebDriverManager.getDriver().findElement(By.id("createUserPanel_emailField")).sendKeys(Email);
        EnvironmentConstants.manualwait(3);
    }

    @And("Save and send invitation")
    public void saveAndSendInvitation() {
        WebDriverManager.getDriver().findElement(By.xpath("//div[normalize-space()=\"Save & Send Invitation\"]")).click();
        EnvironmentConstants.manualwait(3);
    }

    @Then("Validate that new user created successfully")
    public void validateThatNewUserCreatedSuccessfully() {
        String result = "";
        try {
            result = WebDriverManager.getDriver().findElement(By.xpath("//div[normalize-space()=\"Account for Oliver Jake has been created.\"]")).getText();
        } catch (Exception ignore) {
        }
        WebDriverManager.getDriver().findElement(By.xpath("//span[normalize-space()=\"Close\"]")).click();
        Assert.assertEquals(result, "Account for Oliver Jake has been created.");
    }


}
