package com.uktd.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uktd.qa.base.TestBase;

public class EmploymentCheck extends TestBase
{

	public EmploymentCheck()
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//div[@class='form-group-custom'][1]//child::label[@class='col-sm-8 col-xs-6 control-label ng-binding']")
	WebElement appName;

	@FindBy (xpath = "//div[@class='form-group-custom'][2]//child::label[@class='col-sm-8 col-xs-6 control-label ng-binding']")
	WebElement currentAddress;

	@FindBy (xpath = "//div[@class='form-group-custom ng-scope'][1]//child::label[@class='col-sm-8 col-xs-6 control-label ng-binding']")
	WebElement insuranceNo;

	@FindBy (xpath = "//div[@class='form-group-custom ng-scope'][2]//child::label[@class='col-sm-8 col-xs-6 control-label ng-binding']")
	WebElement workingHours;


	@FindBy (xpath = "//div[@class='form-group-custom ng-scope'][3]//child::label[@class='col-sm-8 col-xs-6 control-label ng-binding']")
	WebElement workingContract;


	@FindBy (xpath = "//select")
	WebElement statusDrp;

	@FindBy (xpath = "//input[@name='date']")
	WebElement startDate;

	@FindBy (xpath = "//input[@name='applicantJobTitle']")
	WebElement jobTitle;

	@FindBy (xpath = "//input[@name='appliantAnnualSalary']")
	WebElement annualSalary;

	@FindBy (xpath = "//input[@ng-model='model.applicantAnnualBonus']")
	WebElement annualBonus;

	@FindBy (xpath = "//textarea[@id='txtoffices']")
	WebElement Comment;

	@FindBy (xpath = "//input[@name='verifierName']")
	WebElement RefName;

	@FindBy (xpath = "//input[@ng-model='model.verifierPosition']")
	WebElement RefPosition;

	@FindBy(xpath = "//button[contains(text(),'Submit Reference')]")
	WebElement submitBtn;

	
	@FindBy(xpath="//h2[contains(text(),'Company Details')]")
	WebElement companyName;
	
	@FindBy(xpath="//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required']")
	WebElement businessName;
	
	@FindBy(xpath = "//input[@ng-model='model.applicantNumberofYearsTrading']")
	WebElement yearsOfTrading;
	
	@FindBy(xpath = "//input[@name='applicantBusinessType']")
	WebElement businessType;
	
	@FindBy(xpath = "//input[@ng-model='model.accountantCredentials']")
	WebElement accCredentials;
	
	@FindBy(xpath = "//input[@ng-model='model.accountantYearsKnown']")
	WebElement yearsOfknown;
	
	@FindBy(xpath = "//input[@value='true'][@ng-model='model.istheApplicantReliable']//ancestor::label[@class='btn btn-primary']")
	WebElement applicantreliableYes;
	
	@FindBy(xpath = "//input[@value='false'][@ng-model='model.istheApplicantReliable']//ancestor::label[@class='btn btn-primary']")
	WebElement applicantreliableNo;
	
	
	@FindBy(xpath = "//button[contains(text(),'Submit Reference')]")
	WebElement submitButton;
	
	
	
	
	public void verifySelfEmployerData( String a_Name, String a_SurName, String c_Address, 
										String companyBusiness_Name, String YearsOfTrade, String busi_Type,
										String anuIncome, String foreName, String surName)
	{
		js = (JavascriptExecutor)driver;
		
		SoftAssert  SA = new SoftAssert();
		
		String applicantName = appName.getText();
		
		String address = currentAddress.getText();
		
		String company_Name = companyName.getText();
		
		
		select = new Select(businessName);
		WebElement option = select.getFirstSelectedOption();
		String business_Name = option.getText();
		
		
		String yearsOfTrade = yearsOfTrading.getAttribute("value");
		
		String business_Type = businessType.getAttribute("value");
		
		String annual_Salary = annualSalary.getAttribute("value");
		
		String accName = RefName.getAttribute("value");

		
		SA.assertEquals(applicantName, a_Name+" "+a_SurName);
		
		SA.assertTrue(address.contains(c_Address));
		
		SA.assertTrue(company_Name.contains(companyBusiness_Name));
		
		SA.assertEquals(business_Name, "Known");
		
		SA.assertEquals(yearsOfTrade, YearsOfTrade);
		
		SA.assertEquals(business_Type, busi_Type);
		
		SA.assertEquals(annual_Salary, anuIncome);
		
		SA.assertEquals(accName, foreName+" "+surName);
	
		SA.assertAll();
	
	}
	
	
	
	
	
	public void verifyEmployerData(String a_Name, String a_SurName, String c_Address, String insurance_No, String s_Date, String position, String  a_Salary, String a_Bonus, String c_Fname, String c_Lname )
	{
		js = (JavascriptExecutor)driver;
		
		SoftAssert  SA = new SoftAssert();
		
		String applicantName = appName.getText();

		String address = currentAddress.getText();

		String insuranceNumber = insuranceNo.getText();

		String workingHrs = workingHours.getText();

		String working_Contract = workingContract.getText();

		select = new Select(statusDrp);
		WebElement option = select.getFirstSelectedOption();
		String status = option.getText();

		js.executeScript("window.scrollBy(0,500)");
		
		String jobStartDate = startDate.getAttribute("value");

		String job_Title = jobTitle.getAttribute("value");

		String Salary = annualSalary.getAttribute("value");

		String Bonus = annualBonus.getAttribute("value");

		String RefreeName = RefName.getAttribute("value");

		SA.assertEquals(applicantName, a_Name+" "+a_SurName);
		
		SA.assertTrue(address.contains(c_Address));
		
		SA.assertEquals(insuranceNumber, insurance_No);
				
		SA.assertEquals(status, "Employed with no future changes");
		
		SA.assertEquals(jobStartDate, s_Date);
		
		SA.assertEquals(job_Title, position);
		
		SA.assertEquals(Salary, a_Salary);
		
		SA.assertEquals(Bonus, a_Bonus);
		
		SA.assertEquals(RefreeName, c_Fname+" "+c_Lname);

	SA.assertAll();	
	}

	
	
}

