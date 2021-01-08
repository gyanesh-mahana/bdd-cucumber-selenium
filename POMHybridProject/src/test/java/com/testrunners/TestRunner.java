package com.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/com/features", 
		glue = { "com.stepdefinitions", "com.hooks" }, 
		plugin = {
				"pretty", 
				"junit:target/pomhybridreports/Report.xml", 
				"html:target/pomhybridreports/Report.html",
				"json:target/pomhybridreports/Report.json",

				// for extent reports
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				// for tracking threads
				"timeline:test-output-thread/" }, 
		tags = "@login")

public class TestRunner {

}
