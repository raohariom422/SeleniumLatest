package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ExcelUtil;

public class registerPageTest extends BaseTest {
	
	@BeforeClass
	public void registerPageSetUp()
	{
		registerpage = loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getRegisterData()
	{
		Object data[][] = ExcelUtil.getTestData(Constant.REGISTER_SHEET_NAME);
		return data;
	}
	
	
	@Test(dataProvider="getRegisterData")
	public void userRegistrationTest(String firstName,String lastName, String email , String telephone , String password , String subscribe)
	{
		registerpage.accountRegistraion(firstName,lastName, email , telephone , password , subscribe);
	}

}
