package com.kanban.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.kanban.pages.HomePage;
import com.kanban.utils.PropertiesReader;

public class AbstractTest {
	protected static WebDriver driver = null;
	private static String browserType =null;
	protected static String url = null;
	
	HomePage homePage = null;
	
	
	@BeforeSuite 
	public void readConfigInfo() {
		browserType = PropertiesReader.getProperty("config", "browser");
	}
	
	@BeforeClass
	public void setup() {
		if(browserType.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
