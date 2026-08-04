package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		//Open a new browser
		driver.get("https://training-support.net/webelements/drag-drop");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//find the ball
		WebElement ball=driver.findElement(By.id("ball"));
		//dropzone1 and dropzone2
		WebElement dropZone1=driver.findElement(By.id("dropzone1"));
		WebElement dropZone2=driver.findElement(By.id("dropzone2"));
		//drop to zone 1
		builder.clickAndHold(ball).moveToElement(dropZone1).pause(5000).release().build().perform();
        if(dropZone1.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
        System.out.println("Ball dropped in Dropzone 1");
	    }
        //drop to zone 2
        builder.dragAndDrop(ball, dropZone2).pause(5000).build().perform();
        if(dropZone2.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
        	System.out.println("Ball dropped in Dropzone 2");
        }
        //Close
        driver.quit();
	}

}