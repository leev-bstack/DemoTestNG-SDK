package org.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ParallelTest
{
    public WebDriver driver;

    @BeforeMethod
    public void startDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void Test1() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://google.com/");
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        search.sendKeys("BrowserStack", Keys.ENTER);
        String title = driver.getTitle();
        Assert.assertEquals(title, title);

    }
    @Test
    public void Test2() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://bstackdemo.com/");
        wait.until(ExpectedConditions.titleIs("StackDemo"));
    }
    @Test
    public void Test3() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://browserstack.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}

