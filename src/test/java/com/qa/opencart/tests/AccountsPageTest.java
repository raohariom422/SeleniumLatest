package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.utils.Constant;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accountsPageSetUp()
	{
		accountsPage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitle()
	{
		String accountsPagetitle = accountsPage.getAccountsPageTitle();
		System.out.println(" accounts page title is" +accountsPagetitle);
		Assert.assertEquals(accountsPagetitle, Constant.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test(priority =2)
	public void verifyHomePageHeaderTest()
	{
		String headerValue = accountsPage.getHeaderValue();
		System.out.println("header value is" + headerValue);
		Assert.assertEquals(headerValue, Constant.ACCOUNTS_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifydekopIconTest()
	{
		Assert.assertTrue(accountsPage.dekopIconExist());
	}
	
	
	@Test(priority=4)
	public void verifyMyAccountSectionsCountTest()
	{
		Assert.assertTrue(accountsPage.getAccountSectionCount() == Constant.ACCOUNTS_SECTIONS);
	}
	
	@Test(priority=5)
	public void verifyMyAccountSectionListTest()
	{
		Assert.assertEquals(accountsPage.getAccountSectionList(), Constant.getAccountSectionsList());
	}
	
	@Test(priority=6)
	public void searchTest()
	{
		Assert.assertTrue(accountsPage.doSearch("iMac"));
		
	}
	

}
