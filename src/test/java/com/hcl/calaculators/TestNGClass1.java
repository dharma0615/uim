package com.hcl.calaculators;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;


public class TestNGClass1 {
	
	@Test(priority=1, groups= {"smoke","sanity"}, dependsOnMethods="Test1")
	public void Test2() {
		System.out.println("Test2 method");
		Assert.assertTrue(true, "Assert Method is true");
		Assert.assertEquals("Dharma", "ss", "name is mismtaching");
	}

	@Test(priority=2, groups= {"regression"}, enabled=true)
	public void Test1() {
		System.out.println("Test1 method");
	}
	
	@Test(priority=3, groups= {"sanity"}, invocationCount=10)
	public void Test3() {
		System.out.println("Test3 method");
	}
	
	@Test (threadPoolSize=3, groups="threadTest", invocationCount=1, timeOut=5000)
	public void flat401() throws InterruptedException {
		System.out.println("threadPoolSize method" + Thread.currentThread().getName());
		Thread.sleep(2000);
		System.out.println(1/0);
	}
	
	@Parameters("browser")
	@Test(groups= {"regression"})
	public void browserTest(String browserName) {
		System.out.println(browserName);
		Assert.assertTrue(true, "Assert Method is true");
		
	}
	
	@Test(expectedExceptions=NullPointerException.class)
	public void TestException() {
		String name=null;
		System.out.println(name.length());
	}
	
	@Test
    public void testSoftAssert() {
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Checking first assertion...");
        softAssert.assertEquals(10, 20, "First assertion failed!");

        System.out.println("Checking second assertion...");
        softAssert.assertTrue(false, "Second assertion failed!");

        System.out.println("Execution continues despite failures...");

        // Must call this at the end to validate soft assertions
        softAssert.assertAll();
    }

}
