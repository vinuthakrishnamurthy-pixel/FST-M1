package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	
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
		//Edit a user’s information
		WebElement myInfoClick = driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)"));
		myInfoClick.click();
		//Qualifications
		WebElement qualificationsClick = driver.findElement(By.cssSelector("#sidenav > li:nth-child(9) > a:nth-child(1)"));
		qualificationsClick.click();
		System.out.println("Qualifications Clicked");
		//Add
		WebElement add = driver.findElement(By.id("addWorkExperience"));
		add.click();
		WebElement company = driver.findElement(By.id("experience_employer"));
		company.sendKeys("IBM");
		WebElement JobTitle = driver.findElement(By.id("experience_jobtitle"));
		JobTitle.sendKeys("Engineer");
		WebElement fromDate = driver.findElement(By.id("experience_from_date"));
		fromDate.sendKeys("2025-01-20");
		WebElement ToDate = driver.findElement(By.id("experience_to_date"));
		ToDate.sendKeys("2025-02-28");
		WebElement save = driver.findElement(By.id("btnWorkExpSave"));
		save.click();
		System.out.println("Data Saved");
	}
	
	@AfterClass
	public void tearDown() {
		//close
		driver.quit();
	}

}