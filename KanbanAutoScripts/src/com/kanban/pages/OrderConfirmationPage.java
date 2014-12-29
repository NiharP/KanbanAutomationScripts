package com.kanban.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.kanban.utils.WebDriverWaitUtil;

public class OrderConfirmationPage extends
		LoadableComponent<OrderConfirmationPage> {

	private WebDriver driver = null;

	By orderNumber = By.className("orderNumber");
	By ccaGeneratedLink = By.xpath("//span[@id='ccaId']//a");
	By btnContinueDelilvery = By.id("btn-continue");
	By linkBackToDelivery = By.id("back-to-delivery");
	By btnContinuePayment = By
			.xpath("//button[@id='btnPayNow' and @class='button primary']");
	By btnKeyInfoSectionRead = By.xpath("//li[@id='keyInfoSection']//button");
	By btnSECCISectionRead = By.xpath("//li[@id='secciSection']//button");
	By btnAcceptAgreeNContinue = By
			.xpath("//li[@id='payMonthlySection']//button");
	By chkbxTermsNConditions = By.id("terms-declaration");
	By btnAcceptAgreeNContinue2 = By.xpath("//li[@id='ccaSection']//button");
	By chkbxTermsConditionsReview = By.id("terms");
	By btnPlaceOrder = By.id("order-review-continue");
	By textOrderId = By.id("order-id");
	By paymentFrame = By.id("payment-iframe");

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	protected void isLoaded() throws Error {

	}

	@Override
	protected void load() {
	}

	public void getOrderNumber() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, orderNumber, 10);
		System.out.println("Order Number: "
				+ driver.findElement(orderNumber).getText());
	}

	public void placeCCAOrder() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, ccaGeneratedLink,
				10);
		String navigationLink = driver.findElement(ccaGeneratedLink).getText();
		navigationLink = navigationLink.substring(0,
				navigationLink.length() - 1);
		navigationLink = navigationLink.substring(
				navigationLink.lastIndexOf("/") + 1, navigationLink.length())
				+ "/";

		navigationLink = "https://ecom-dev-demo00.obnubilate.co.uk:9443/ssc/order/"
				+ navigationLink;
		driver.navigate().to(navigationLink);

		((JavascriptExecutor) driver).executeScript("scroll(300,0);");
		WebDriverWaitUtil.waitForElementToBeClickable(driver,
				btnContinueDelilvery, 10);
		driver.findElement(btnContinueDelilvery).click();

		WebDriverWaitUtil.waitForElementToBeClickable(driver, paymentFrame, 10);
		driver.switchTo().frame(driver.findElement(paymentFrame));
		driver.findElement(btnContinuePayment).click();

		WebDriverWaitUtil.waitForElementToBeClickable(driver,
				btnKeyInfoSectionRead, 5);
		driver.findElement(btnKeyInfoSectionRead).click();

		WebDriverWaitUtil.waitForElementToBeClickable(driver,
				btnSECCISectionRead, 5);
		driver.findElement(btnSECCISectionRead).click();

		WebDriverWaitUtil.waitForElementToBeClickable(driver,
				btnAcceptAgreeNContinue, 5);
		driver.findElement(btnAcceptAgreeNContinue).click();

		WebDriverWaitUtil.waitForElementToBeClickable(driver,
				chkbxTermsNConditions, 5);
		driver.findElement(chkbxTermsNConditions).click();
		driver.findElement(btnAcceptAgreeNContinue2).click();

		WebDriverWaitUtil.waitForElementToBeClickable(driver,
				chkbxTermsConditionsReview, 5);
		driver.findElement(chkbxTermsConditionsReview).click();
		driver.findElement(btnPlaceOrder).click();

		try {
			WebDriverWaitUtil.waitForElementToBeClickable(driver, textOrderId,
					5);
			System.out.println("Order Number: "
					+ driver.findElement(textOrderId).getText());
		} catch (Exception exception) {
			System.out
					.println("Found - There has been some issue with the system.");
		}
	}
}
