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

public class A11y
{
    public WebDriver driver;

    @BeforeMethod
    public void startDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void googleSearch() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://google.com/");
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        search.sendKeys("BrowserStack", Keys.ENTER);
        String title = driver.getTitle();
        Assert.assertEquals(title, title);
        Thread.sleep(3000);
    }
    @Test
    public void bStackDemo() throws Exception {
        // navigate to bstackdemo
        driver.get("https://www.bstackdemo.com");

        // Check the title
        Assert.assertTrue(driver.getTitle().matches("StackDemo"));

        // Save the text of the product for later verify
        String productOnScreenText = driver.findElement(By.xpath("//*[@id=\"1\"]/p")).getText();
        // Click on add to cart button
        driver.findElement(By.xpath("//*[@id=\"1\"]/div[4]")).click();

        // See if the cart is opened or not
        Assert.assertTrue(driver.findElement(By.cssSelector(".float\\-cart__content")).isDisplayed());

        // Check the product inside the cart is same as of the main page
        String productOnCartText = driver.findElement(By.cssSelector(".float-cart__content .title")).getText();
        Assert.assertEquals(productOnScreenText, productOnCartText);
        Thread.sleep(3000);
    }
    @Test
    public void browserStackTitle() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://browserstack.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleIs("Most Reliable App & Cross Browser Testing Platform | BrowserStack"));
        Thread.sleep(3000);
    }


    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}

