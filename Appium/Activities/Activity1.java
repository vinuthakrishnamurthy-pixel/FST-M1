package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
		File testApp = new File("src/test/resources/Calculator.apk");
		//Set the desired capabilities or options
		UiAutomator2Options options = new UiAutomator2Options();	
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		//getAbsolutePath meaning - C:\Users\VinuthaK\eclipse-workspace\fst-appium\src\test\resources\Calculator.apk
		options.noReset();
		//Set the Appium server URL
		URL serverUrl = new URI("http://localhost:4723").toURL();
	
		//Initialize the object
		driver = new AndroidDriver(serverUrl, options);
	}
	
	@Test
	public void testMethod() {
		WebElement firstNum = driver.findElement(AppiumBy.id("digit_8"));
		firstNum.click();
		WebElement multiply = driver.findElement(AppiumBy.id("op_mul"));
		multiply.click();
		WebElement secondNum = driver.findElement(AppiumBy.id("digit_8"));
		secondNum.click();
		WebElement equalButton = driver.findElement(AppiumBy.accessibilityId("equals"));
		equalButton.click();
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		Assert.assertEquals(result, "64");	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
