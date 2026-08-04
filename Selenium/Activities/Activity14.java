package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		//Open a new browser
		driver.get("https://training-support.net/webelements/tables");
		//Print the title of the page
		String Title = driver.getTitle();
		System.out.println("Page Title is: "+ Title);
		//Find the number of rows and columns in the table and print them.
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
        System.out.println("Number of rows is: " + rows.size());
        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[1]/td"));
        System.out.println("Number of columns is: " + cols.size());
		//Find and print the Book Name in the 5th row.
        WebElement cellValue1 = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
        System.out.println("Fifth row and column value is: " + cellValue1.getText());
        //Click the header of the Price column to sort it in ascending order.
        driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th[5]")).click();
        System.out.println("Sorting completed.");
        //Find and print the Book Name in the 5th row again.
        WebElement cellValue2 = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
        System.out.println("Sorted Fifth row and column value is: " + cellValue2.getText());
		//Close the browser.
		driver.quit();
	}

}
