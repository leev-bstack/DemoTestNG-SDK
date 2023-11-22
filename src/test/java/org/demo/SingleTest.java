package org.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class SingleTest
{
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod

    public void startDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void searchesGoogle(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //go to Google
        driver.get("https://www.google.com");
        //search for Browserstack
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        search.sendKeys("Browserstack");
        search.sendKeys(Keys.RETURN);
        //click on the correct result
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='https://www.browserstack.com/']/div")));
        result.click();
        //verify page title
        wait.until(ExpectedConditions.titleIs("Most Reliable App & Cross Browser Testing Platform | BrowserStack"));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}


