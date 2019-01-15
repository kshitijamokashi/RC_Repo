package com.uktd.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.uktd.qa.base.TestBase;

public class UnassignedApplicant extends TestBase
{
	
	
	public UnassignedApplicant()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//*[contains(text(), 'Unassigned Applicants')]")
	WebElement Header;
	
	@FindBy (xpath = "//*[@id='side-menu']")
	WebElement SideMenu;
	
	@FindBy (xpath = "//a[@href ='#/incompleteApplicants']")
	WebElement IncompleteApplicant;
	
	@FindBy (xpath = "//a[@href ='#/agentManagement']")
	WebElement AgentMgmt;
	
	@FindBy (xpath = "//*[@id='progressing']")
	WebElement Loader;
	
	
	public void pageHeaderTest()
	{
		Assert.assertTrue(Header.isDisplayed());
	}
	
	
	public String getPageHeader()
	{
		String PageHeader = Header.getText();
		return PageHeader;
	}
	
	
	public IncompleteApplicant openIncompleteApplicantListing()
	{
		wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.invisibilityOf(Loader));
		SideMenu.click();
		wait.until(ExpectedConditions.visibilityOf(IncompleteApplicant));
		IncompleteApplicant.click();
	
		return new IncompleteApplicant();
	}

	public AgentManagement openAgentManagement()
	{
		wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.invisibilityOf(Loader));
		SideMenu.click();
		wait.until(ExpectedConditions.visibilityOf(AgentMgmt));
		wait.until(ExpectedConditions.elementToBeClickable(AgentMgmt));
		AgentMgmt.click();
	
		return new AgentManagement();
	}
	
}
