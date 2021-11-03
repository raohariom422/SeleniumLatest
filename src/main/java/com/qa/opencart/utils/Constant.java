package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constant {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String ACCOUNTS_PAGE_HEADER = "My Account";
	public static final int ACCOUNTS_SECTIONS =4;
	public static final String REGISTER_SHEET_NAME = "REGISTRATION";
	public static final String ACCOUNT_SUCESS_MESSAGE = "Your Account Has Been Created";
	
	public static List<String> getAccountSectionsList()
	{
		List<String> accountsList = new ArrayList<String>();
		accountsList.add("My Account");
		accountsList.add("My Orders");
		accountsList.add("My Affiliate Account");
		accountsList.add("Newsletter");
		
		return accountsList;
		
	}
	

}
