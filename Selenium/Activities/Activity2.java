package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	WebDriver driver = new FirefoxDriver();
	//Open a new browser
	driver.get("https://training-support.net/webelements/login-form");
	//Print the title of the page
	String Title = driver.getTitle();
	System.out.println("Page Title is "+ Title);
	//Find the username field using any locator and enter "admin" into it.
	driver.findElement(By.id("username")).sendKeys("admin");
	//Find the password field using any locator and enter "password" into it.
	driver.findElement(By.id("password")).sendKeys("password");
	//Find the "Log in" button using any locator and click it.
	driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
	// Print the confirmation message
    String message = driver.findElement(By.tagName("h1")).getText();
    System.out.println(message);
	//Close the browser.
	driver.quit();
	}

}
