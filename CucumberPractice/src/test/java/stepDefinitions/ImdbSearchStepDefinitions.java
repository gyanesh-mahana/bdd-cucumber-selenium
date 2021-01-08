package stepDefinitions;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ImdbSearchStepDefinitions {
	@Given("imdb website is opened")
	public void imdb_website_is_opened() {
		System.out.println("Step1: IMDB website is opened");
	}

	@Given("search box is present")
	public void search_box_is_present() {
		System.out.println("Step2: Search box is present");
	}

	@When("User chooses {string}")
	public void user_chooses(String filter) {
		System.out.println("Step3: User cooses option:" + filter);
	}

	@When("Types following keywords:")
	public void types_following_keywords(DataTable dataTable) {
		List<String> keywordList = dataTable.asList();
		for (String keyword : keywordList) {
			System.out.println("Step4: Type the keyword:" + keyword);
		}
	}

	@When("click on search")
	public void click_on_search() {
		System.out.println("Step5: Click on Search");
	}

	@Then("Error message is displayed")
	public void error_message_is_displayed() {
		System.out.println("Step6: Error message is displayed");
	}

	@Then("results are displayed")
	public void results_are_displayed() {
		System.out.println("Step6: Result is displayed");
	}

}
