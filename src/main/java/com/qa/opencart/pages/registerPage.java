package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ElementUtils;

public class registerPage extends BasePage {
	ElementUtils elementUtils;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline'][position()=1]/input");
	private By subscribeNo = By.xpath("//label[@class='radio-inline'][position()=2]/input");
	
	private By agreeCheckbos = By.name("agree");
	private By continueButton = By.xpath("//input[@type ='submit' and @value ='Continue']");
	private By accountSucessMessage = By.cssSelector("#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	
	public registerPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtils = new ElementUtils(this.driver);
	}
	
	
	public boolean accountRegistraion(String firstName,String lastName, String email , String telephone , String password , String subscribe)
	{
		elementUtils.doSendKeys(this.firstName, firstName);
		elementUtils.doSendKeys(this.lastName, lastName);
		elementUtils.doSendKeys(this.email, email);
		elementUtils.doSendKeys(this.telephone, telephone);
		elementUtils.doSendKeys(this.password, password);
		elementUtils.doSendKeys(this.password, password);
		elementUtils.doSendKeys(confirmPassword, password);
		
		
		if(subscribe.equals("yes"))
       {
			elementUtils.doClick(subscribeYes);
			
        }
		else
		{
			elementUtils.doClick(subscribeNo);
		}
		
		elementUtils.doClick(agreeCheckbos);
		elementUtils.doClick(continueButton);
		
		String text = elementUtils.doGetText(accountSucessMessage);
		if(text.contains(Constant.ACCOUNT_SUCESS_MESSAGE))
		{
			elementUtils.doClick(logoutLink);
			elementUtils.doClick(registerLink);
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
