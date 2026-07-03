package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity5LoginSteps extends BaseClass {
    @Given("user on the login page")
    public void loginPage() {
    	driver.get("https://training-support.net/webelements/login-form");
		String Title = driver.getTitle();
		System.out.println("Page Title is "+ Title);
		assertEquals("Selenium: Login Form", Title);
    }

    @When("user enter username and password")
    public void enterCredentials() {
    	driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
    }

    @When("user enter {string} and {string}")
    public void enterCreds(String username, String password) {
    	WebElement usernamevalue = driver.findElement(By.id("username"));
        WebElement passwordvalue = driver.findElement(By.id("password"));
        usernamevalue.clear();
        passwordvalue.clear();
        usernamevalue.sendKeys(username);
        passwordvalue.sendKeys(password);
    }

    @And("click submit button")
    public void submitButtonClick() {
    	driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
    }

    @Then("got confirmation text and verify it")
    public void aboutUsPageValidation() {
    	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
        String confirmationMessage = driver.findElement(By.cssSelector("h2.mt-5")).getText();
		assertEquals("Welcome Back, Admin!", confirmationMessage);
    }

    @Then("got confirmation text and verify message as {string}")
    public void confirmMessage(String expectedMessage) {
        String message = "NOT FOUND";
        if (expectedMessage.contains("Invalid")) {
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2#subheading"))).getText();
        } else {
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5"))).getText();
        }
        // Assert message
        Assertions.assertEquals(expectedMessage, message);
    }
}
