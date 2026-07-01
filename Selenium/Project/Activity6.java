package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {

    WebDriver driver;
    WebDriverWait wait; 

    @BeforeClass
    public void setup() {
        // Open browser
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://hrm.alchemy.hguy.co");
    }

    @Test
    public void login() {
        // userName
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("orange");
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
        // Directory menu visible
        WebElement directoryMenu = driver.findElement(By.cssSelector("#menu_directory_viewDirectory > b:nth-child(1)"));
        System.out.println("Directory Menu is visible: " + directoryMenu.isDisplayed());
        System.out.println("Directory Menu is enabled: " + directoryMenu.isEnabled());
        directoryMenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Header Validation
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Search Directory']")));
        Assert.assertEquals(heading.getText(), "Search Directory", "Incorrect page heading.");
    }

    @AfterClass
    public void tearDown() {
        // close
        driver.quit();
    }
}
