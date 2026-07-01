package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	
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
		//Edit
		WebElement editBtnClick = driver.findElement(By.id("btnSave"));
		editBtnClick.click();
		//FN and LN
		WebElement editFirstName = driver.findElement(By.id("personal_txtEmpFirstName"));
		editFirstName.clear();
		editFirstName.sendKeys("Rahul");
		WebElement editLastName = driver.findElement(By.id("personal_txtEmpLastName"));
		editLastName.clear();
		editLastName.sendKeys("Dravid");
		//Gender
		WebElement radioButton = driver.findElement(By.id("personal_optGender_1"));
		radioButton.click();
		//Nationality
		WebElement dropdownElement = driver.findElement(By.id("personal_cmbNation"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("American");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//DOB
		WebElement dateInput = driver.findElement(By.id("personal_DOB"));
		dateInput.clear();
		dateInput.sendKeys("1996-10-28");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Save
		WebElement saveBtn = driver.findElement(By.id("btnSave"));
		saveBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Employee Saved !");	
	}
	
	@AfterClass
	public void tearDown() {
		//close
		driver.quit();
	}

}