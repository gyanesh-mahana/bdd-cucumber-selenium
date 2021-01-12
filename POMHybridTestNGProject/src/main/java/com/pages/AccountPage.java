package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import com.qa.utility.ElementUtil;

public class AccountPage {

	private WebDriver driver;
//	private WebElement ele;
//	private ElementUtil eleUtil;

	// 1. By Locators:
	private By orderHistoryAndDetails = By.xpath("//span[text()='Order history and details']");
	private By myCreditSlips = By.xpath("//span[text()='My credit slips']");
	private By myAddresses = By.xpath("//span[text()='My addresses']");
	private By myPersonalInfo = By.xpath("//span[text()='My personal information']");
	private By myWishlists = By.xpath("//span[text()='My wishlists']");
//	private By accountDetails = By.cssSelector("div.row.addresses-list");
	private By accountDetails = By.xpath("//ul[@class='myaccount-link-list']//span");

	// 2. Constructor of the LoginPage
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page actions
	public String getPageTitle() {
		return driver.getTitle();
	}

	public List<String> getDetails() {
		List<String> details = new ArrayList<String>();
		List<WebElement> listDetails = driver.findElements(accountDetails);
		for (WebElement ele : listDetails) {
			System.out.println(ele.getText());
			details.add(ele.getText());
		}

		return details;
	}

	public String getOrderHIstoryAndDetails() {
		return driver.findElement(orderHistoryAndDetails).getText();
	}

	public String getMyCreditSlips() {
		return driver.findElement(myCreditSlips).getText();
	}

	public String getMyAddresses() {
		return driver.findElement(myAddresses).getText();
	}

	public String getMyPersonalInfo() {
		return driver.findElement(myPersonalInfo).getText();
	}

	public String getMyWishlists() {
		return driver.findElement(myWishlists).getText();
	}

}
