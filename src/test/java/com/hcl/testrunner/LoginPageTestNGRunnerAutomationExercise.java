package com.hcl.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/Features/LoginPageFeatureAutomationExercise.feature",
		glue= {"com.hcl.stepdefinitions", "com.hcl.hooks"},
		dryRun=false,
		plugin={"pretty", "html:target/test-output/cucumber-report.html"},
		monochrome=false,
		tags=("@webtable")
		)

public class LoginPageTestNGRunnerAutomationExercise extends AbstractTestNGCucumberTests {

}
