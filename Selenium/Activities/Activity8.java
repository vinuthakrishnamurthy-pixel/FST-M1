package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8 {

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
		//Click the "Toggle Checkbox" button to remove the checkbox.
		WebElement ToggleCheckbox = driver.findElement(By.cssSelector("section.mx-auto:nth-child(1) > button:nth-child(2)"));
		ToggleCheckbox.click();
		//Wait for the checkbox to disappear.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Checkbox is visible: " + checkbox.isDisplayed());
		//Toggle the checkbox again.
		ToggleCheckbox.click();
		//Wait for it appear and then select it.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Checkbox is visible: " + checkbox.isDisplayed());
		checkbox.click();
		System.out.println("Checkbox is selected: " + checkbox.isSelected());
		//Close
		driver.quit();
	}

}
