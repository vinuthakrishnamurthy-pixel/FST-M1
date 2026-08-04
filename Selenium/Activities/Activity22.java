package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Open Browser
		driver.get("https://training-support.net/webelements/popups");
		//Page Title
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//Search button and Click
		WebElement button = driver.findElement(By.id("launcher"));
		button.click();
		//Enter creds
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password");
		WebElement submitButton = driver.findElement(By.cssSelector("button.svelte-1pdjkmx"));
		submitButton.click();
		String loginMessage = driver.findElement(By.cssSelector("h2.mt-5")).getText();
		System.out.println("Login success message is: " + loginMessage);
		//close
		driver.quit();
	}

}
