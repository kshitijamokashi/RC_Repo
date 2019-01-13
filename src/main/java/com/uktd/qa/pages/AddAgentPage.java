package com.uktd.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uktd.qa.base.TestBase;

public class AddAgentPage extends TestBase
{
	public AddAgentPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//h1[contains (text(),'Add Agent')]")
	WebElement pageHeader;
	
	@FindBy(xpath = "//input[@name = 'companyName']")
	WebElement companyName;
	
	@FindBy(xpath = "//input[@name = 'postalCode']")
	WebElement postCode;
	
	@FindBy (xpath = "//button[contains(text(),'Find')]")
	WebElement findBtn;
	
	@FindBy(xpath = "//select[@id='addressList']")
	WebElement addressList;
	
	@FindBy(xpath = "//input[@name = 'phoneNo']")
	WebElement phoneNo;
	
	@FindBy(xpath = "//input[@name = 'email']")
	WebElement emailID;
	
	@FindBy(xpath = "//input[@name = 'webUrl']")
	WebElement webSite;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	@FindBy (xpath = "//*[@id='progressing']")
	WebElement Loader;
	
	
	public void addAgent(String c_Name, String p_Code, String address, String phNo, String emailId, String url)
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(Loader));
		companyName.sendKeys(c_Name);
		postCode.sendKeys(p_Code);
		wait.until(ExpectedConditions.elementToBeClickable(findBtn));
		findBtn.click();
		wait.until(ExpectedConditions.visibilityOf(addressList));
		select = new Select(addressList);
		select.selectByVisibleText(address);
		phoneNo.sendKeys(phNo);
		emailID.sendKeys(emailId);
		webSite.sendKeys(url);
		js = (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].click();",saveBtn);
				
	}
}
