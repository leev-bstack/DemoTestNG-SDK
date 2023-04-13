package org.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Local
{
    public WebDriver driver;

    @BeforeMethod
    public void startDriver(){
        driver = new ChromeDriver();
    }


    @Test
    public void testLocal() throws Exception {
        driver.get("http://bs-local.com:45454/");

        Assert.assertTrue(driver.getTitle().contains("BrowserStack Local"));
    }


    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}

