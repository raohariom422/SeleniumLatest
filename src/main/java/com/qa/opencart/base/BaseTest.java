package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.registerPage;

public class BaseTest {
	
	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public ProductInfoPage ProductInfoPage;
	public registerPage registerpage;
	
	@BeforeTest
	public void setUp()
	{
		basePage = new  BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
