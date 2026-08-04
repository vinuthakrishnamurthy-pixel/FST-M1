package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		//Open a new browser
		driver.get("https://training-support.net/webelements/alerts");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//Confirmation Alert Accept
		WebElement confirmationAlert1 = driver.findElement(By.id("confirmation"));
		confirmationAlert1.click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		WebElement result1 = driver.findElement(By.id("result"));
		System.out.println("Confiramtion Alert: "+ result1.getText());
		//Confirmation Alert Dismiss
		WebElement confirmationAlert2 = driver.findElement(By.id("confirmation"));
		confirmationAlert2.click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();
		WebElement result2 = driver.findElement(By.id("result"));
		System.out.println("Dismissed Alert: "+ result2.getText());
		//close
		driver.quit();		
	}

}
