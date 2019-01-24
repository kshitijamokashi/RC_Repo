package com.uktd.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uktd.qa.base.TestBase;

public class StepFivePage extends TestBase
{
	public StepFivePage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//div[@class='modal fade step5-popup ng-scope in']//ancestor::button[@type='button'][contains(text(),'Close')]")
	WebElement popUpClose;
	
	@FindBy (xpath = "//div[@class = 'col-sm-6']//following::select")
	WebElement countrydrp;
	
	@FindBy (xpath = "//label[@id='passportRadio']")
	WebElement radio_Passport;
	
	@FindBy (xpath = "///label[@id='otherRadio']")
	WebElement radio_Other;
	
	@FindBy (xpath = "//input[@id='file-inputPassport']")
	WebElement passportUpload;
	
	@FindBy (xpath = "//label[@id='passportline2Radio']")
	WebElement twoMRZLines;
	
	@FindBy (xpath = "//label[@id='passportline0Radio']")
	WebElement noMRZLines;
	
	@FindBy (xpath = "//button[@class='btn btn-success']")
	WebElement nextButton;
	
	@FindBy (xpath = "//*[@id='progressing']")
	WebElement loader;
	
	
	public void fillStepFive()
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		select = new Select(countrydrp);
		select.selectByVisibleText("United Kingdom");
		
		wait.until(ExpectedConditions.elementToBeClickable(radio_Passport));
		
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",radio_Passport);
		js.executeScript("arguments[0].click();",radio_Passport);
	
		/*	
		try {
			Thread.sleep(500);;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	
		//wait.until(ExpectedConditions.elementToBeClickable(passportUpload));
		
		
		passportUpload.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
		
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		wait.until(ExpectedConditions.elementToBeClickable(noMRZLines));
		js.executeScript("arguments[0].click();",noMRZLines);
		
		nextButton.sendKeys(Keys.RETURN);
		
		

	}

	public void applicantFillStepFive()
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		popUpClose.sendKeys(Keys.RETURN);
		
		select = new Select(countrydrp);
		select.selectByVisibleText("United Kingdom");
		
		wait.until(ExpectedConditions.elementToBeClickable(radio_Passport));
		
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",radio_Passport);
		js.executeScript("arguments[0].click();",radio_Passport);
	
		/*	
		try {
			Thread.sleep(500);;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	
		//wait.until(ExpectedConditions.elementToBeClickable(passportUpload));
		
		
		passportUpload.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
		
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		wait.until(ExpectedConditions.elementToBeClickable(noMRZLines));
		js.executeScript("arguments[0].click();",noMRZLines);
		js.executeScript("arguments[0].click();",noMRZLines);
		
		nextButton.sendKeys(Keys.RETURN);
		
		

	}
	
	
	
}
