package project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Open browser
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://hrm.alchemy.hguy.co");
    }

    @Test
    public void login() {
        // userName
        WebElement UserName = driver.findElement(By.id("txtUsername"));
        UserName.sendKeys("orange");
        // password
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("5Nx#I6BK%r3$8vz0ch");
        // Click login button
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        // Verify homePage opened
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String URL = driver.getCurrentUrl();
        System.out.println("Login Success. New page URL is: " + URL);
        // Navigate to My Info
        WebElement myInfoClick = driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)"));
        myInfoClick.click();
        System.out.println("Navigated to My Info page. Current URL: " + driver.getCurrentUrl());
        // Navigate to Emergency Contacts
        WebElement ecClick = driver.findElement(By.cssSelector("#sidenav > li:nth-child(3) > a:nth-child(1)"));
        ecClick.click();
        System.out.println("Navigated to Emergency Contacts page. Current URL: " + driver.getCurrentUrl());
        // Locate the main table element
        WebElement ecTable = driver.findElement(By.id("emgcontact_list"));
        List<WebElement> rows = ecTable.findElements(By.tagName("tr"));
        for (int r = 0; r < rows.size(); r++) {
            if (r == 0) {
                // Print header row once
                List<WebElement> headers = rows.get(r).findElements(By.tagName("th"));
                for (WebElement header : headers) {
                    System.out.print(header.getText() + " ");
                }
                System.out.println();
                System.out.println("____________________________________");
            } else {
                // Print each data row scoped to the current row only
                List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));
                for (WebElement cell : columns) {
                    System.out.print(cell.getText() + " ");
                }
                System.out.println();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        // close
        driver.quit();
    }
}
