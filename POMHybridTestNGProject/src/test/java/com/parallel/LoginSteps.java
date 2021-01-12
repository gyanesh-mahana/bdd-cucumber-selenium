package com.parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utility.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	private static String title;

	@Given("user is on login page")
	public void user_is_on_login_page() {

		System.out.println("Step: On Login Page");
		DriverFactory.getDriver().get(Constants.loginURL);
		String currentURL = DriverFactory.getDriver().getCurrentUrl();
		Assert.assertEquals(Constants.loginURL, currentURL);

	}

	@When("user gets the title of the login page")
	public void user_gets_the_title_of_the_login_page() {

		System.out.println("Step: User gets the Title of Login Page");
		title = loginPage.getPageTitle();

	}

	@When("user type {string} in email textbox")
	public void user_type_in_email_textbox(String userId) {

		System.out.println("Step: User Enters User ID: " + userId);
		loginPage.enterUserId(userId);
	}

	@When("user type {string} in password textbox")
	public void user_type_in_password_textbox(String passwd) {

		System.out.println("Step: User Enters Password: " + passwd);
		loginPage.enterPasswd(passwd);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {

		System.out.println("Step: User Clicks on Login Button");
		loginPage.clickLoginBtn();
	}

	@Then("title should be {string}")
	public void title_should_be(String expectedTitle) {

		System.out.println("Step: Title should be: " + expectedTitle);
		Assert.assertEquals(title, expectedTitle);
	}

	@Then("Forgot your password? link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {

		System.out.println("Step: Forgot your password? link should be displayed");
		Assert.assertTrue(loginPage.isDisplayedForgotPasswd());
	}

	@Then("user gets the title of the account page")
	public void user_gets_the_title_of_the_account_page() {

		System.out.println("Step: User gets the Title of the Account page");
		title = loginPage.getPageTitle();
	}

	@Then("user gets error message")
	public void user_gets_error_message() {
		System.out.println("Step: User gets Error message");
		Assert.assertTrue(loginPage.isDisplayedErrorMsg());
	}

}
