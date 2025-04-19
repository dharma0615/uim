package com.hcl.uimpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[normalize-space(text())='Home']")
	private WebElement homePage;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageText() {
		
		return homePage.getText();
	}

	public boolean getHomePageElementPresence() {
		
		return homePage.isDisplayed();
	}
}
