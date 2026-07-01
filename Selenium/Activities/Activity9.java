package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		// Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//Open a new browser
		driver.get(" https://training-support.net/webelements/dynamic-content");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//Find and click the "Click me!" button.
		WebElement clickMe = driver.findElement(By.id("genButton"));
		clickMe.click();
		//Wait till the word "release" appears.
		//Get the text and print it to console.
		if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"))) {
            System.out.println("Word found: " + driver.findElement(By.id("word")).getText());
		}
		//Close
		driver.quit();
		}
}

