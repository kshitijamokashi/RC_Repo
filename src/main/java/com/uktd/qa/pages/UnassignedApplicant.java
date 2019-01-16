package com.uktd.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy (xpath = "//div[@class='sidebar-nav']")
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
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.invisibilityOf(Loader));
		action.moveToElement(SideMenu).build().perform();
		wait.until(ExpectedConditions.visibilityOf(IncompleteApplicant));
		IncompleteApplicant.click();
	
		return new IncompleteApplicant();
	}

	public AgentManagement openAgentManagement()
	{
		
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.invisibilityOf(Loader));
		action.moveToElement(SideMenu).build().perform();
		wait.until(ExpectedConditions.visibilityOf(AgentMgmt));
		wait.until(ExpectedConditions.elementToBeClickable(AgentMgmt));
		AgentMgmt.click();
	
		return new AgentManagement();
	}
	
}
