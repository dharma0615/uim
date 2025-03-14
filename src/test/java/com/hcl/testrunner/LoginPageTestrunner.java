package com.hcl.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue= {"com.hcl.stepdefinitions"},
		dryRun=false,
		plugin="pretty",
		monochrome=false
		)
public class LoginPageTestrunner {

}
