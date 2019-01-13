package com.uktd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.uktd.qa.base.TestBase;

public class OpenApplication extends TestBase
{
	public OpenApplication()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//*[contains(text(), 'Open Application')]")
	WebElement Header;
	
	
	public void pageHeaderTest()
	{
		Assert.assertTrue(Header.isDisplayed());
	}
	
	public String getPageHeader()
	{
		String PageHeader = Header.getText();
		return PageHeader;
	}
}
