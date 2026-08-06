package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	AppiumDriver driver;
	WebDriverWait wait;
	
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		//Set the desired capabilities or options
		UiAutomator2Options options = new UiAutomator2Options();	
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		//Set the Appium server URL
		URL serverUrl = new URI("http://localhost:4723").toURL();
		options.noReset();
		//Initialize the object
		driver = new AndroidDriver(serverUrl, options);
		driver.get("https://training-support.net");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void testMethod() {
        String heading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
        System.out.println("Heading: " + heading);
        WebElement aboutUs = driver.findElement(AppiumBy.accessibilityId("About Us"));
        aboutUs.click();
        String headingAboutUs = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
        System.out.println(headingAboutUs);	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
