package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Open a new browser
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//Find the input fields and type in the required data in the fields.
		WebElement fullName = driver.findElement(By.xpath("//input[starts-with(@id, 'full-name')]"));
		fullName.sendKeys("Vinutha B K");
		WebElement email = driver.findElement(By.xpath("//input[contains(@id, '-email')]"));
		email.sendKeys("vinutha@yopmail.com");
		WebElement eventDate = driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]"));
		eventDate.sendKeys("2026-10-26");
        WebElement additionaldetails = driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]"));
        additionaldetails.sendKeys("Birthday");
        //Submit
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//Message display
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();
        System.out.println("Message displayed: " + message);
        //Close
        driver.quit();
	}

}
