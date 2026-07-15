package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");	
	}
	
	@Test
	@Parameters ({ "username", "password", "message" })
	public void login(String username, String password, @Optional("Login Success!") String message) {
		WebElement userName = driver.findElement(By.id("username"));
		WebElement passwordValue = driver.findElement(By.id("password"));
		userName.sendKeys(username);
        passwordValue.sendKeys(password);
        driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        Assert.assertEquals("Welcome Back, Admin!", loginMessage);
		
	}


	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
