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

	@FindBy (xpath = "//*[@id='progressing']")
	WebElement loader;

	@FindBy (xpath = "//label[contains(text(),'Moved In Date*')]")
	WebElement labelCurentMoveInDate;


	public StepTwoPage AgentFillQuickStepOneFullReport(String r_Share, String a_Title, String a_Name,
			String a_MiddleName, String a_SurName, String a_MaidenName, 
			String a_DOB, String m_Status, String h_Phone, String w_Phone,String a_Mobile, String e_Mail,
			String e_MailConfirm, String a_Proof, String no_Child, String no_ChildOver18) 
	{
		wait = new WebDriverWait(driver, 100);
		rentshare.clear();
		rentshare.sendKeys(r_Share);

		select = new Select(title);
		select.selectByVisibleText(a_Title);

		firstName.sendKeys(a_Name);

		middleName.sendKeys(a_MiddleName);

		surname.sendKeys(a_SurName);

		maleGender.click();

		maidenName.sendKeys(a_MaidenName);

		dateOfBirth.sendKeys(a_DOB);
		//label.click();

		select = new Select(maritalStatus);
		select.selectByVisibleText(m_Status);

		homePhone.sendKeys(h_Phone);

		workPhone.sendKeys(w_Phone);

		mobile.sendKeys(a_Mobile);

		email.sendKeys(e_Mail);

		confirmEmail.sendKeys(e_MailConfirm);

		applicantProof.sendKeys(a_Proof);

		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",nonSmoker);

		js.executeScript("arguments[0].click();",hasPets);

		js.executeScript("arguments[0].click();",noAdverseData);

		noOfChild.sendKeys(no_Child);

		childOver18.sendKeys(no_ChildOver18);

		tandC.click();

		wait.until(ExpectedConditions.visibilityOf(checkAll));
		wait.until(ExpectedConditions.elementToBeClickable(checkAll));
		js.executeScript("arguments[0].click();",checkAll);

		wait.until(ExpectedConditions.elementToBeClickable(acceptTandC));
		js.executeScript("arguments[0].click();",acceptTandC);

		nextButton.sendKeys(Keys.RETURN);
		return new StepTwoPage();

	}

	public StepTwoPage TenantFillStepOneFullReport(String a_MiddleName, String a_MaidenName, 
			String a_DOB, String m_Status, String h_Phone, String w_Phone,
			String a_Proof, String no_Child, String no_ChildOver18)
	{
		wait = new WebDriverWait(driver, 100);

		wait.until(ExpectedConditions.invisibilityOf(loader));
		middleName.sendKeys(a_MiddleName);

		maleGender.click();

		maidenName.sendKeys(a_MaidenName);

		dateOfBirth.sendKeys(a_DOB);
		//label.click();

		select = new Select(maritalStatus);
		select.selectByVisibleText(m_Status);

		homePhone.sendKeys(h_Phone);

		workPhone.sendKeys(w_Phone);

		applicantProof.sendKeys(a_Proof);

		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",nonSmoker);

		js.executeScript("arguments[0].click();",hasPets);

		js.executeScript("arguments[0].click();",noAdverseData);

		noOfChild.sendKeys(no_Child);

		childOver18.sendKeys(no_ChildOver18);

		tandC.click();

		wait.until(ExpectedConditions.visibilityOf(checkAll));
		wait.until(ExpectedConditions.elementToBeClickable(checkAll));
		js.executeScript("arguments[0].click();",checkAll);

		wait.until(ExpectedConditions.elementToBeClickable(acceptTandC));
		js.executeScript("arguments[0].click();",acceptTandC);

		nextButton.sendKeys(Keys.RETURN);
		return new StepTwoPage();

	}

	public CompleteApplication AgentFillQuickStepOneCreditReport(String r_Share, String a_Title, String a_Name,
			String a_MiddleName, String a_SurName, 
			String a_MaidenName, String a_DOB, String m_Status, 
			String h_Phone, String w_Phone,String a_Mobile, String e_Mail,
			String e_MailConfirm, String a_Proof, String s_Code, String a_No,
			String c_PostCode, String c_Address, String c_MoveIn, String no_Child, String no_ChildOver18) 
	{
		wait = new WebDriverWait(driver, 100);
		rentshare.clear();
		rentshare.sendKeys(r_Share);

		select = new Select(title);
		select.selectByVisibleText(a_Title);

		firstName.sendKeys(a_Name);

		middleName.sendKeys(a_MiddleName);

		surname.sendKeys(a_SurName);

		maleGender.click();

		maidenName.sendKeys(a_MaidenName);

		dateOfBirth.sendKeys(a_DOB);
		//label.click();

		select = new Select(maritalStatus);
		select.selectByVisibleText(m_Status);

		homePhone.sendKeys(h_Phone);

		workPhone.sendKeys(w_Phone);

		mobile.sendKeys(a_Mobile);

		email.sendKeys(e_Mail);

		confirmEmail.sendKeys(e_MailConfirm);

		applicantProof.sendKeys(a_Proof);

		sortCode.sendKeys(s_Code);

		accNo.sendKeys(a_No);

		currentAdd.sendKeys(c_PostCode);
		js = (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].click();",findButton);

		wait.until(ExpectedConditions.visibilityOf(addressList));
		select =new Select(addressList);
		select.selectByVisibleText(c_Address);

		wait.until(ExpectedConditions.invisibilityOf(loader));

		currentAddMoveIn.clear();
		currentAddMoveIn.sendKeys(c_MoveIn);

		labelCurentMoveInDate.click();

		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",nonSmoker);

		js.executeScript("arguments[0].click();",hasPets);

		js.executeScript("arguments[0].click();",noAdverseData);

		noOfChild.sendKeys(no_Child);

		childOver18.sendKeys(no_ChildOver18);

		tandC.click();

		wait.until(ExpectedConditions.visibilityOf(checkAll));
		wait.until(ExpectedConditions.elementToBeClickable(checkAll));
		js.executeScript("arguments[0].click();",checkAll);

		wait.until(ExpectedConditions.elementToBeClickable(acceptTandC));
		js.executeScript("arguments[0].click();",acceptTandC);

		nextButton.sendKeys(Keys.RETURN);


		return new CompleteApplication();

	}


	public PaymentPage TenantFillQuickStepOneCreditReport(String a_MiddleName, String a_MaidenName, String a_DOB, String m_Status, 
			                                                      String h_Phone, String w_Phone, String a_Proof, 
			                                                      String s_Code, String a_No,String c_PostCode, String c_Address, String c_MoveIn, 
			                                                      String no_Child, String no_ChildOver18) 
	{
		wait = new WebDriverWait(driver, 100);
		
		middleName.sendKeys(a_MiddleName);
		
		maleGender.click();

		maidenName.sendKeys(a_MaidenName);

		dateOfBirth.sendKeys(a_DOB);
		//label.click();

		select = new Select(maritalStatus);
		select.selectByVisibleText(m_Status);

		homePhone.sendKeys(h_Phone);

		workPhone.sendKeys(w_Phone);

		applicantProof.sendKeys(a_Proof);

		sortCode.sendKeys(s_Code);

		accNo.sendKeys(a_No);

		currentAdd.sendKeys(c_PostCode);
		
		js = (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].click();",findButton);

		wait.until(ExpectedConditions.visibilityOf(addressList));
		
		select =new Select(addressList);
		select.selectByVisibleText(c_Address);

		wait.until(ExpectedConditions.invisibilityOf(loader));

		currentAddMoveIn.clear();
		currentAddMoveIn.sendKeys(c_MoveIn);

		labelCurentMoveInDate.click();

		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",nonSmoker);

		js.executeScript("arguments[0].click();",hasPets);

		js.executeScript("arguments[0].click();",noAdverseData);

		noOfChild.sendKeys(no_Child);

		childOver18.sendKeys(no_ChildOver18);

		tandC.click();

		wait.until(ExpectedConditions.visibilityOf(checkAll));
		wait.until(ExpectedConditions.elementToBeClickable(checkAll));
		js.executeScript("arguments[0].click();",checkAll);

		wait.until(ExpectedConditions.elementToBeClickable(acceptTandC));
		js.executeScript("arguments[0].click();",acceptTandC);

		nextButton.sendKeys(Keys.RETURN);


		return new PaymentPage();

	}


}
