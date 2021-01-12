package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/*
	 * @method: Initialize the web driver and sets the driver with the relevant
	 * browser
	 * 
	 * @param: browser name
	 * 
	 * @return: web driver
	 */
	public WebDriver initDriver(String browser) {
		System.out.println("Browser value is:" + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Wrong browser: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
//		getDriver().manage().window().fullscreen();

		return getDriver();
	}

	/*
	 * @method: returns the same copy of threaded driver
	 * 
	 * @return: threaded copy of web driver
	 */
	public static WebDriver getDriver() {

		return tlDriver.get();
	}
}
