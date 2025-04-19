package com.hcl.logintests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	WebDriver driver;
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@Test
	public void Test1() {
		 driver=new ChromeDriver();
		 Dimension dimension=new Dimension(1500, 1800);
		 driver.manage().window().setSize(dimension);
		 
		 driver.get(url);
		 String pageSource=driver.getPageSource();
		 System.out.println(pageSource);
		 
		 Set<String> winds=driver.getWindowHandles();
		 Iterator<String> it=winds.iterator();
		 while(it.hasNext()) {
			 System.out.println(it);
			 
		 }
		 
		 driver.close();
		 
		 }
	
	@Test
	public void Test2() {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("browserName", "Safari");
		caps.setCapability("platform", "macOS Ventura");
		caps.setCapability("browserVersion", "16.0");
		
		
		
		 try {
			driver=new RemoteWebDriver(new URL(url), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Dimension dimension=new Dimension(1500, 1800);
		 driver.manage().window().setSize(dimension);
		 
		 driver.get(url);
		 String pageSource=driver.getPageSource();
		 System.out.println(pageSource);
		 
		 Set<String> winds=driver.getWindowHandles();
		 Iterator<String> it=winds.iterator();
		 while(it.hasNext()) {
			 System.out.println(it);
			 
		 }
		 
		 driver.close();
		 
		 }
	

}
