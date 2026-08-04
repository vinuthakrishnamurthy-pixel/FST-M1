package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Open Browser
		driver.get("https://training-support.net/webelements/tabs");
		//Page Title
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		// Print the handle of the parent window
        System.out.println("Current tab is: " + driver.getWindowHandle());
		//Find the button to open a new tab and click it.
		WebElement button = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/button"));
		button.click();
		//Wait for the new tab to open.
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		// Print all window handles
        System.out.println("Currently open windows: " + driver.getWindowHandles());
        //Switch to the newly opened tab, print it's title and heading.
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            }
        // Wait for the new page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("h2.mt-5")));     
        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());
        //title and heading
        String Title1 = driver.getTitle();
		System.out.println("First New Page Title is: "+ Title1);
		String Header = driver.findElement(By.cssSelector("h2.mt-5")).getText();
        System.out.println("First Page Header: " + Header);
        //Find the button to open a new tab and click it.
		WebElement button1 = driver.findElement(By.cssSelector(".bg-purple-200")); 
		button1.click();
		// Wait for new tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        // Switch focus
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Wait for the new page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5")));
        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());
        // Print the title and heading of the new page
        String Title2 = driver.getTitle();
		System.out.println("Second New Page Title is: "+ Title2);
		String Header2 = driver.findElement(By.cssSelector("h2.mt-5")).getText();
        System.out.println("Second Page Header: " + Header2);
        //Close Browser
        driver.quit();
	}

}
