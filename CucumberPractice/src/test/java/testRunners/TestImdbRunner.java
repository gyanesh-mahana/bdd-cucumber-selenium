package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		// path to feature files
		features = { "src/test/resources/imdbFeature" },
		// path to implementation of feature
		// path to implementation of hooks
		glue = { 
				"stepDefinitions", 
				"setup" },
		// name of plug-ins
		// path for report generation
		plugin = { 
				"pretty", 
				"json:target/my-reports/imdbReport.json", 
				"junit:target/my-reports/imdbReport.xml",
				"html:target/my-reports/imdbReport.html"},
		// color output
		monochrome = false,
		// tags to execute
		// Set algebra is used in and/or/not
		tags = "@FailureScenario and @Regression",
//		tags = "@AllScenario",
		// publishing report on cucumber cloud
		publish = true)

public class TestImdbRunner {

}
