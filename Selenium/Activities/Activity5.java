package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		//Open a new browser
		driver.get("https://training-support.net/webelements/dynamic-controls");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//Find the checkbox input element.Check if it is visible on the page.
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		System.out.println("Checkbox is visible: " + checkbox.isDisplayed());
		//Click the "Toggle Checkbox" button.Check if it is visible again and print the result.
		driver.findElement(By.cssSelector("section.mx-auto:nth-child(1) > button:nth-child(2)")).click();
		System.out.println("Checkbox isn't visible");
		//Close
		driver.quit();
	}

}
