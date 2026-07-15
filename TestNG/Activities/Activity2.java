package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	  WebDriver driver;
			@BeforeClass
			 public void setUp() {
			driver = new FirefoxDriver();
			driver.get("https://training-support.net/webelements/target-practice/");
			}
			
			@Test(priority = 1)
			public void title() {
				String Title = driver.getTitle();
				System.out.println("Page Title is: " + Title);
				Assert.assertEquals(Title, "Selenium: Target Practice");
						}
			@Test(priority = 2)
			public void blackButton() {
				WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
		        Assert.assertTrue(blackButton.isDisplayed());
		        Assert.assertEquals(blackButton.getText(), "black");	
			}
			@Test(enabled = false)
			public void test3() {
				String subHeading = driver.findElement(By.className("sub")).getText();
		        Assert.assertTrue(subHeading.contains("Practice"));
			}
			@Test(priority = 4)
			public void test4() {
				throw new SkipException("Skipping test case");
			}
			
			
			
			@AfterClass
			 public void tearDown() {
			driver.quit();
			}

}
