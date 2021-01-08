package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.utility.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private WebElement ele;
	private ElementUtil eleUtil;

	// 1. By Locators:
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By btnLogin = By.id("SubmitLogin");
	private By forgotPasswd = By.linkText("Forgot your password?");
	private By authFailErrorMsg = By.cssSelector("div.alert.alert-danger");

	// 2. Constructor of the LoginPage
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page actions
	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isDisplayedForgotPasswd() {
		return driver.findElement(forgotPasswd).isDisplayed();
	}

	public void enterUserId(String userId) {

		ele = driver.findElement(emailId);
		eleUtil = new ElementUtil(ele);
		eleUtil.doSendKeys(userId);
	}

	public void enterPasswd(String passwd) {

		ele = driver.findElement(password);
		eleUtil = new ElementUtil(ele);
		eleUtil.doSendKeys(passwd);
	}

	public void clickLoginBtn() {

		ele = driver.findElement(btnLogin);
		eleUtil = new ElementUtil(ele);
		eleUtil.doClick();
	}

	public boolean isDisplayedErrorMsg() {
		try {
			return driver.findElement(authFailErrorMsg).isDisplayed();
		} catch (NoSuchElementException e) {
			e.getStackTrace();
			return false;
		}
	}

	// Page chaining concept
	// if any action of method in a page changes the current page
	// then it should return the new page
	public AccountPage doLogin(String userId, String passwd) {

		driver.findElement(emailId).sendKeys(userId);
		driver.findElement(password).sendKeys(passwd);
		driver.findElement(btnLogin).click();

		return (new AccountPage(driver));

	}
}
