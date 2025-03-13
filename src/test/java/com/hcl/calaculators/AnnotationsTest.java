package com.hcl.calaculators;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AnnotationsTest {
	
	@BeforeTest
    public void init(){
        System.out.println("---------------- Before Test ------------- ");
        //open the browser
    }
 
    @AfterTest
    public void quit(){
        System.out.println("---------------- After Test ------------- ");
        //close the browser
    }
 
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("############# Before Method ############# ");
        //Initialize the Report
    }
 
    @AfterMethod
    public void afterMethod() {
        System.out.println("############ After Method ##############");
        //Finalize the Report
    }
 
    @BeforeClass
    public void beforeClass() {
        System.out.println("************* Before Class *************");
    }
 
    @AfterClass
    public void afterClass() {
        System.out.println("************* After Class ***************");
    }
 
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This will execute Before Suite");
    }
 
    @AfterSuite
    public void afterSuite() {
        System.out.println("This will execute After Suite");
    }
 
    @Test
    public void loginTest(){
        System.out.println("Login the application ");
 
    }
 
    @Ignore
    @Test
    public void logout(){
        System.out.println("Logout the application ");
 
    }
    
    @Test (enabled = false)
    @Parameters("browser")
    public void Testproj(String browser) {
    	System.out.println("--------"+browser+"------------");
    	
    }
 
    @Test (dependsOnMethods ="Testproj")
    @Parameters("browser")
    public void Testproj2(String browser) {
    	System.out.println("--------"+browser+"------------");
    	
    }

}
