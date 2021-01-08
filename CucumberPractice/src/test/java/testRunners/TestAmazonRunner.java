package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

//@CucumberOptions(
//		features = { "src/test/resources/amazonFeature" }, 
//		glue = { "stepDefinitions" }, 
//		plugin = { "pretty" })

@CucumberOptions(
		// path to feature files
		features = { "src/test/resources/amazonFeature" },
		// path to implementation of feature
		// path to implementation of hooks
		glue = { "stepDefinitions" },
		// name of plug-ins
		// path for report generation
		plugin = { 
				"pretty", 
				"json:target/my-reports/amazonReport.json", 
				"junit:target/my-reports/amazonReport.xml",
				"html:target/my-reports/amazonReport.html" },
		// color output
		monochrome = true,
		// tags to execute
		// publishing report on cucumber cloud
		publish = true)
//	We use the name AmazonTest/TestAmazonRunner/RunnerAmazonTest 
//	Otherwise Test information while running test script does not show properly
//	Because Junit recognizes file with name Test in the beginning or end
public class TestAmazonRunner {

}
