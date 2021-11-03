package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ElementUtils;

public class LoginPage extends BasePage  {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	
	//By Locators
	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By yourStoreLink = By.linkText("Your Store");
	
	private By registerLink = By.linkText("Register");
	
	//Constructor, why we given driver here so we can use in page actions
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	//Page actions: behaviour of the page in the form (methods)
	
	public String getLoginPageTitle()
	{
		return elementutils.waitForTitlePresent(Constant.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean linkExist()
	{
		return elementutils.doIsDisplayed(yourStoreLink);
	}
	
	public AccountsPage doLogin(String un,String pwd)
	{
//		driver.findElement(emailid).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginButton).click();
		elementutils.doSendKeys(emailid, un);
		elementutils.doSendKeys(password, pwd);
		elementutils.doClick(loginButton);
		
		
		return new AccountsPage(driver);
	}
	
	public registerPage navigateToRegisterPage()
	{
		elementutils.doClick(registerLink);
		return new registerPage(driver);
	}

}
