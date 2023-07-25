package org.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelTest3
{
    public WebDriver driver;

    @BeforeMethod
    public void startDriver(){
        driver = new ChromeDriver();
    }


    @Test
    public void browserStackTitle() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://browserstack.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleIs("Most Reliable App & Cross Browser Testing Platform | BrowserStack"));
    }


    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}

