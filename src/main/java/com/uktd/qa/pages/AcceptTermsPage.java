package com.uktd.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uktd.qa.base.TestBase;

public class AcceptTermsPage extends TestBase
{

	public AcceptTermsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (xpath="//button[contains(text(),'Next Step')]")
	WebElement nextbutton;
	
	@FindBy (xpath = "//*[@id='progressing']")
	WebElement loader;

	public QuickStepOnePage goTonextStep()
	{
		wait = new WebDriverWait(driver, 200);
		
		js = (JavascriptExecutor)driver;
		
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		js.executeScript("window.scrollBy(0,500)");
		
		nextbutton.sendKeys(Keys.RETURN);
		return new QuickStepOnePage();
		
	}
	

}
