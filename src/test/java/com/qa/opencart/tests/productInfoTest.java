package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class productInfoTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetUp()
	{
		accountsPage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyProductInfoTest()
	{
		String productName = "Macbook";
		Assert.assertTrue(accountsPage.doSearch(productName));
		ProductInfoPage = accountsPage.selectProductFromResullts("MacBook Pro");
		//Assert.assertTrue(ProductInfoPage.getProductImages() == 4);
		Map<String,String> productInforMap = ProductInfoPage.getProductInformation();
		System.out.println(productInforMap);
		
		Assert.assertEquals(productInforMap.get("name"), "MacBook Pro");
		Assert.assertEquals(productInforMap.get("Brand"), "Apple");
		Assert.assertEquals(productInforMap.get("Reward Points"), "800");
	}

}
