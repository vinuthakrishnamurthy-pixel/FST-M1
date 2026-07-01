package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		//Open a new browser
		driver.get("https://training-support.net/webelements/dynamic-controls");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//Find the text field.
		//Check if the text field is enabled and print it.
		WebElement textbox= driver.findElement(By.id("textInput"));
		System.out.println("Textbox is enabled: " + textbox.isEnabled());
		//Click the "Enable Input" button to enable the input field.
		//Check if the text field is enabled again and print it.
		WebElement enableinput= driver.findElement(By.id("textInputButton"));
		enableinput.click();
		System.out.println("Textbox is enabled: " + textbox.isEnabled());
		//Close 
		driver.quit();

	}

}
