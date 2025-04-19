package com.hcl.logintests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	

}
