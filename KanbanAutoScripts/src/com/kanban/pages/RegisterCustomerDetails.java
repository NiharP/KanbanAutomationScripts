package com.kanban.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

import com.kanban.beans.Customer;
import com.kanban.utils.WebDriverWaitUtil;

public class RegisterCustomerDetails extends LoadableComponent<RegisterCustomerDetails> {
	
	private WebDriver driver = null;
	
	By nameTitle = By.id("regTitle");
	By firstName = By.id("regFirstName");
	By lastName = By.id("regLastname");
	By email = By.id("regEmail");
	By dob = By.id("regDob");
	By mobile = By.id("regMobile");
	By landline = By.id("regLandline");
	By password = By.id("regPassword");
	By confirmPswd = By.id("regConfirmPswd");
	By securityQue = By.id("securityQuestion");
	By securityAns = By.id("securityAnswer");
	
	By O2Offers = By.id("genieMarketingRequired");
	By OtherMarketing = By.id("otherMarketingRequired");
		
	By btnRegister = By.className("registerCustomerBtn");
	By btnPayByCard = By.className("payByCard");
	By btnSubmitOrder = By.className("placeOrder");
	
	By btnUpdateEmail = By.id("updateEmailAddressProceedButton");
	By btnYesDealSummary = By.id("secciYesButton");
	By btnGenerateCCA = By.xpath("//form[@id='generateCcaForm']//input[@class='generateCca']");
	
	public RegisterCustomerDetails(WebDriver driver) {
		this.driver = driver;
	}
	
	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getTitle(), "Agent Upgrade Shop - Shopping");
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	public void populateAllRequiredDetails() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, password, 5);
		Customer customer = Customer.getCustomer();
		
		driver.findElement(password).sendKeys(customer.getPassword());
		driver.findElement(confirmPswd).sendKeys(customer.getConfirmPswd());
		new Select(driver.findElement(securityQue)).selectByVisibleText(customer.getSecurityQue());
		
		driver.findElement(securityAns).sendKeys(customer.getSecurityAns());
		driver.findElement(btnRegister).click();
	}
	
	public void submitOrder() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnSubmitOrder, 5);
		driver.findElement(btnSubmitOrder).click();
	}

	public void GenerateCCA() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnGenerateCCA, 5);
		driver.findElement(btnGenerateCCA).click();
	}

	public void updateDevicePlanLinkEmailAddrs() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnUpdateEmail, 5);
		driver.findElement(btnUpdateEmail).click();
	}

	public void o2RefreshDealSummaryYes() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnYesDealSummary, 5);
		driver.findElement(btnYesDealSummary).click();
	}

	public void clickOnPayByCardBtn_Or_SubmitOrderBtn() {
		try {
			WebDriverWaitUtil.waitForElementToBeClickable(driver, btnPayByCard, 5);
			driver.findElement(btnPayByCard).click();
			Payments payments = new Payments(driver).get();
			payments.chooseTheAddrs();
		} catch (TimeoutException e) {
			submitOrder();
		}
	}
}
