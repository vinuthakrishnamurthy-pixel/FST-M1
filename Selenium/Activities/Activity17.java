package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		//Open a new browser
		driver.get("https://training-support.net/webelements/selects");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//dropdown
		WebElement dropdown = driver.findElement(By.cssSelector("select.h-80"));
		Select select = new Select(dropdown);
		//Select the "HTML" option using the visible text.
		select.selectByVisibleText("HTML");
		//Select the 4th, 5th and 6th options using the index.
		for (int i = 3; i <= 5; i++) {
            select.selectByIndex(i);
        }
		//Select the "Node" option using the value.
		select.selectByValue("nodejs");
		//Print
		List<WebElement> options = select.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
		//Deselect the 5th option using index.
        select.deselectByIndex(4);
        //print
        options = select.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for (WebElement option : options) {
        System.out.println(option.getText());
        }
		//Close Browser
		driver.quit();
	}

}
