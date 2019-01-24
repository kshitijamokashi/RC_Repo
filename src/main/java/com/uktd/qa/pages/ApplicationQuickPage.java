package com.uktd.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uktd.qa.base.TestBase;

public class ApplicationQuickPage extends TestBase
{
	
	public ApplicationQuickPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//*[@name='applicantType']")
	WebElement appType;
	
	@FindBy (xpath = "//*[@name='rentPercentage']")
	WebElement rentshare;
	
	@FindBy (xpath = "//*[@name= 'personalTitle']")
	WebElement title;
	
	@FindBy (xpath = "//*[@name= 'personalFirstName']")
	WebElement firstName;
	
	@FindBy (xpath = "//*[@name= 'personalSurName']")
	WebElement surname;
	
	@FindBy (xpath = "//*[@name='applicantMobile']")
	WebElement mobile;
	
	@FindBy (xpath = "//*[@id='applicantEmailID']")
	WebElement email;
	
	@FindBy (xpath = "//*[@name='applicantConfirmEmail']")
	WebElement confirmEmail;
	
	@FindBy (xpath ="//button[contains(text(),'Next Step')]")
	WebElement nextButton;
	
	
	public CompleteApplication fillApplicationQuickPage(String r_Share, String a_Title, String a_Name,
			 String a_SurName,  String a_Mobile, String e_Mail, String e_MailConfirm)
	{
		wait = new WebDriverWait(driver, 100);
		rentshare.clear();
		rentshare.sendKeys(r_Share);
		
		select = new Select(title);
		select.selectByVisibleText(a_Title);
		
		firstName.sendKeys(a_Name);
		
		surname.sendKeys(a_SurName);
		
		mobile.sendKeys(a_Mobile);
		
		email.sendKeys(e_Mail);
		
		confirmEmail.sendKeys(e_MailConfirm);
		
		nextButton.sendKeys(Keys.RETURN);
		return new CompleteApplication();
	}
}
