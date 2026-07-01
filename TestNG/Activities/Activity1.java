package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
		// TODO Auto-generated method stub
	    WebDriver driver;
		@BeforeClass
		 public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net");
		}
		@Test(priority = 1)
		public void homePageValidation() {
			String Title = driver.getTitle();
			System.out.println("Page Title is "+ Title);
			Assert.assertEquals(Title, "Training Support");
			driver.findElement(By.linkText("About Us")).click();
		}
		@Test(priority = 2)
		public void aboutUsPageValidation() {
			String Title = driver.getTitle();
			System.out.println("Page Title is "+ Title);
			Assert.assertEquals(Title, "About Training Support");
			
		}
		
		@AfterClass
		 public void tearDown() {
		driver.quit();
		}

}