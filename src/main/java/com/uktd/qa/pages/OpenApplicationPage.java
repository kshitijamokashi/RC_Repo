package com.uktd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy (xpath = "//td[@data-title='ID Ref']")
	WebElement appID;
	
	

	@FindBy (xpath = "//div[@class='sidebar clearfix ng-scope']//child::a[@href='#agentTransactions']")
	WebElement account_Transaction;
	
	
	public void pageHeaderTest()
	{
		Assert.assertTrue(header.isDisplayed());
	}
	
	public String getPageHeader()
	{
		String PageHeader = header.getText();
		return PageHeader;
	}
	
	public String getApplicantID()
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		expandApplication.click();
		String ApplicantID = appID.getText();
		return ApplicantID;
	}
	
	
	public  CreateApplicationPage newApplicationPage()
	{
		action = new Actions(driver);
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(sideMenu));
		action.moveToElement(sideMenu).build().perform();
		wait.until(ExpectedConditions.visibilityOf(newApplication));
		newApplication.click();
		return new CreateApplicationPage();
	}
	
	
	public AgentTransactionPage agentTransaction()
	{
		action = new Actions(driver);
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(sideMenu));
		action.moveToElement(sideMenu).build().perform();
		wait.until(ExpectedConditions.visibilityOf(account_Transaction));
		account_Transaction.click();
		return new AgentTransactionPage();
	}
}
