package activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

public class Activity5 {
	WebDriver driver;
	@BeforeClass (alwaysRun = true)
	 public void setUp() {
	driver = new FirefoxDriver();
	driver.get("https://training-support.net/webelements/target-practice");
	}
	
	@Test(groups = { "HeaderTest", "ButtonTest" })
	public void pageTitle() {
		
	}
	
	@Test(dependsOnMethods = { "pageTitle" }, groups = { "HeaderTest" })
    public void Header1() {
		WebElement h3 = driver.findElement(By.cssSelector("h3.text-3xl:nth-child(5)"));
		Assert.assertEquals(h3.getText(), "Heading #3");
	}
	
	@Test(dependsOnMethods = { "pageTitle" }, groups = { "HeaderTest" })
    public void Header2() {
		Color h5 = Color.fromString(driver.findElement(By.cssSelector("h5.text-3xl")).getCssValue("color"));
		Assert.assertEquals(h5.asHex(), "#9333ea");	
	}
	
	@Test(dependsOnMethods = { "pageTitle" }, groups = { "ButtonTest" })
    public void Button1() {
		WebElement emerald = driver.findElement(By.cssSelector("button.rounded-xl:nth-child(16)"));
		Assert.assertEquals(emerald.getText(), "Emerald");
	}
	
	@Test(dependsOnMethods = { "pageTitle" }, groups = { "ButtonTest" })
    public void Button2() {
		Color purple = Color.fromString(driver.findElement(By.cssSelector("button.rounded-xl:nth-child(9)")).getCssValue("color"));
		Assert.assertEquals(purple.asHex(), "#581c87");			
	}
	
	@AfterClass (alwaysRun = true)
	 public void teardown() {
	driver.quit();
	}
}
