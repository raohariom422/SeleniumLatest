package com.qa.opencart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(String browser)
	{
		System.out.println("browser is"+ browser);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:Selenium-java-chromedriver_win32chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("safari"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new SafariDriver();
			
		}
		else
		{
			System.out.println("Please pass the correct browser url"+ browser);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}
	
	
	/**
	 * This method is used to load the propertie from 
	 * @return properties prop reference
	 */
	public Properties init_prop()
	{
	     prop =new Properties();
	     String path = System.getProperty("user.dir") + "//src//main//java//com//qa//opencart//config//config.properties";
	     try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return prop;
		
	}


	

}
