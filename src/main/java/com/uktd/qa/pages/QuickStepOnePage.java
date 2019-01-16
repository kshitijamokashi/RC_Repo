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

public class QuickStepOnePage extends TestBase
{
	public QuickStepOnePage()
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
	
	@FindBy (xpath = "//*[@name= 'personalMiddleName']")
	WebElement middleName;
	
	@FindBy (xpath = "//*[@name= 'personalSurName']")
	WebElement surname;
	
	@FindBy (xpath = "//*[@id='maleRadio']")
	WebElement maleGender;
	
	@FindBy (xpath = "//*[@id='femaleRadio']")
	WebElement femaleGender;
	
	@FindBy (xpath = "//*[@name='personalMaidenName']")
	WebElement maidenName;
	
	@FindBy (xpath = "//*[@name='personalDateOfBirth']")
	WebElement dateOfBirth;
	
	@FindBy (xpath = "//*[@name='personalMaritalStatus']")
	WebElement maritalStatus;
	
	@FindBy (xpath = "//*[@placeholder = 'Applicant Home Phone']")
	WebElement homePhone;
	
	@FindBy (xpath = "//*[@placeholder = 'Applicant Work Phone']")
	WebElement workPhone;
	
	@FindBy (xpath = "//*[@name='applicantMobile']")
	WebElement mobile;
	
	@FindBy (xpath = "//*[@id='applicantEmailID']")
	WebElement email;
	
	@FindBy (xpath = "//*[@name='applicantConfirmEmail']")
	WebElement confirmEmail;
	
	@FindBy (xpath = "//*[@name='applicantProofID']")
	WebElement applicantProof;
	
	@FindBy (xpath = "//*[@id='bankShortCode1']")
	WebElement sortCode;
	
	@FindBy (xpath = "//*[@id='bankAccNo']")
	WebElement accNo;
	
	@FindBy (xpath = "//*[@name='currentPostalCode']")
	WebElement currentAdd;
	
	@FindBy (xpath = "//*[contains(text(),'Find')]")
	WebElement findButton;
	
	@FindBy (xpath = "//*[@id='addressList']")
	WebElement addressList;
	
	@FindBy (xpath = "//*[@name='currentAccomProposedMoveDate']")
	WebElement currentAddMoveIn;

	@FindBy (xpath = "//*[@id='smoker']")
	WebElement smoker;
	
	@FindBy (xpath = "//*[@id='nonSmoker']")
	WebElement nonSmoker;
	
	@FindBy (xpath = "//*[@id='pets']")
	WebElement noPets;

	@FindBy (xpath = "//*[@id='noPets']")
	WebElement hasPets;

	@FindBy (xpath = "//*[@id='criminal']")
	WebElement hasAdversData;

	@FindBy (xpath = "//*[@id='noCriminal']")
	WebElement noAdverseData;

	@FindBy (xpath = "//*[@id='comment']")
	WebElement adversDetails;
	
	@FindBy (xpath = "//*[@name='noOfChildern']")
	WebElement noOfChild;
	
	@FindBy (xpath = "//*[@name='childernOver18']")
	WebElement childOver18;
	
	@FindBy (xpath = "//*[contains(text(),'View and Agree Terms and Conditions')]")
	WebElement tandC;
	
	@FindBy (xpath = "//button[contains(text(),'Agree to Terms & Conditions')]")
	WebElement checkAll;
	
	@FindBy (xpath ="//button[contains(text(),'Agree & Continue to Application')]")
	WebElement acceptTandC;
	
	@FindBy (xpath ="//*[@id='btnsubmit']")
	WebElement nextButton;
	
	@FindBy(xpath ="//*[contains(text(),'Previous Accommodation Information' )]")
	WebElement prevAccBlock;
	
	
	@FindBy(xpath = "//label[contains(text(),'Date of Birth*')]")
	WebElement label;
	
	
	public StepTwoPage FillQuickStepOneFullReport() //throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		rentshare.clear();
		rentshare.sendKeys("100");
		
		select = new Select(title);
		select.selectByVisibleText("Prof");
		
		firstName.sendKeys("Swapnil");
		
		middleName.sendKeys("Sunil");
		
		surname.sendKeys("Bhaksar");
		
		maleGender.click();
		
		maidenName.sendKeys("NA");
		
		dateOfBirth.sendKeys("28/01/1994");
		//label.click();
		
		select = new Select(maritalStatus);
		select.selectByVisibleText("Married");
		
		homePhone.sendKeys("02425261552");
		
		workPhone.sendKeys("0202255889");
		
		mobile.sendKeys("+91-9604328562");
		
		email.sendKeys("bhaskarswapnil22@gmail.com");
		
		confirmEmail.sendKeys("bhaskarswapnil22@gmail.com");
		
		applicantProof.sendKeys("Passport");
	
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",nonSmoker);
		
		js.executeScript("arguments[0].click();",hasPets);
		
		js.executeScript("arguments[0].click();",noAdverseData);
		
		noOfChild.sendKeys("2");
		
		childOver18.sendKeys("1");
		
		tandC.click();
		
		wait.until(ExpectedConditions.visibilityOf(checkAll));
		wait.until(ExpectedConditions.elementToBeClickable(checkAll));
		js.executeScript("arguments[0].click();",checkAll);
		
		wait.until(ExpectedConditions.elementToBeClickable(acceptTandC));
		js.executeScript("arguments[0].click();",acceptTandC);
		
		
		
		
		nextButton.sendKeys(Keys.RETURN);
		return new StepTwoPage();

	}
	
}
