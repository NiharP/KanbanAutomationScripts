package com.kanban.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class PageUtils {
	public static String switchWindow(WebDriver driver) {
		String originalWindow = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.manage().window().maximize();
		return originalWindow;
	}
	
	public static void switchToMainWindow(String originalWindow, WebDriver driver) {
		//driver.close();
		driver.switchTo().window(originalWindow);
	}
	
	public static String generateRandomEmails() {
		return RandomStringUtils.randomAlphanumeric(15).toLowerCase() + "@" + RandomStringUtils.randomAlphabetic(8).toLowerCase() + ".com";
	}
}
