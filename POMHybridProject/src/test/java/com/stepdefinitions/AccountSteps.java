package com.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utility.Constants;
import com.pages.AccountPage;

public class AccountSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	private static String title;

	@Given("User is signed in with valid credentials")
	public void user_is_signed_in_with_valid_credentials(DataTable dataTable) {
		List<Map<String, String>> credential = dataTable.asMaps();
		String userId = credential.get(0).get("userId");
		String passwd = credential.get(0).get("password");
		System.out.println("Logging in with userId: " + userId + " and password: " + passwd);
		DriverFactory.getDriver().get(Constants.loginURL);
		accountPage = loginPage.doLogin(userId, passwd);

	}

	@Given("user is on account page")
	public void user_is_on_account_page() {

		String currentURL = DriverFactory.getDriver().getCurrentUrl();

		System.out.println("Step: User is on account page: " + currentURL);
		Assert.assertEquals(Constants.accountURL, currentURL);
	}

	@When("user gets the details")
	public void user_gets_the_details() {
		System.out.println("Step: User gets the details");
		accountPage.getPageTitle();
	}

	@Then("following details are displayed")
	public void following_details_are_displayed(DataTable dataTable) {
		List<String> listDetails = accountPage.getDetails();
		List<String> expListDetails = dataTable.asList();
		Assert.assertEquals("---Count Mismatch---", expListDetails.size(), listDetails.size());
		for (String detail : expListDetails) {
			System.out.println("Detail: " + detail);
			Assert.assertTrue(listDetails.contains(detail));
		}
	}

	@When("user gets the title of account page")
	public void user_gets_the_title_of_the_account_page() {

		System.out.println("Step: User gets the Title of Account Page");
		title = accountPage.getPageTitle();

	}

	@Then("account page title should be {string}")
	public void account_page_title_should_be(String expectedTitle) {

		System.out.println("Step: Title should be: " + expectedTitle);
		Assert.assertEquals(title, expectedTitle);
	}

}
