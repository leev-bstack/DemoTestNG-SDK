package org.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
    public void searchDataCenters(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //go to browserstack
        driver.get("https://browserstack.com/");
        //search for data centers
        driver.findElement(By.xpath("//li[@class='hide-sm hide-xs']")).click();
        driver.findElement(By.name("query")).sendKeys("Data Centers");
        driver.findElement(By.cssSelector(".ds__input__handle--submit")).click();
        //click on the correct result
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='https://www.browserstack.com/data-centers']")));
        result.click();
        //switch window
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //verify page title
        wait.until(ExpectedConditions.titleIs("Global Data Centers | BrowserStack"));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}


