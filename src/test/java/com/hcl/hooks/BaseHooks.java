package com.hcl.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseHooks {
	public static WebDriver driver=null;
	
	@Before
	public void setUpDriver() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Driver is initialized && Browser is launched");
		
		
	}
	
	@After
	public void tearDown() {
		
		if(driver!=null) {
			driver.quit();
		}
		System.out.println("Driver session is terminated");
		
	}

}
