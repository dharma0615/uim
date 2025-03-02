package com.hcl.calaculators;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MobileCalaculator {
	int val1 = 10;
	int val2 = 20;

	String className = this.getClass().getSimpleName();
	
	@BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite - Runs once before all tests");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite - Runs once after all tests");
    }

	@BeforeClass
	public void beforeClass() {
		System.out.println(className+ "Before Class - Runs before test methods in this class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println(className+ "After Class - Runs after test methods in this class");
	}

	@Test(groups = {"smoke", "sanity"}, priority=1, alwaysRun=true)
	public void addition() {
		int val3 = this.val1 + this.val2;
		System.out.println("MobileCalaculator Addition: " + (val3));
		Assert.assertEquals(val3, 30);
	}

	@Test(groups = "regression", priority=2, alwaysRun=true)
	public void subtraction() {
		int val3 = this.val1 - this.val2;
		System.out.println("MobileCalaculator Subtraction: " + (val3));
		Assert.assertEquals(val3, -10);
	}

	@BeforeTest
	public void mobiCalBeforeTest() {
		System.out.println("Before Test - This is a method from the class to running before Test  " + className);
	}

	@AfterTest
	public void mobiCalAfterTest() {
		System.out.println("After Test - This is a method from the class to running after Test  " + className);
	}

	@BeforeMethod
	public void mobiCalBeforeMethod() {
		System.out.println("Before Method -This is a method from the class to running before method  " + className);
	}

	@AfterMethod
	public void mobiCalAfterMethod() {
		System.out.println("After Method - This is a method from the class to running after method  " + className);
	}

	@Test(groups = "retest", priority=0)
	public void division() {
		int val3 = this.val1 / this.val2;
		System.out.println("MobileCalaculator division: " + (val3));
		Assert.assertEquals(val3, 0);
	}

	@Test(groups = "smoke", priority=3)
	public void multiplication() {
		int val3 = this.val1 * this.val2;
		System.out.println("MobileCalaculator multiplication: " + (val3));
		Assert.assertEquals(val3, 200);
	}

}
