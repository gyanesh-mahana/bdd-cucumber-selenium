package com.qa.utility;

import org.openqa.selenium.WebElement;

public class ElementUtil {

	private WebElement ele;

	public ElementUtil(WebElement ele) {
		this.ele = ele;
	}

	public void doClick() {
		this.ele.click();
	}

	public void doSendKeys(String keysToSend) {
		this.ele.sendKeys(keysToSend);
	}
}
