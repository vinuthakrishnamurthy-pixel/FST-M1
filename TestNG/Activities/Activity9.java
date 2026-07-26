package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		Reporter.log("Browser Opened |");
        Reporter.log("Page title is " + driver.getTitle() + " |");
	}
	
	@BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }
	@Test (priority=1)
	public void simpleAlertTestCase() {
	WebElement simpleAlert = driver.findElement(By.id("simple"));
	simpleAlert.click();
	Reporter.log("Simple Alert opened |");
	Alert simpleAlert1 = driver.switchTo().alert();
	String alertText1 = simpleAlert1.getText();
	Assert.assertEquals("You've just triggered a simple alert!", alertText1);
	simpleAlert1.accept();
    Reporter.log("Simple Alert closed");
	}
	
	@Test (priority=2)
	public void confirmAlertTestCase(){
	WebElement confirmAlert = driver.findElement(By.id("confirmation"));
	confirmAlert.click();
	Reporter.log("Confirm Alert opened |");
	Alert confirmAlert1 = driver.switchTo().alert();
	String alertText2 = confirmAlert1.getText();
	Assert.assertEquals("You've just triggered a confirmation alert!", alertText2);
	confirmAlert1.accept();
	Reporter.log("Confirmation Alert closed");		
	}
	
	@Test (priority=3)
	public void promptAlertTestCase() {
	WebElement promptAlert = driver.findElement(By.id("prompt"));
	promptAlert.click();
	Reporter.log("Prompt Alert opened |");
	Alert promptAlert1 = driver.switchTo().alert();
	String alertText3 = promptAlert1.getText();
	Assert.assertEquals("I'm a Prompt! Type something into me!", alertText3);
	promptAlert1.sendKeys("Hi!");
	promptAlert1.accept();
	Reporter.log("Prompt Alert closed");	
	}
	
	
	@AfterClass
	public void tearDown() {
		Reporter.log("Ending Test |");
		driver.quit();	
	}

}
