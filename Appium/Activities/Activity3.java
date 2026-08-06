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

public class Activity3 {
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
	
	//Calculate 5 + 9 and print the result to the console.
	@Test
	public void testMethod1() {
		WebElement firstNum = driver.findElement(AppiumBy.id("digit_5"));
		firstNum.click();
		WebElement add = driver.findElement(AppiumBy.id("op_add"));
		add.click();
		WebElement secondNum = driver.findElement(AppiumBy.id("digit_9"));
		secondNum.click();
		WebElement equalButton = driver.findElement(AppiumBy.accessibilityId("equals"));
		equalButton.click();
		String resultadd = driver.findElement(AppiumBy.id("result_final")).getText();
		System.out.println("Addition Result: "+ resultadd);
		Assert.assertEquals(resultadd, "14");	
	}
	
	//Calculate 10 - 5 and print the result to the console.
	@Test
	public void testMethod2() {
		WebElement firstNum1 = driver.findElement(AppiumBy.id("digit_1"));
		firstNum1.click();
		WebElement firstNum2 = driver.findElement(AppiumBy.id("digit_0"));
		firstNum2.click();
		WebElement minus = driver.findElement(AppiumBy.id("op_sub"));
		minus.click();
		WebElement secondNum = driver.findElement(AppiumBy.id("digit_5"));
		secondNum.click();
		WebElement equalButton = driver.findElement(AppiumBy.accessibilityId("equals"));
		equalButton.click();
		String resultminus = driver.findElement(AppiumBy.id("result_final")).getText();
		System.out.println("Subtraction Result: " + resultminus);
		Assert.assertEquals(resultminus, "5");	
	}
	
	//Calculate 5 * 100 and print the result to the console.
		@Test
		public void testMethod3() {
			WebElement firstNumMul = driver.findElement(AppiumBy.id("digit_5"));
			firstNumMul.click();
			WebElement multiply = driver.findElement(AppiumBy.id("op_mul"));
			multiply.click();
			WebElement secondNumMul1 = driver.findElement(AppiumBy.id("digit_1"));
			secondNumMul1.click();
			WebElement secondNumMul2 = driver.findElement(AppiumBy.id("digit_0"));
			secondNumMul2.click();
			WebElement secondNumMul3 = driver.findElement(AppiumBy.id("digit_0"));
			secondNumMul3.click();
			WebElement equalButton = driver.findElement(AppiumBy.accessibilityId("equals"));
			equalButton.click();
			String resultmultiply = driver.findElement(AppiumBy.id("result_final")).getText();
			System.out.println("Multiplication Result: " + resultmultiply);
			Assert.assertEquals(resultmultiply, "500");	
		}
		
		//Calculate 50 / 2 and print the result to the console.
				@Test
				public void testMethod4() {
					WebElement firstNumDiv1 = driver.findElement(AppiumBy.id("digit_5"));
					firstNumDiv1.click();
					WebElement firstNumDiv2 = driver.findElement(AppiumBy.id("digit_0"));
					firstNumDiv2.click();
					WebElement divide = driver.findElement(AppiumBy.id("op_div"));
					divide.click();
					WebElement secondNumDiv = driver.findElement(AppiumBy.id("digit_2"));
					secondNumDiv.click();
					WebElement equalButton = driver.findElement(AppiumBy.accessibilityId("equals"));
					equalButton.click();
					String resultdivision = driver.findElement(AppiumBy.id("result_final")).getText();
					System.out.println("Division Result: " + resultdivision);
					Assert.assertEquals(resultdivision, "25");	
				}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}



