package com.uktd.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uktd.qa.base.TestBase;

public class AccomodationCheck extends TestBase
{
	public AccomodationCheck()
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//h2[contains(text(),'Applicant Details')]")
	WebElement applicantName;
	
	
	@FindBy(xpath = "//div[@class='form-group-custom'][1]//child::label[@class='col-md-8 col-xs-12 control-label ng-binding']")
	WebElement appCurrentAdd;
	
	@FindBy(xpath = "//*[@name='monthlyrent']")
	WebElement appPerMonthlyRent;
	
	@FindBy (xpath = "//*[@ng-options='payment.value as payment.text for payment in model.paymentArray']")
	WebElement rentPaymentMethod;
	
	@FindBy (xpath = "//input[@name='previousMovedInDate']")
	WebElement prevMoveIn;
	
	@FindBy (xpath = "//input[@name='previousMovedOutDate']")
	WebElement prevMoveOut;
	
	@FindBy (xpath = "//input[@name='movedInDate']")
	WebElement currentAddMoveIn;
	
	@FindBy (xpath = "//input[@name='verifierName']")
	WebElement lAName;
	
	@FindBy (xpath = "//input[@value='1'][@ng-model='model.hasrentbeenpaidontime']//ancestor::label[@class='btn btn-primary']")
	WebElement rentPaidYes;
	
	@FindBy (xpath = "//input[@value='0'][@ng-model='model.hasrentbeenpaidontime']//ancestor::label[@class='btn btn-primary']")
	WebElement rentPaidNo;
	
	@FindBy(xpath = "//input[@value='1'][@ng-model='model.haspropertylookedafter']//ancestor::label[@class='btn btn-primary']")
	WebElement propLookedAfterYes;

	@FindBy(xpath = "//input[@value='0'][@ng-model='model.haspropertylookedafter']//ancestor::label[@class='btn btn-primary']")
	WebElement propLookedAfterNo;

	@FindBy(xpath = "//textarea[@name='txtoffices']")
	WebElement comment;
	
	@FindBy(xpath="//input[@ng-model='model.verifierPosition']")
	WebElement position;
	
	
	public void verifyLAandLLSection(String a_Name, String a_SurName, String c_Address, String c_MoveIn, String la_FName, String la_lName, String mo_Rent, String p_Type)
	{
		SoftAssert SA = new SoftAssert();
		
		String ApplicantName = applicantName.getText();
		
		String ApplicantPrevAddress = appCurrentAdd.getText();
		
		String MonthlyRent  = appPerMonthlyRent.getAttribute("value");
		
		select = new Select(rentPaymentMethod);
		WebElement option = select.getFirstSelectedOption();
		String PaymentMethod =  option.getText();
		
		String MoveInDate = currentAddMoveIn.getAttribute("value");
		
		String LettingAgentName = lAName.getAttribute("value"); 		
		
		
		SA.assertTrue(ApplicantName.contains(a_Name+" "+a_SurName));
	
		
		SA.assertTrue(ApplicantPrevAddress.contains(c_Address));
		
		SA.assertEquals(MonthlyRent, mo_Rent);
		
		SA.assertEquals(MoveInDate, c_MoveIn);
		
		SA.assertEquals(LettingAgentName, la_FName+" "+la_lName);
	
		SA.assertEquals(PaymentMethod, p_Type);
	}
	
}
	
	

