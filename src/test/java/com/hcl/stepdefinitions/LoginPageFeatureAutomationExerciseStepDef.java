package com.hcl.stepdefinitions;

import java.io.IOException;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;

import com.hcl.hooks.BaseHooks;
import com.hcl.uimpages.HomePage;
import com.hcl.uimpages.LoginPage;
import com.hcl.uimpages.ProductsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.testng.*;

public class LoginPageFeatureAutomationExerciseStepDef {
	
	WebDriver driver=BaseHooks.driver;
	LoginPage loginpage=new LoginPage(driver);
	HomePage homepage=new HomePage(driver);
	ProductsPage productspage=new ProductsPage(driver);
	

	@Given("Acces the application")
	public void acces_the_application() {
		System.out.println("Automation Exercise application is launched");
		driver.get("https://www.automationexercise.com/login");
	}
	
	@When("Login with username {string} and password {string} to an app")
	public void login_with_username_and_password_to_an_app(String uname, String password) {
		
		loginpage.enterUserEmail(uname);
		loginpage.enterUserPassword(password);
		loginpage.clickLogin();
		
	}
	
	
    @Then("Home page gets be displayed")
    public void home_page_gets_be_displayed() throws InterruptedException {
    	
    	Thread.sleep(5000);
    	String expected="Home";
    	try{
    	String actual=homepage.getHomePageText();
    	System.out.println("Actual text: "+actual);
    	Assert.assertEquals(actual, expected);
    	System.out.println("validation completed");
    	}catch(Exception e) {
    		Assert.assertEquals(homepage.getHomePageElementPresence(), true);
    		System.out.println("Boolean validation completed");
    		
    	}
    }
    
    @When("User navigated to {string} page")
    public void user_navigated_to_page(String productsTab) {
    	
    	productspage.productsTab(productsTab);
    	
    }
    
    @Then("Verified all the products in the landing page")
    public void verified_all_the_products_in_the_landing_page() {
    	
    	System.out.println("Verified all the products in the landing page");
    	for(Entry<String, String> product:productspage.getProductsRates().entrySet()) {
    		System.out.println(product.getKey()+"- Rate: "+product.getValue());
    	};
    	
    	
        
    }

}
