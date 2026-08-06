package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity4 {
	 
	    AppiumDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setUp() throws MalformedURLException, URISyntaxException {
	        // Desired Capabilities
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setAppPackage("com.google.android.contacts");
	        options.setAppActivity("com.android.contacts.activities.PeopleActivity");
	        options.noReset();
	        URL serverUrl = new URI("http://localhost:4723").toURL();
	        driver = new AndroidDriver(serverUrl, options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    // Test method
	    @Test
	    public void contactsTest() {
	        //add button and Wait
	        driver.findElement(AppiumBy.accessibilityId("Phone")).click();
	        driver.findElement(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.dialer:id/call_log_recycler_view\"]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.widget.Button\r\n")).click();
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button")));
	        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();	
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));

	        // Enter the details and Save
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"+1\"]/android.view.View[2]")).clear();
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"+1\"]/android.view.View[2]")).sendKeys("999148292");
	        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button")).click();
			
	        
	        // Wait for contact to save
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.contacts:id/large_title\"]")));

	        // Assert
	        String contactName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.contacts:id/large_title\"]")).getText();
	        Assert.assertEquals(contactName, "Aaditya Varma");
	    }

	   
	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}