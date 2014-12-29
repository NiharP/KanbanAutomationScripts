package com.kanban.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.kanban.utils.PropertiesReader;
import com.kanban.utils.WebDriverWaitUtil;

public class HomePage extends LoadableComponent<HomePage> {

	private WebDriver driver;

	By MPN = By.id("msisdn");
	By portalID = By.id("portalid");
	By function = By.id("fun");
	By searchBtn = By.id("searchBtn");
	By newCustConn = By.xpath("//div[@id='acquisition']/p/a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getTitle(), "Agent Upgrade Shop - Home Page");
	}

	@Override
	protected void load() {
		driver.get(PropertiesReader.getProperty("config","url"));
		//driver.get("http://ecom-dev-demo00.obnubilate.co.uk:8080/agent/app/home?PartnerId=o2");
	}

	public NewConnectionPage clickOnNewCustomerConnectionLink() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, newCustConn, 10);
		driver.findElement(newCustConn).click();
		return new NewConnectionPage(driver);
	}
}
