package com.uktd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.uktd.qa.base.TestBase;

public class OpenApplicationPage extends TestBase
{
	public OpenApplicationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//*[contains(text(), 'Open Application')]")
	WebElement header;
	
	@FindBy(xpath = "//*[contains(text(),'LOGOUT')]")
	WebElement logout;

	
	@FindBy (xpath ="//*[@name = 'searchTextall']")
	WebElement globalSearchText;
	
	@FindBy (xpath = "//button[@class='input-group-addon']")
	WebElement globalSearchBtn;
	
	@FindBy (xpath = "//a[@tabindex ='-1']")
	WebElement searchResult;
	
	@FindBy (xpath = "//span[@class='icon-user-plus']")
	WebElement addApplicant;
	
	@FindBy (xpath ="//span[@class='lnr lnr-pencil']")
	WebElement editApplication;
	
	@FindBy (xpath= "//i[@class='icon-clipboard-text ng-scope']")
	WebElement taskList;
	
	@FindBy (xpath = "//span[@class='lnr lnr-envelope black']")
	WebElement msgApplicant;
	
	@FindBy (xpath = "//*[@id='exp']")
	WebElement expandApplication;
	
	@FindBy (xpath = "//div[@class='sidebar-nav']")
	WebElement sideMenu;
	
	
	@FindBy (xpath = "//*[@id='progressing']")
	WebElement loader;
	
	@FindBy (xpath = "//div[@class='sidebar clearfix ng-scope']//child::a[@href='#/createApplication']")
	WebElement newApplication;
	
	
	
	
	
	public void pageHeaderTest()
	{
		Assert.assertTrue(header.isDisplayed());
	}
	
	public String getPageHeader()
	{
		String PageHeader = header.getText();
		return PageHeader;
	}
	
	
	public  CreateApplicationPage newApplicationPage()
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(sideMenu));
		sideMenu.click();
		wait.until(ExpectedConditions.visibilityOf(newApplication));
		newApplication.click();
		return new CreateApplicationPage();
	}
}
