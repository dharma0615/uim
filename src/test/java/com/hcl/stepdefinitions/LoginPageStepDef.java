package com.hcl.stepdefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {

	@Given("Open the Application")
	public void Open_the_Application() {

		System.out.println("Open the Application");

	}

	@When("Login with username {string} and password {string}")
	public void Login_with_username_and_password(String username, String password) {

		System.out.println("Login with username " + username + "and password " + password);

	}

	@Then("Home page will be displayed")
	public void Home_page_will_be_displayed() {
		System.out.println("Home page will be displayed");
		System.out.println("=====================================================");

	}
	
	@When("Login with username {string} and password {string} with valid data")
	public void Login_with_username_and_password_with_valid_data(String uname, String pword) {
		System.out.println("Login with username and password with valid data "+ uname +"=="+ pword);
	}
	
	@When("Login with username and password")
	public void Login_with_username_and_password(DataTable dataTable) {
		List<Map<String, String>> data=dataTable.asMaps(String.class, String.class);
		for(Map<String, String> user:data) {
		System.out.println("Login with username and password with datatable data "+ user.get("username")+"==="+user.get("password"));
		}
	}
	
	
	
	@When("Login with username and password wo headers")
	public void Login_with_username_and_password_wo_headers(DataTable dataTable) {
		List<List<String>> data=dataTable.asLists(String.class);
		for(List<String> user:data) {
			
		System.out.println("Login with username and password with datatable data wo headers "+ user.get(0)+"==="+user.get(1));
		}
	}
	
	@Given("Open a browser to access the application")
	public void Open_a_browser_to_access_the_application() {
		System.out.println("Open a browser to access the application");
		System.out.println("-----------------------------------------");
		
	}
	
	

}
