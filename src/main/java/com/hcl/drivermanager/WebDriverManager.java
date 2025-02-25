package com.hcl.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

	private static WebDriver driverInstance=null;

	private WebDriverManager() {

	}

	public static WebDriver getInstance() {

		if (driverInstance == null) {
			System.out.println("WebDriver initilizing....");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driverInstance = new ChromeDriver();

		} else {
			return driverInstance;
		}

		return driverInstance;

	}
	
	public static void quitDriver() {
		if(driverInstance!=null) {
			driverInstance.quit();
			driverInstance=null;
			
		}
	}

}
