package com.hcl.logintests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hcl.drivermanager.WebDriverManager;

public class WebLoginTest {

	WebDriver driver = WebDriverManager.getInstance();

	@Test(priority=1)
	public void launchApp() {

		driver.get("https://www.facebook.com/login/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority=2)
	public void doActions() {

		System.out.println("WebLoginTest Printing...");

	}

	@Test(priority=3)
	public void closeTest() {
		WebDriverManager.quitDriver();
	}
	
	@Test
	public void taskScreesnhotTest() {
		WebDriver driver=new ChromeDriver();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceFile= ts.getScreenshotAs(OutputType.FILE);
		
	}

}
