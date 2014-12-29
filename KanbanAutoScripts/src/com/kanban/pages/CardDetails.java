package com.kanban.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.kanban.beans.Card;
import com.kanban.utils.WebDriverWaitUtil;

public class CardDetails extends LoadableComponent<CardDetails> {
	private WebDriver driver = null;

	By cardName = By.id("cardName");
	By cardType = By.id("cardType");
	By cardNumber = By.id("cardNumber");
	By expiryMonth = By.id("expiryDay");
	By expiryYear = By.id("expiryMonth");
	By securityNumber = By.id("cvvNumber");

	By selectAddr = By.id("address1");
	By btnCheckNow = By.id("checkNowButton");

	public CardDetails(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getTitle(), "Agent Upgrade Shop - Shopping");
	}

	@Override
	protected void load() {

	}

	public void populateCardDetailsOnScreen() {
		Card card = new Card();
		WebDriverWaitUtil.waitForElementToBeClickable(driver, cardName, 15);
		driver.findElement(cardName).sendKeys(card.getNameOnCard());
		new Select(driver.findElement(cardType)).selectByVisibleText(card.getTypeOfCard());
		driver.findElement(cardNumber).sendKeys(card.getCardNumber());
		new Select(driver.findElement(expiryMonth)).selectByVisibleText(card.getExpiryMonth());
		new Select(driver.findElement(expiryYear)).selectByVisibleText(card.getExpiryYear());
		driver.findElement(securityNumber).sendKeys(card.getSecurityNumber());
	}
	
	public void selectAddressAndSubmit() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, selectAddr, 5);
		driver.findElement(selectAddr).click();
		driver.findElement(btnCheckNow).click();
	}
}
