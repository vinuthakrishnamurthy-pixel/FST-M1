package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {

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
		//Find and print all the cell values in the third row of the table.
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[3]/td"));
        System.out.println("Third row values are: ");
        for(WebElement cell : thirdRow) {
            System.out.println(cell.getText());
        }
		//Find and print the cell value at the second row second column.
        WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row and column value is: " + cellValue.getText());
		//Close the browser.
		driver.quit();
	}

}
