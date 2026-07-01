package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	
	  WebDriver driver;
	  
	  @BeforeClass
	  public void setUp() {
		//Open
	    driver = new FirefoxDriver();
		//Navigate to
		driver.get(" https://hrm.alchemy.hguy.co");
	  }
	  
	  @Test
	  public void imageURL() {
				// identify image
		WebElement image = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/img"));
			      //getAttribute() to get src of image
			      System.out.println("Src attribute is: "+ image.getAttribute("src"));
			      
			  }
	  @AfterClass
		 public void tearDown() {
		driver.quit();
		}

}
