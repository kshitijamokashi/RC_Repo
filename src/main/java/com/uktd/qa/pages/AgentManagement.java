package com.uktd.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uktd.qa.base.TestBase;

public class AgentManagement extends TestBase
{
	public AgentManagement()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[contains (text(),'Agent Management')]")
	WebElement pageHeader;
	
	@FindBy(xpath = "//*[@id = 'hladdtransaction']")
	WebElement addAgentbtn;
	
	@FindBy (xpath = "//*[@id='progressing']")
	WebElement Loader;
	
	
	public String checkPageHeader()
	{
		String page_Header = pageHeader.getText();
		return page_Header;
	}
	
	public AddAgentPage addAgent()
	{
		addAgentbtn.click();
		return new AddAgentPage();
	}
	
	
}
