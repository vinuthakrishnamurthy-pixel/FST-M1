package activities;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			WebDriver driver = new FirefoxDriver();
			//Open a new browser
			driver.get("https://training-support.net/webelements/selects");
			//Print the title of the page
			String Title = driver.getTitle();
			System.out.println("Page Title is: "+ Title);
				
			//Dropdown
			WebElement dropdown = driver.findElement(By.cssSelector("select.h-10"));
			Select select = new Select(dropdown);
			//Select the second option using the visible text.
			select.selectByVisibleText("Two");
			System.out.println("Second option: " + select.getFirstSelectedOption().getText());
			//Select the third option using the index.
			select.selectByIndex(3);
			System.out.println("Third option: " + select.getFirstSelectedOption().getText());
			//Select the fourth option using the value.
			select.selectByValue("four");
			System.out.println("Forth option: " + select.getFirstSelectedOption().getText());
			//Get all the options and print them to the console.
			List<WebElement> options = select.getOptions();
			System.out.println("Options in the dropdown: ");
	        for(WebElement option : options) {
	            System.out.println(option.getText());
	        }
		 	//Close browser
			driver.quit();

	}

}
