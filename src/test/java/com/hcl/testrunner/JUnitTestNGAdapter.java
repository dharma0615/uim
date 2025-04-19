package com.hcl.testrunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.testng.annotations.Test;


public class JUnitTestNGAdapter {
	
	@Test
    public void runCucumberWithJUnit() {
        Result result = JUnitCore.runClasses(LoginPageTestrunnerAutomationExercise.class);
        
        for (Failure failure : result.getFailures()) {
            System.out.println("Test Failed: " + failure.toString());
        }
        
        System.out.println("Tests successful: " + result.wasSuccessful());
    }

}


