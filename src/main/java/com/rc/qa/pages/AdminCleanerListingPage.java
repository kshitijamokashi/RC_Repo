package com.rc.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rc.qa.base.TestBase;

public class AdminCleanerListingPage extends TestBase
{

	public AdminCleanerListingPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (xpath = "//*[@class='sub-nav']//*[text()='Dashboard']")
	WebElement dashboardSubnavigation;
	
	@FindBy (xpath = "//*[@class='sub-nav']//*[text()=' Cleaners']")
	WebElement cleanerTab;
	
	@FindBy (xpath = "//*[@id='email']")
	WebElement emailSearchFilter;
	
	@FindBy (xpath = "//*[@id='frmcleanerssearch']/div/div[4]/button[1]")
	WebElement goButtonSearch;
	
	
	
	
		public void cleanerProxyLogin(String cleaner_email)
		{
		
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(dashboardSubnavigation));
			
			cleanerTab.click();
			enterText(emailSearchFilter, cleaner_email);
			goButtonSearch.click();
			
			
			
		
			
	}
}
	
