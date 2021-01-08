package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

	@Given("open url {string} in browser")
	public void open_url_in_browser(String string) {
		System.out.println("Step: Open URL");
	}

	@Given("There is {string} option")
	public void there_is_option(String string) {
		System.out.println("Step: " + string + " option available");
	}

	@When("I hover over {string} option")
	public void i_hover_over_option(String string) {
		System.out.println("Step: Hover over " + string + " option");
	}

	@Then("A pop-up with {string} button is displayed")
	public void a_pop_up_with_button_is_displayed(String string) {
		System.out.println("Step: A pop-up with " + string + " button is displayed");
	}

	@When("I click on {string} button on the pop-up")
	public void i_click_on_button_on_the_pop_up(String string) {
		System.out.println("Step: click on " + string + " button on the pop-up");
	}

	@Then("{string} button is displayed")
	public void button_is_displayed(String string) {
		System.out.println("Step: " + string + " is displayed");
	}

	// using regular expression
	@When("^I type (.*) in (.*) textbox$")
	public void i_type_in_textbox(String string1, String string2) {
		System.out.println("Step: type the " + string1 + " in " + string2 + " textbox");
	}

	@When("I click on {string} button")
	public void i_click_on_button(String string) {
		System.out.println("Step: click on " + string + " button");
	}

	@Then("{string} is displayed")
	public void is_displayed(String string) {
		System.out.println("Step: " + string + " is displayed");
	}

	@Then("{string} textbox is displayed")
	public void textbox_is_displayed(String string) {
		System.out.println("Step: " + string + " textbox is displayed");
	}

	@Then("I am logged in")
	public void i_am_logged_in() {
		System.out.println("Step: I am logged in");
	}
	
	@Then("User is unable to login")
	public void user_is_unable_to_login() {
		System.out.println("Step: User is unable to login");
	}
}
