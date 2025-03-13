package com.hcl.uim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class LoginPageTest {
	
	@Test
	void LoginPage() {
		String url="http://support.orangehrm.com/portal/en/signin";
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);

//		
//		driver.navigate().to(url);
//		driver.navigate().refresh();
//		driver.navigate().back();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // Open the OrangeHRM Support login page
	        driver.get("https://support.orangehrm.com/portal/en/signin");

	        // Locate "Home" WebElement
	        WebElement homeElement = driver.findElement(By.xpath("(//a[text()='Home'])[5]"));

	        homeElement.click();
	        // Use Relative Locator to find "Sign In" (which is to the right of "Home")
	        WebElement signInElement = driver.findElement(RelativeLocator.with(By.xpath("(//span[text()='Sign In'])[1]")).above(homeElement));

	        // Print the extracted text
	        System.out.println("Extracted Text: " + signInElement.getText());

		
		
		driver.close();
	}
	

}
