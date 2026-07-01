package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {

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
        // Apply Leave
        WebElement applyLeave = driver.findElement(By.xpath("//table//tr/td[4]/div/a/span"));
        applyLeave.click();
        // Leave Type
        WebElement dropdownElement = driver.findElement(By.id("applyleave_txtLeaveType"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Holiday");
        // Dates
        WebElement fromDateInput = driver.findElement(By.id("applyleave_txtFromDate"));
        fromDateInput.clear();
        fromDateInput.sendKeys("2026-07-10");
        WebElement toDateInput = driver.findElement(By.id("applyleave_txtToDate"));
        toDateInput.clear();
        toDateInput.sendKeys("2026-07-10");
        WebElement comment = driver.findElement(By.id("applyleave_txtComment"));
        comment.sendKeys("Vinutha Leave");
        WebElement applyLeaveSave = driver.findElement(By.id("applyBtn"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        applyLeaveSave.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Record Saved!");

        // Navigate to My Leave List
        WebElement leaveList = driver.findElement(By.id("menu_leave_viewMyLeaveList"));
        leaveList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       //Search
        WebElement fromInput = driver.findElement(By.id("calFromDate"));
        fromInput.clear();
        fromInput.sendKeys("2026-07-10");
        WebElement toInput = driver.findElement(By.id("calToDate"));
        toInput.clear();
        toInput.sendKeys("2026-07-10");
        WebElement search = driver.findElement(By.id("btnSearch"));
        search.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get Status
        WebElement status = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[3]/table/tbody/tr[2]/td[6]"));
        System.out.println("Status is: " + status.getText());
    }

    @AfterClass
    public void tearDown() {
        // close
        driver.quit();
    }
}
