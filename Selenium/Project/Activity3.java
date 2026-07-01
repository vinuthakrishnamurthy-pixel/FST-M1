package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		//Open
		driver = new FirefoxDriver();
		//Browser
		driver.get("https://hrm.alchemy.hguy.co");
    }
	
	@Test
	public void login() {
		//userName
		WebElement UserName = driver.findElement(By.id("txtUsername"));
		UserName.sendKeys("orange");
		//password
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("5Nx#I6BK%r3$8vz0ch");
		//Click login button
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		//Verify homePage opened
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String URL = driver.getCurrentUrl();
		System.out.println("Login Success. New page URL is: "+ URL);	
	}
	
	@AfterClass
	public void tearDown() {
		//close
		driver.quit();
	}

}