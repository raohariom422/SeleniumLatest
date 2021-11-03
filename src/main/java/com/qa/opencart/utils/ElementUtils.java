package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public By getLocator(String value)
	{
		return By.id(value);
	}
	
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	
	
	
	public String doGetTitle()
	{
		try
		{
			return driver.getTitle();	
		}
		catch(Exception e)
		{
			System.out.println("some exception got occured while getting title....");
		}
		return null;
		
	}
	
	public WebElement getElement(By locator)
	{
		WebElement element = null;
		try
		{
			 element = driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println("some exception got occured while creating the webelement.......");
		}
		
		return element;
	}
	
	
	
	public void doClick(By locator)
	{
		try
		{
			getElement(locator).click();
		}
		catch(Exception e)
		{
			System.out.println("some exception got occured while clicking on the webelement.......");
		}
		
	}
	
	public void doSendKeys(By locator,String value)
	{
		try
		{
			WebElement ele = getElement(locator);
			ele.clear();
			ele.sendKeys(value);	
		}
		catch(Exception e) 
		{
			System.out.println("some exception got occured while entering value in field .......");
		}
		
	}
	public boolean doIsDisplayed(By locator)
	{
		try
		{
			return getElement(locator).isDisplayed();
		}
		catch(Exception e)
		{
			System.out.println("some exception got occured  .......");
		}
		
		return false;
		
	}
	
	public String doGetText(By locator)
	{
		try
		{
			return getElement(locator).getText();
		}
		catch(Exception e)
		{
			System.out.println("some exception got occured while getting the text  .......");
		}
		return null;
		
		
	}
	
	public void doActionSendKeys(By locator,String value)
	{
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator),value).perform();
		
	}
	
	public void doActionsclick(By locator)
	{
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}
	
	public void doClickWithMoveToElement(By locator)
	{
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).build().perform();
	}
	
	public boolean waitForElementPresent(By locator)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	
	public boolean waitForElementVisible(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	
	public boolean waitForTitlePresent(String title)
	{
		wait.until(ExpectedConditions.titleIs(title));
		return true;
		
	}
	
	public int getElementsCount(String tagname)
	{
		return driver.findElements(By.tagName(tagname)).size();
	}
	
	public List<String> getAttributesList(String tagname,String attributename)
	{
		List<String> attrList = new ArrayList<String>();
		List<WebElement> elementlist = driver.findElements(By.tagName(tagname));
		for (WebElement e: elementlist)
		{
			String text = e.getAttribute(attributename);
			attrList.add(text);
		}
		return attrList;
	}
	
	public void doClickFromList(By locator,String linktext)
	{
		List<WebElement> footerlist = getElements(locator);
		for( int i=0;i<footerlist.size();i++)
		{
			String text = footerlist.get(i).getText();
			if(text.equals(linktext))
			{
				footerlist.get(i).click();
				break;
			}
		}
	}
	
	public void doSelectDropDownByVisibleText(By locator,String text)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public void doSelectDropDownByIndex(By locator,int index)
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public void doSelectDropDownByValue(By locator,String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public void selectDropDownValueWithoutSelectClass(By locator,String value)
	{
		List<WebElement> optionsList = getElements(locator);
		for(WebElement e: optionsList)
		{
			String text = e.getText();
			if(text.equals(value))
			{
				e.click();
				break;
			}
		}
	}
	
	public List<WebElement> visibilityOfAllElements(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
//	public void getPageLinksText(By locator, int timeout)
//	{
//		visibilityOfAllElements(locator,timeout).stream().forEach(ele->System.out.println(ele.getText()));
//	}
	
	public int getPageLinksCount(By locator,int timeout)
	{
		return visibilityOfAllElements(locator,timeout).size();
	}
	
	public Alert waitForAlertToBePresent(int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String waitForTitlePresent(String titlevalue,int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.titleIs(titlevalue));
		return driver.getTitle();
		
	}
	
	
	

}
