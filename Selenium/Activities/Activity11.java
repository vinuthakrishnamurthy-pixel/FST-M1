package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		//Open a new browser
		driver.get(" https://training-support.net/webelements/keyboard-events");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		// Press the key
        builder.sendKeys("hi").sendKeys(Keys.RETURN).build().perform();
        // Print the message from the page
        String pageText = driver.findElement(By.cssSelector("h1.mt-3")).getText();
        System.out.println(pageText);
        //Close
        driver.quit();
	}

}
