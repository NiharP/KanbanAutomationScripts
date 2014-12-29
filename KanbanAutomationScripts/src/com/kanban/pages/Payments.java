package com.kanban.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.kanban.utils.WebDriverWaitUtil;

public class Payments extends LoadableComponent<Payments> {

	private WebDriver driver = null;

	By address = By.id("address1");
	By btnPayNow = By.id("payNowButton");

	@Override
	protected void isLoaded() throws Error {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, address, 10);
		Assert.assertEquals(driver.getTitle(), "CPSR");
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

	public Payments(WebDriver driver) {
		this.driver = driver;
	}

	public void chooseTheAddrs() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, address, 10);
		driver.findElement(address).click();
		driver.findElement(btnPayNow).click();
	}
}
