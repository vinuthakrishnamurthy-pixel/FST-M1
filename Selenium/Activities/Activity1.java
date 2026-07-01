package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		
		//Open the training support site. (https://training-support.net)
		driver.get("https://training-support.net");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is "+ Title);
		//Click the about us button
		driver.findElement(By.linkText("About Us")).click();
		//Print the title of the new page
		String NewTitle = driver.getTitle();
		System.out.println("New Page Title is "+ NewTitle);
		driver.quit();

	}

}
