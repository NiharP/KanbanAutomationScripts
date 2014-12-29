package com.kanban.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.kanban.beans.Customer;
import com.kanban.utils.PageUtils;
import com.kanban.utils.WebDriverWaitUtil;

public class NewConnectionPage extends LoadableComponent<NewConnectionPage> {

	private WebDriver driver;

	By searchBoxTariffs = By.xpath("//div[@id='planTable_filter']/label/input");
	By searchBoxDevices = By
			.xpath("//div[@id='deviceTable_filter']/label/input");

	By tabTariffs = By.id("plansTab");
	By tabDevices = By.id("devicesTab");
	By tabExtras = By.id("extrasTab");
	By tabAccesories = By.id("accessoriesTab");
	By tabPNGDevices = By.id("prepayDevicesTab");
	By tabPNGTariffs = By.id("prepayPlansTab");

	By btnAddPlan = By.xpath("//table[@id='planTable']/tbody/tr/td/a");
	By btnAddDevice = By.xpath("//table[@id='deviceTable']/tbody/tr/td/a");

	By btnEmptyDeal = By.id("emptyDealButton");
	By btnCheckStoreStock = By.id("checkStoreStock");
	By btnCheckOut = By.id("startCheckoutFromPrivateBasketButton");

	By extras50MBFree = By.xpath("//div[@id='dataAllowances']//table//tbody//tr[5]//td//a");
	
	By extra50MBFreeApple = By.xpath("//div[@id='dataAllowances']//table//tbody//tr[4]//td//a");
	
	By priceCombination = By.xpath("//div[@id='dealBuilderContent']//table//select");
	
	By txtPostCode = By.id("postcode");
	By btnSearch = By.id("findStores");
	By btnSelect = By.xpath("//input[@class='selectStore']");
	
	By extrasTableRows = By.xpath("//div[@id='dataAllowances']//table[@class='extrasTable']/tbody/tr");
	
	public NewConnectionPage(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getTitle(), "Agent Upgrade Shop - Shopping");
	}

	@Override
	protected void load() {
		//driver.get("http://ecom-dev-demo00.obnubilate.co.uk:8080/agent/app/qfz237/newConnection");
	}

	public void doSearchForTariffs(String searchText) {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, searchBoxTariffs, 5);
		driver.findElement(searchBoxTariffs).sendKeys(searchText);
		
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnAddPlan, 5);
		driver.findElement(btnAddPlan).click();
	}

	public void doSearchForDevices(String searchText) {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, tabDevices, 5);
		driver.findElement(tabDevices).click();
		
		WebDriverWaitUtil.waitForElementToBeClickable(driver, searchBoxDevices, 5);
		driver.findElement(searchBoxDevices).sendKeys(searchText);
		
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnAddDevice, 5);
		driver.findElement(btnAddDevice).click();
	}

	public void selectExtras(String extras) {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, tabExtras, 5);
		driver.findElement(tabExtras).click();
		
		clickOnExtras(extras);
	}
	
	public void clickOnCheckOut() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnCheckOut, 5);
		driver.findElement(btnCheckOut).click();
	}

	public void checkStoreStock() {
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnCheckStoreStock, 5);
		driver.findElement(btnCheckStoreStock).click();
		
		String mainWindow = PageUtils.switchWindow(driver);
		
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnSearch, 10);
		driver.findElement(txtPostCode).sendKeys(Customer.getCustomer().getPostcode());
		driver.findElement(btnSearch).click();
		
		WebDriverWaitUtil.waitForElementToBeClickable(driver, btnSelect, 5);
		driver.findElement(btnSelect).click();
		
		PageUtils.switchToMainWindow(mainWindow, driver);
	}

	public void selectPriceCombination() {
		try {
			WebDriverWaitUtil.waitForElementToBeClickable(driver, priceCombination, 5);
			new Select(driver.findElement(priceCombination)).selectByIndex(1);	
		} catch (Exception e) {
			System.out.println("No variants to choose from - " + NewConnectionPage.class);
		}
	}
	
	private boolean clickOnExtras(String extras) {
		boolean flag = false;
		
		WebDriverWaitUtil.waitForElementToBeClickable(driver, By.xpath("//div[@id='dataAllowances']//table[@class='extrasTable']/tbody/tr[1]/td[@class='type']"), 5);
		int extrasCount = driver.findElements(extrasTableRows).size();
		for (int i = 1; i <= extrasCount; i++) {
			if(driver.findElement(By.xpath("//div[@id='dataAllowances']//table[@class='extrasTable']/tbody/tr["+ i +"]/td[@class='type']")).getText().contains(extras)) {
				WebDriverWaitUtil.waitForElementToBeClickable(driver, By.xpath("//div[@id='dataAllowances']//table[@class='extrasTable']/tbody/tr["+ i +"]/td[@class='type']/a"), 5);
				driver.findElement(By.xpath("//div[@id='dataAllowances']//table[@class='extrasTable']/tbody/tr["+ i +"]/td[@class='type']/a")).click();
				flag = true;
				break;
			}
		}
		return flag;
	}
}
