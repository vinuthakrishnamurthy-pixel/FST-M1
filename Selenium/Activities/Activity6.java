package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		//Open a new browser
		driver.get("https://training-support.net/webelements/dynamic-controls");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//Find the checkbox input element.
		//Check if the checkbox is selected and print the result.
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		System.out.println("Checkbox is selected: " + checkbox.isSelected());
		//Click the checkbox to select it.
		//Check if the checkbox is selected again and print the result.
		WebElement checkbox1 = driver.findElement(By.id("checkbox"));
		checkbox1.click();
		System.out.println("Checkbox is selected: " + checkbox1.isSelected());
		//Close
		driver.quit();
	}

}
