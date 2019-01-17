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

public class StepThreePage extends TestBase
{

	public StepThreePage()
	{
		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath = "//*[@id='titleid']")
	WebElement kinTitle;

	@FindBy (xpath = "//*[@name='firstName']")
	WebElement firstName;

	@FindBy (xpath = "//*[@name='surname']")
	WebElement surname;

	@FindBy (xpath = "//*[@name='postCode']")
	WebElement postCode;

	@FindBy (xpath = "//*[contains(text(),'Find')]")
	WebElement findButton;

	@FindBy (xpath = "//*[@id='addressList']")
	WebElement addresslist;

	@FindBy (xpath = "//*[@name ='phone']")
	WebElement phone;

	@FindBy (xpath = "//*[@name ='mobile']")
	WebElement mobile;

	@FindBy (xpath = "//*[@name ='email']")
	WebElement email;

	@FindBy (xpath = "//*[@name='relationship']")
	WebElement relationship;

	@FindBy (xpath = "//*[@name='yearsKnown']")
	WebElement yearsKnown;

	@FindBy (xpath = "//*[@type='checkbox']")
	WebElement consentCheckbox;

	@FindBy(xpath="//*[@type='submit']")
	WebElement nextButton;

	@FindBy (xpath = "//*[@id='progressing']")
	WebElement loader;

	@FindBy(xpath = "html/body/section/section/div/div/ng-view/div/div/div/form/div[1]")
	WebElement date;


	public StepFourPage fillStepThree(String k_Title, String k_Name, String k_SName, String k_PostCode, 
			String k_Address, String k_Phone, String k_Mobile, String k_Email, 
			String k_RelationShip, String k_YOK )
	{
		wait = new WebDriverWait(driver,200);

		wait.until(ExpectedConditions.invisibilityOf(loader));

		wait.until(ExpectedConditions.visibilityOf(kinTitle));
		
		select = new Select(kinTitle);
		select.selectByVisibleText(k_Title);

		firstName.sendKeys(k_Name);

		surname.sendKeys(k_SName);

		postCode.sendKeys(k_PostCode);

		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",findButton);
		wait.until(ExpectedConditions.visibilityOf(addresslist));
		select =new Select(addresslist);
		select.selectByVisibleText(k_Address);
		phone.sendKeys(k_Phone);

		mobile.sendKeys(k_Mobile);

		email.sendKeys(k_Email);

		relationship.sendKeys(k_RelationShip);

		yearsKnown.clear();
		yearsKnown.sendKeys(k_YOK);

		if(!consentCheckbox.isSelected()) 
		{
			js.executeScript("arguments[0].click();",consentCheckbox);	

		}
		
		nextButton.sendKeys(Keys.RETURN);
		return new StepFourPage();
	}



}
