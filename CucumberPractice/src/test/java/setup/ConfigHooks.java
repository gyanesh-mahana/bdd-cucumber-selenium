package setup;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class ConfigHooks {

	@Before
	public void openBrowser() {
		System.out.println("Before: Opening Browser");
	}

	// In @Before order run in incrementing way
	// 0->1->2 and so on...
	@BeforeStep(order = 1)
	public void takeSnapshot() {
		System.out.println("BeforeStep: Taking snapshot");
	}

	@BeforeStep(value = "@SearchScenario", order = 0)
	public void verifyArgs(Scenario scenario) {
		System.out.println("BeforeStep: Verifying args in the scenario=" + scenario.getName());
	}

	@AfterStep("@Regression")
	public void collectLogs(Scenario scenario) {
		System.out.println("AfterStep: Collecting Logs After scenario:" + scenario.getName());

	}

	// In @After order runs in decrementing way
	// 3->2->1->0 and so on...
	@After(order = 0)
	public void sendMails() {
		System.out.println("After: Sending mails");
	}

	@After(order = 1)
	public void closeBrowser() {
		System.out.println("After: Closing Browser");
	}

}
