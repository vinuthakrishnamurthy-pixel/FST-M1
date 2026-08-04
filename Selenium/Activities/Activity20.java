package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		//Open a new browser
		driver.get("https://training-support.net/webelements/alerts");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//Prompt Alert Accept
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		promptAlert.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Awesome!");
		Thread.sleep(5000);
		alert.accept();
		WebElement result = driver.findElement(By.id("result"));
		System.out.println("Prompt Alert: "+ result.getText());
		//close
		driver.quit();	
	}
}
