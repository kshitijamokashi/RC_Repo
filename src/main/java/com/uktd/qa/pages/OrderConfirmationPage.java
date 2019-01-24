package com.uktd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uktd.qa.base.TestBase;

public class OrderConfirmationPage extends TestBase
{
	
	public OrderConfirmationPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//h2[contains(text(),'Order Confirmation')]")
	WebElement pageTitle;
	
	
	
	public String getPageHeader()
	{
		String pageHeader = pageTitle.getText();
		
		return pageHeader;
	}
	
}
