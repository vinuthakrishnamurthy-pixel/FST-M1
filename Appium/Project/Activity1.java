package project;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	AppiumDriver driver;
	WebDriverWait Wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		//File Object for the application
		File testApp = new File("src/test/resources/ToDo (1).apk");
		//Set the desired capabilities or options
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		//options.noReset();
		//Set the Appium server URL
		URL serverUrl = new URI("http://localhost:4723").toURL();
	
		//Initialize the object
		driver = new AndroidDriver(serverUrl, options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void testMethod() {
		//Click the New button to add a new task.
		//Task1
		WebElement toDoNew1 = driver.findElement(AppiumBy.id("ListButtonNew"));
		toDoNew1.click();
		WebElement task1Desc = driver.findElement(AppiumBy.id("DetailEditTextDescription"));
		task1Desc.sendKeys("Activity1");
		WebElement task1DueDate = driver.findElement(AppiumBy.id("DetailButtonDueDate"));
		task1DueDate.click();
		WebElement task1selection = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"7/22 – Today\"]"));
		task1selection.click();
		WebElement task1save = driver.findElement(AppiumBy.id("DetailButtonOK"));
		task1save.click();
		//Task2
		WebElement toDoNew2 = driver.findElement(AppiumBy.id("ListButtonNew"));
		toDoNew2.click();
		WebElement task2Desc = driver.findElement(AppiumBy.id("DetailEditTextDescription"));
		task2Desc.sendKeys("Activity2");
		WebElement task2DueDate = driver.findElement(AppiumBy.id("DetailButtonDueDate"));
		task2DueDate.click();
		WebElement task2selection = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"7/22 – Today\"]"));
		task2selection.click();
		WebElement task2save = driver.findElement(AppiumBy.id("DetailButtonOK"));
		task2save.click();
		//Task3
		WebElement toDoNew3 = driver.findElement(AppiumBy.id("ListButtonNew"));
		toDoNew3.click();
		WebElement task3Desc = driver.findElement(AppiumBy.id("DetailEditTextDescription"));
		task3Desc.sendKeys("Activity3");
		WebElement task3DueDate = driver.findElement(AppiumBy.id("DetailButtonDueDate"));
		task3DueDate.click();
		WebElement task3selection = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"7/23 – Tomorrow\"]"));
		task3selection.click();
		WebElement task3save = driver.findElement(AppiumBy.id("DetailButtonOK"));
		task3save.click();
		//Assertions
        WebElement Task1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoEditDescription\" and @text=\"Activity1\"]"));
		Assert.assertEquals(Task1.getText(),"Activity1");
		WebElement Task2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoEditDescription\" and @text=\"Activity2\"]"));
		Assert.assertEquals(Task2.getText(), "Activity2");
		WebElement Task3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.xmission.trevin.android.todo:id/ToDoEditDescription\" and @text=\"Activity3\"]"));
		Assert.assertEquals(Task3.getText(), "Activity3");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
