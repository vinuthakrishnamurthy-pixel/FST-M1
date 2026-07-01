package activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		//Open a new browser
		driver.get("https://training-support.net/webelements/target-practice");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is "+ Title);
		//Find the 3rd header on the page and print it's text to the console.
		String thirdHeaderText = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
        System.out.println(thirdHeaderText);
		//Find the 5th header on the page and print it's color.
        Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
        System.out.println("Color as RGB: " + fifthHeaderColor.asRgb());
        System.out.println("Color as hexcode: " + fifthHeaderColor.asHex());
		//Find the purple button and print all it's classes.
        String purpleButton = driver.findElement(By.cssSelector(" button.rounded-xl:nth-child(9)")).getDomAttribute("class");
        System.out.println(purpleButton);
      	//Find the slate button and print it's text.
        String slateButton = driver.findElement(By.cssSelector("button.rounded-xl:nth-child(12)")).getText();
        System.out.println(slateButton);	
		//Close browser
		driver.quit();

	}

}
