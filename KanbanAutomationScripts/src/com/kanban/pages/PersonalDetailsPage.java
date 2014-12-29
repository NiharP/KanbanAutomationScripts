package com.kanban.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.kanban.beans.Customer;
import com.kanban.utils.PageUtils;
import com.kanban.utils.WebDriverWaitUtil;

public class PersonalDetailsPage extends LoadableComponent<PersonalDetailsPage>{
	private WebDriver driver = null;
	
	By AdvisorChecksYes = By.id("customerDetailsProceedButton");
	By AdvisorChecksNo = By.id("customerDetailsCancelButton");

	By custTitle = By.id("ccTitle");
	By custFirstName = By.id("ccFirstName");
	By custLastName = By.id("ccLastname");
	By custEmail = By.id("ccEmail");
	By custDOB = By.id("ccDob");
	By custMobileNumber = By.id("ccMobile");
	By custLandline = By.id("ccLandline");
	
	By houseNumber = By.xpath("//input[@name='houseNum']");
	By postcode = By.xpath("//input[@name='postcode']");
	By btnFindAddrs = By.className("findAddressBtn");
	By btnSelectAddrs = By.className("selectAddrBtn");
	
	By yearsAtCurrentAddrs = By.id("yearsAtCurrentAddress");
	By monthsAtCurrentAddrs = By.id("monthsAtCurrentAddress");
	
	By accountName = By.id("accountName");
	By sortCode = By.id("sortCode");
	By accountNumber = By.id("accountNumber");
	By linkCaptureCardDetails = By.id("captureCardDetails");
	
	By chkbxAgreeToCreditCheck = By.id("agreeToCreditCheck");
	By btnPerformCreditCheck = By.className("performCreditCheckBtn");
	
	public PersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getTitle(), "Agent Upgrade Shop - Shopping");
	}
	
	@Override
	protected void load() {
		
	}

	public void clickOnAdvisorCheckYesBtn() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, AdvisorChecksYes, 5);
		driver.findElement(AdvisorChecksYes).click();
	}

	public void enterAllPersonalDetails() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, custFirstName, 5);
		
		Customer customer = Customer.getCustomer();
		
		new Select(driver.findElement(custTitle)).selectByVisibleText(customer.getTitle());
				
		driver.findElement(custFirstName).sendKeys(customer.getFirstName());
		driver.findElement(custLastName).sendKeys(customer.getLastName());
		driver.findElement(custEmail).sendKeys(PageUtils.generateRandomEmails());
		driver.findElement(custDOB).sendKeys(customer.getDateOfBirth());
		//driver.findElement(custMobileNumber).sendKeys(customer.getMobileNo());
		driver.findElement(custLandline).sendKeys(customer.getLandline());
		driver.findElement(houseNumber).sendKeys(customer.getHouseNameNum());
		driver.findElement(postcode).sendKeys(customer.getPostcode());
		driver.findElement(btnFindAddrs).click();
		
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnSelectAddrs, 5);
		driver.findElement(btnSelectAddrs).click();
		
		driver.findElement(yearsAtCurrentAddrs).sendKeys(customer.getCurrAddrsYears());
		driver.findElement(monthsAtCurrentAddrs).sendKeys(customer.getCurrAddrsMonths());
		
		driver.findElement(accountName).sendKeys(customer.getAccountName());
		driver.findElement(sortCode).sendKeys(customer.getSortCode());
		driver.findElement(accountNumber).sendKeys(customer.getAccountNumber());
		
//		driver.findElement(linkCaptureCardDetails).click();
//		
//		String originalWindow = PageUtils.switchWindow(driver);
//		
//		CardDetails cardDetails = new CardDetails(driver);
//		cardDetails.populateCardDetailsOnScreen();
//		cardDetails.selectAddressAndSubmit();
//		
//		PageUtils.switchToMainWindow(originalWindow, driver);
//		
//		driver.findElement(chkbxAgreeToCreditCheck).click();
//		driver.findElement(btnPerformCreditCheck).click();
	}
}
