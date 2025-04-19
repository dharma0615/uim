package com.hcl.logintests;

import org.testng.annotations.Test;

import com.hcl.hooks.BaseTest;
import com.hcl.uimpages.LoginPage;

public class LoginAutomationExercise extends BaseTest {
	
	@Test
	public void loginTest() {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserEmail("ramsethu@gmail.com");
		loginpage.enterUserPassword("ramsethu123");
		loginpage.clickLogin();
		
	}

}
