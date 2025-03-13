package com.hcl.logintests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hcl.utilities.TestListener;

public class PageLoginTest  {
	
	@Test (groups= {"invalid"})
    public void invalidLoginTest() {
 
        System.out.println("Test Case 1 with Thread Id - "+Thread.currentThread().getId());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
//        TestListener.setDriver(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("admin123123");
        driver.findElement(By.name("password")).sendKeys("adm");
        driver.findElement(By.xpath("//*[@class='oxd-form']/div[3]/button")).click();
        String expectedError = driver.findElement(By.xpath("//*[@class='orangehrm-login-error']/div[1]/div[1]/p")).getText();
        Assert.assertTrue(expectedError.contains("Invalid credentials1"));
 
    }
 
    @Test
    public void validLoginTest() throws InterruptedException {
 
        System.out.println("Test Case 2 with Thread Id - "+Thread.currentThread().getId());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@class='oxd-form']/div[3]/button")).click();
        String expectedTitle = driver.findElement(By.xpath("//*[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
        Assert.assertTrue(expectedTitle.contains("Dashboard"));
    }
 
    @Test
    public void forgotLinkTest() {
 
        System.out.println("Test Case 3 with Thread Id - "+Thread.currentThread().getId());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 
        String expectedLink = driver.findElement(By.className("orangehrm-login-forgot-header")).getText();
        Assert.assertTrue(expectedLink.contains("Forgot your password?"));
    }
 
 
}


