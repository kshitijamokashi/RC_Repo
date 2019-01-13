package com.uktd.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uktd.qa.base.TestBase;

public class LoginPage extends TestBase
{
	
	
	//Initialize the page object
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (xpath = "//*[@name ='email']")
	WebElement username;
	
	@FindBy (xpath = "//*[@name ='password']")
	WebElement password;
	
	@FindBy (xpath = "//*[@id='loginForm']/fieldset/button[1]")
	WebElement submit;
	
	@FindBy (xpath = "//img[@alt=\"UKtenantdata\" ]")
	WebElement Logo; 
	
	


	public boolean validateLogo()
	{
		return Logo.isDisplayed();
		
	}
		
	
	public void login(String un, String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		submit.sendKeys(Keys.RETURN);
	}


}
