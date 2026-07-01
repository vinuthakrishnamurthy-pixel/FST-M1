package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 {
	
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
		//Addition of New Employee through PIM
		WebElement pimClick = driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b:nth-child(1)"));
		pimClick.click();
		WebElement addClick = driver.findElement(By.id("btnAdd"));
		addClick.click();
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Vinutha");
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Krishnamurthy");
		WebElement empID = driver.findElement(By.id("employeeId"));
		empID.sendKeys("0013500");
		WebElement saveButton = driver.findElement(By.id("btnSave"));
		saveButton.click();
		WebElement empList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
		empList.click();
		WebElement empSearch = driver.findElement(By.id("empsearch_employee_name_empName"));
		empSearch.sendKeys("Vinutha");
		WebElement searchButton = driver.findElement(By.id("searchBtn"));
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Employee found");	
	}
	
	@AfterClass
	public void tearDown() {
		//close
		driver.quit();
	}

}