package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");	
	}
	
	@DataProvider(name = "Credentials")
    public static Object[][] creds() {
        return new Object[][] { 
            { "admin1", "password1", "Invalid credentials" },
            { "wrongAdmin", "wrongPassword", "Invalid credentials" }
        };
    }
	
	@Test (dataProvider = "Credentials")
	public void login (String username, String password, String expectedMessage) {
		WebElement userName = driver.findElement(By.id("username"));
		WebElement passwordValue = driver.findElement(By.id("password"));
		WebElement submit = driver.findElement(By.cssSelector("button.svelte-1pdjkmx"));
		userName.clear();
        passwordValue.clear();
		userName.sendKeys(username);
        passwordValue.sendKeys(password);
        submit.click();
        String loginMessage = driver.findElement(By.id("subheading")).getText();
        Assert.assertEquals(loginMessage, expectedMessage);
	}


	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
