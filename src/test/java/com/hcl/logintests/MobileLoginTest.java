package com.hcl.logintests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hcl.drivermanager.WebDriverManager;

public class MobileLoginTest {

	WebDriver driver = WebDriverManager.getInstance();

	@Test(priority=1)
	public void launchApp() {

		driver.get("https://www.hyrtutorials.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority=2)
	public void doActions() {

		System.out.println("MobileLoginTest Printing...");

	}

	@Test(priority=3)
	public void closeTest() {
		WebDriverManager.quitDriver();
	}

}
