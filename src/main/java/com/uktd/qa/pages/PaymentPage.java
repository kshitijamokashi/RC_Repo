package com.uktd.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uktd.qa.base.TestBase;

public class PaymentPage extends TestBase
{
	
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//*[@name='cardName']")
	WebElement NameOnCard;
	
	@FindBy(xpath = "//*[@name='cardNumber']")
	WebElement NumbrOnCard;
	
	@FindBy(xpath = "//*[@name='cardtype']")
	WebElement CardType;
	
	@FindBy(xpath = "//*[@name='issueDate']")
	WebElement IssueDate;
	
	@FindBy(xpath = "//*[@name='issueYear']")
	WebElement IssueYear;
	
	@FindBy(xpath = "//*[@name='expiryDate']")
	WebElement ExpiryDate;
	
	@FindBy(xpath = "//*[@name='expiryYear']")
	WebElement ExpiryYear;
	
	@FindBy(xpath = "//*[@name='cvvNo']")
	WebElement CVVNo;
	
	@FindBy(xpath = "//*[@name='billingAddress']")
	WebElement BillingAddress;
	
	@FindBy(xpath = "//*[contains(text(),'Find')]")
	WebElement FindButton;
	
	@FindBy (xpath = "//*[@id='billingAddressList']")
	WebElement AddressList;
	
	@FindBy (xpath = "//*[contains(text(),'Pay')]")
	WebElement PayButton;
	
	@FindBy (xpath = "//*[@id='progressing']")
	WebElement loader;
	
	public void MakePayment()
	{
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		NameOnCard.sendKeys("Swapnil Bhaskar");
		NumbrOnCard.sendKeys("4929000000006");
		
		select = new Select(CardType);
		select.selectByVisibleText("Visa Card");
		
		select = new Select(IssueDate);
		select.selectByVisibleText("2");
		
		select  = new Select(IssueYear);
		select.selectByVisibleText("2018");
		
		
		select = new Select(ExpiryDate);
		select.selectByVisibleText("2");
		
		
		select = new Select(ExpiryYear);
		select.selectByVisibleText("2022");
		
		CVVNo.sendKeys("123");
		
		BillingAddress.sendKeys("m36gb");
		
		wait.until(ExpectedConditions.elementToBeClickable(FindButton));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",FindButton);
		
		wait.until(ExpectedConditions.visibilityOf(AddressList));
		Select select2 =new Select(AddressList);
		select2.selectByVisibleText("Apartment 2 Block B Alto Sillavan Way Salford");
		
		js.executeScript("window.scrollBy(0,500)");
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		js.executeScript("arguments[0].click();",PayButton);
		wait.until(ExpectedConditions.invisibilityOf(loader));
			
	}
	
}
