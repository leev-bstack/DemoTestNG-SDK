package org.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Fail
{
    public WebDriver driver;

    @BeforeMethod
    public void startDriver(){
        driver = new ChromeDriver();
    }


    @Test
    public void wrongTitle() throws Exception {
        driver.get("https://browserstack.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "wrong title");
    }


    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}

