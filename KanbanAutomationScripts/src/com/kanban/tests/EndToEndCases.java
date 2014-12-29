package com.kanban.tests;

import java.util.List;

import org.testng.annotations.Test;

import com.kanban.beans.TestDataStructure;
import com.kanban.pages.HomePage;
import com.kanban.pages.NewConnectionPage;
import com.kanban.pages.OrderConfirmationPage;
import com.kanban.pages.PersonalDetailsPage;
import com.kanban.pages.RegisterCustomerDetails;
import com.kanban.utils.CSVFileReader;

public class EndToEndCases extends AbstractTest {
	private static final String NON_CCA = "NonCCA";
	private static final String CCA = "CCA";

	@Test(priority = 1)
	public void endToEndNonCCAFlows() {
		List<TestDataStructure> testData = CSVFileReader.getTestData(NON_CCA);
		for (TestDataStructure data : testData) {
			HomePage homepage = new HomePage(driver).get();
			NewConnectionPage newConnection = homepage
					.clickOnNewCustomerConnectionLink();

			newConnection.doSearchForTariffs(data.getTariff());
			newConnection.doSearchForDevices(data.getDevice());
			newConnection.selectExtras(data.getExtra());
			newConnection.checkStoreStock();
			newConnection.clickOnCheckOut();

			PersonalDetailsPage personalDetails = new PersonalDetailsPage(
					driver).get();
			personalDetails.clickOnAdvisorCheckYesBtn();
			personalDetails.enterAllPersonalDetails();

			RegisterCustomerDetails registeredCustomer = new RegisterCustomerDetails(
					driver).get();
			registeredCustomer.populateAllRequiredDetails();

			registeredCustomer.clickOnPayByCardBtn_Or_SubmitOrderBtn();

			OrderConfirmationPage orderConfirmation = new OrderConfirmationPage(
					driver).get();
			orderConfirmation.getOrderNumber();
		}
	}

	@Test(priority = 2)
	public void endToEndCCFlows() {
		List<TestDataStructure> testData = CSVFileReader.getTestData(CCA);
		for (TestDataStructure data : testData) {
			HomePage homepage = new HomePage(driver).get();
			NewConnectionPage newConnection = homepage
					.clickOnNewCustomerConnectionLink();
			newConnection.doSearchForTariffs(data.getTariff());
			newConnection.doSearchForDevices(data.getDevice());
			newConnection.selectExtras(data.getExtra());
			newConnection
					.selectPriceCombination();
			newConnection.checkStoreStock();

			newConnection.clickOnCheckOut();

			PersonalDetailsPage personalDetails = new PersonalDetailsPage(
					driver).get();
			personalDetails.clickOnAdvisorCheckYesBtn();
			personalDetails.enterAllPersonalDetails();

			RegisterCustomerDetails registeredCustomer = new RegisterCustomerDetails(
					driver).get();
			registeredCustomer.populateAllRequiredDetails();
			registeredCustomer.updateDevicePlanLinkEmailAddrs();
			registeredCustomer.o2RefreshDealSummaryYes();
			registeredCustomer.GenerateCCA();

			OrderConfirmationPage orderConfirmation = new OrderConfirmationPage(
					driver).get();
			orderConfirmation.placeCCAOrder();
		}
	}
}