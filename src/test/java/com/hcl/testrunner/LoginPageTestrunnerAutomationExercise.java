package com.hcl.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features/LoginPageFeatureAutomationExercise.feature",
		glue= {"com.hcl.stepdefinitions", "com.hcl.hooks"},
		dryRun=false,
		plugin={"pretty", "html:target/test-output/cucumber-report.html"},
		monochrome=false,
		tags=("@webtable")
		)
public class LoginPageTestrunnerAutomationExercise {

}
