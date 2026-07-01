package project;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
	  WebDriver driver;
	  @BeforeClass
	  public void setUp() {
		//Open
	    driver = new FirefoxDriver();
		//Navigate to
		driver.get(" https://hrm.alchemy.hguy.co");
	  }
	  @Test
	  public void titleValidation() {
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is "+ Title);
		//Assert
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(Title, expectedTitle, "Title matches");
}
		@AfterClass
		 public void tearDown() {
		driver.quit();
		}

}
