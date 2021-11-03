package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	private By productNameHeader = By.cssSelector("#content h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");
	private By productImages = By.cssSelector("#content .thumbnails li img");
	
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver = driver;
		elementutils = new ElementUtils(driver);
	}
	
	public Map<String, String> getProductInformation()
	{
		Map<String,String>  productInfoMap = new HashMap<String, String>();
		productInfoMap.put("name",elementutils.doGetText(productNameHeader).trim());
		List<WebElement> productMetaDataList = elementutils.getElements(productMetaData);
		for(WebElement e : productMetaDataList)
		{
			productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}
		
		List<WebElement> productPriceList = elementutils.getElements(productPrice);
		for(WebElement e : productPriceList)
		{
			productInfoMap.put("price", productPriceList.get(0).getText().trim());
			productInfoMap.put("ExTaxprice", productPriceList.get(1).getText().split(":") [1].trim());
		}
		return productInfoMap;
	}
	
	public void selectQuantity(String qty)
	{
		elementutils.doSendKeys(quantity, qty);
	}
	
	public void clickOnAddToCart()
	{
		elementutils.doClick(addToCartButton);
	}
	
	public int getProductImages()
	{
		int imagesCount =  elementutils.getElements(productImages).size();
		System.out.println("total images::" + imagesCount);
		return imagesCount;
	}
	
	
	

}
