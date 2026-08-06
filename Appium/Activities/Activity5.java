package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity5 {
	 
	    AppiumDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setUp() throws MalformedURLException, URISyntaxException {
	        // Desired Capabilities
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setAppPackage("com.google.android.apps.messaging");
	        options.setAppActivity(".ui.ConversationListActivity");
	        options.noReset();
	        URL serverUrl = new URI("http://localhost:4723").toURL();
	        driver = new AndroidDriver(serverUrl, options);
	    }

	    // Test method
	    @Test
		public void messageTest() {
	    	driver.findElement(AppiumBy.accessibilityId("Messages")).click();
	    	driver.findElement(AppiumBy.accessibilityId("Start chat")).click();
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Type name, phone number, or email']")).click();
			driver.switchTo().activeElement().sendKeys("9686233565");
			
			driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"ContactSuggestionList\"]/android.view.View")).click();
			driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/compose_message_text")).sendKeys("Hello from Appium");
			driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"Compose:Draft:Send\"]/android.widget.Button")).click();
			System.out.println(driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"message_list\"]/android.view.View[1]/android.view.View[2]")).getText());
			String actual=driver.findElement(AppiumBy.xpath("You said  Hello 12:20 PM ., Not end-to-end encrypted")).getText();
			Assert.assertEquals(actual, "Hello from Appium");
		}
	   
	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}
