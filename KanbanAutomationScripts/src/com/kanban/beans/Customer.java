package com.kanban.beans;

import com.kanban.utils.PropertiesReader;

public class Customer {
	private String title;
	private String firstName;
	private String lastName ;
	private String email ;
	private String dateOfBirth;
	private String mobileNo ;
	private String landline;
	private String houseNameNum;
	private String postcode;
	private String currAddrsYears;
	private String currAddrsMonths;
	private String accountName;
	private String sortCode;
	private String accountNumber;
	private String password;
	private String confirmPswd;
	private String securityQue;
	private String securityAns;
	
	private static Customer customer= null;
	
	private Customer(){
		title = PropertiesReader.getProperty("customer_details", "title");
		firstName = PropertiesReader.getProperty("customer_details", "firstName");
		lastName = PropertiesReader.getProperty("customer_details", "lastName");
		email = PropertiesReader.getProperty("customer_details", "email");
		dateOfBirth = PropertiesReader.getProperty("customer_details", "dateOfBirth");
		mobileNo = PropertiesReader.getProperty("customer_details", "mobileNo");
		landline = PropertiesReader.getProperty("customer_details", "landline");
		houseNameNum = PropertiesReader.getProperty("customer_details", "houseNameNum");
		postcode = PropertiesReader.getProperty("customer_details", "postcode");
		currAddrsMonths = PropertiesReader.getProperty("customer_details", "currAddrsMonths");
		currAddrsYears = PropertiesReader.getProperty("customer_details", "currAddrsYears");
		accountName = PropertiesReader.getProperty("customer_details", "accountName");
		password =PropertiesReader.getProperty("customer_details", "password");
		confirmPswd = PropertiesReader.getProperty("customer_details", "confirmPswd");
		securityQue = PropertiesReader.getProperty("customer_details", "securityQue");
		securityAns = PropertiesReader.getProperty("customer_details", "securityAns");
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getHouseNameNum() {
		return houseNameNum;
	}
	public void setHouseNameNum(String houseNameNum) {
		this.houseNameNum = houseNameNum;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCurrAddrsYears() {
		return currAddrsYears;
	}
	public void setCurrAddrsYears(String currAddrsYears) {
		this.currAddrsYears = currAddrsYears;
	}
	public String getCurrAddrsMonths() {
		return currAddrsMonths;
	}
	public void setCurrAddrsMonths(String currAddrsMonths) {
		this.currAddrsMonths = currAddrsMonths;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getSortCode() {
		return sortCode;
	}
	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPswd() {
		return confirmPswd;
	}
	public void setConfirmPswd(String confirmPswd) {
		this.confirmPswd = confirmPswd;
	}
	public String getSecurityQue() {
		return securityQue;
	}
	public void setSecurityQue(String securityQue) {
		this.securityQue = securityQue;
	}
	public String getSecurityAns() {
		return securityAns;
	}
	public void setSecurityAns(String securityAns) {
		this.securityAns = securityAns;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	
	public static Customer getCustomer() {
		if(customer == null) {
			customer = new Customer();
		}
		return customer;
	}
}
