package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	
	
	@BeforeClass
	 public void setUp() {
	driver = new FirefoxDriver();
	driver.get("https://training-support.net/webelements/login-form/");
	}
	@Test
	public void login() {
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("password");
		WebElement login=driver.findElement(By.cssSelector("button.svelte-1pdjkmx"));
		login.click();
		String message = driver.findElement(By.cssSelector("h2.text-center")).getText();
        Assert.assertEquals("Welcome Back, Admin!", message);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
