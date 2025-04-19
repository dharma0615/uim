package com.hcl.uimpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="email")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement login;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterUserEmail(String email) {
		emailAddress.sendKeys(email);
	}
	
	public void enterUserPassword(String userpassword) {
		password.sendKeys(userpassword);
	}
	
	public void clickLogin() {
		login.click();
	}

}
