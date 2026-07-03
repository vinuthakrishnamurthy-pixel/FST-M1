package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity3Alerts extends BaseClass {

    Alert alertSwitch;

    @Given("User is on the page")
    public void Homepage() {
        driver.get("https://training-support.net/webelements/alerts");
        String Title = driver.getTitle();
        System.out.println("Page Title is " + Title);
        assertEquals("Selenium: Alerts", Title);
    }

    @When("User clicks the Simple Alert button")
    public void simpleAlert() {
        WebElement sAlert = driver.findElement(By.id("simple"));
        sAlert.click();
    }

    @When("User clicks the Confirm Alert button")
    public void confirmAlert() {
        WebElement cAlert = driver.findElement(By.id("confirmation"));
        cAlert.click();
    }

    @When("User clicks the Prompt Alert button")
    public void promptAlert() {
        WebElement pAlert = driver.findElement(By.id("prompt"));
        pAlert.click();
    }

    @Then("Alert opens")
    public void alertOpens() {
        alertSwitch = driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public void textRead() {
        String alertText = alertSwitch.getText();
        System.out.println("Alert Text is: " + alertText);
    }
    
    @And("Write a custom message in it")
    public void textWrite() {
        alertSwitch.sendKeys("Clicked Prompt Alert");
    }
    
    @And("Close the alert")
    public void alertClose() {
    	alertSwitch.accept();   
    }
    
    @And("Close the alert with Cancel")
    public void alertCloseCancel() {
    	alertSwitch.dismiss();   
    }
    
    @And("Read the result text")
    public void resultText() {
    	WebElement resultText = driver.findElement(By.id("result")) ;
    	System.out.println("Result Text: " + resultText.getText());
    }

}
