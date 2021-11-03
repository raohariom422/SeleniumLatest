package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ElementUtils;

public class AccountsPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	private By myAccount = By.xpath("//h2[contains(text(),'My Account')]");
	private By desktopLinktext =By.linkText("Desktops");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchText = By.cssSelector("div#search input[name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchItemsResult = By.cssSelector(".product-layout .product-thumb");
	private By resultItems = By.cssSelector(".product-thumb h4 a");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	

	public String getAccountsPageTitle()
	{
		return elementutils.waitForTitlePresent(Constant.ACCOUNTS_PAGE_TITLE, 10);
	}
	
	public String getHeaderValue()
	{
		if(elementutils.doIsDisplayed(myAccount))
		{
			return elementutils.doGetText(myAccount);
		}
		return null;
	}
	
   public boolean dekopIconExist()
   {
	   //if(driver.findElements(desktopLinktext).size()>0)
	   
	   
	   if(elementutils.getElements(desktopLinktext).size()>0)
	   {
		   
			   return true;
		   }
		   else
		   {
			   return false;
		   } 
	   }
   
   
   public int getAccountSectionCount()
   {
	   //return driver.findElements(accountSectionHeaders).size();
	   return elementutils.getElements(accountSectionHeaders).size();
   }
   
   public List<String> getAccountSectionList()
   {
	   List<String> accountsList =  new ArrayList<String>();
	   List<WebElement> accSectionList = elementutils.getElements(accountSectionHeaders);
	   for(WebElement e : accSectionList)
	   {
		   System.out.println(e.getText());
		   accountsList.add(e.getText()); 
	   }
	   
	   return accountsList;
   }
   
   public boolean doSearch(String productName)
   {
	   elementutils.doSendKeys(searchText, productName);
	   //driver.findElement(searchText).sendKeys(productName);
	   elementutils.doClick(searchButton);
	   //driver.findElement(searchButton).click();
	   if(elementutils.getElements(searchItemsResult).size()>0)
	   {
		   return true;
	   }
	   
	   return false;
	   
   }
   
   public ProductInfoPage selectProductFromResullts(String productName)
   {
	  List<WebElement> resultItemList = elementutils.getElements(resultItems);
	  System.out.println("total sixe is" +resultItemList.size());
	  for(WebElement e : resultItemList )
	  {
		  if(e.getText().equals(productName))
		  {
			  e.click();
			  break;
		  }
	  }
	  
	  return new ProductInfoPage(driver);
   }

}
