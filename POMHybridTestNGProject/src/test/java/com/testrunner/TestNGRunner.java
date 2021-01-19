package com.testrunner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/com/features", 
		glue = { "com.parallel" }, 
		plugin = {
				"pretty", 
				// for extent reports
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				// for tracking threads
				"timeline:test-output-thread/",
				// plugin for failure scenario rerun
				"rerun:target/fauiledrerun.txt"
				}
//		tags = "@critical"
		)


public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
