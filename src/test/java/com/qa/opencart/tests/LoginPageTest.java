package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constant;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=1)
	public void verifyLoginPageTitle()
	{
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is"+title);
		Assert.assertEquals(title, Constant.LOGIN_PAGE_TITLE);
}
	
	@Test(priority=2)
	public void verifySignUpLinkTest()
	{
		Assert.assertTrue(loginPage.linkExist());
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
}
