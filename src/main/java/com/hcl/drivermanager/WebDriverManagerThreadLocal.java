package com.hcl.drivermanager;

import org.openqa.selenium.WebDriver;

public class WebDriverManagerThreadLocal {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static WebDriverManagerThreadLocal instance=null;

	private WebDriverManagerThreadLocal() {

	}

	public static WebDriverManagerThreadLocal getInstance() {

		if (driver.get() == null) {

			System.setProperty("webdriver.chrome.driver", "/uim/src/test/resources/drivers/chromedriver.exe");
			instance = new WebDriverManagerThreadLocal();

		} else {
			return instance;
		}

		return instance;

	}
	
	public static void quitDriver() {
		WebDriver webDriver=driver.get();
		if(webDriver!=null) {
			webDriver.quit();
			driver.remove();
			
		}
	}

}
