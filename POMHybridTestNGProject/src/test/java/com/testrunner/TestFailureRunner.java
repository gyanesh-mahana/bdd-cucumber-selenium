package com.testrunner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		// feature path is the text file generated by original testrunner
		// which contain details of failed scenarios
		features = "@target/failedrerun.txt", 
		glue = { "com.parallel" }, 
		plugin = { 
				"pretty",
				// for extent reports
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				// for tracking threads
				"timeline:test-output-thread/",
				// plugin for failure scenario rerun
				"rerun:target/fauiledrerun.txt" 
				})

public class TestFailureRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
