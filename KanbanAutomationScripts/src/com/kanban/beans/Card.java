package com.kanban.beans;

import com.kanban.utils.PropertiesReader;

public class Card {
	private String nameOnCard;
	private String typeOfCard;
	private String cardNumber;
	private String expiryYear;
	private String expiryMonth;
	private String securityNumber;
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getTypeOfCard() {
		return typeOfCard;
	}
	public void setTypeOfCard(String typeOfCard) {
		this.typeOfCard = typeOfCard;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getSecurityNumber() {
		return securityNumber;
	}
	public void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}
	
	public Card() {
		nameOnCard = PropertiesReader.getProperty("creditCard", "nameOnCard");
		typeOfCard = PropertiesReader.getProperty("creditCard", "typeOfCard"); 
		cardNumber = PropertiesReader.getProperty("creditCard", "cardNumber");
		expiryYear = PropertiesReader.getProperty("creditCard", "expiryYear");
		expiryMonth =PropertiesReader.getProperty("creditCard", "expiryMonth"); 
		securityNumber = PropertiesReader.getProperty("creditCard", "securityNumber");
	}
}
