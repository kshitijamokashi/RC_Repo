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

public class StepFourPage extends TestBase
{
	public StepFourPage()
	{
		PageFactory.initElements(driver, this);
	}


	//Employed, Student and Unemployed
	
	@FindBy (xpath = "//*[@name='employmentType']")
	WebElement empType;

	@FindBy (xpath = "//*[@name='nationalInsuranceNo']")
	WebElement insuranceNo;

	@FindBy (xpath = "//*[@id='progressing']")
	WebElement loader;

	@FindBy(xpath ="//*[contains(text(),'Update')][@ng-click='validateStep4()']")
	WebElement updateButton;

	@FindBy (xpath = "//*[@name='companyName']")
	WebElement companyName;

	@FindBy (xpath = "//*[@name='department']")
	WebElement department;

	@FindBy (xpath = "//*[@name='postCode']")
	WebElement companyPostCode;

	@FindBy (xpath = "//*[contains(text(),'Find')]")
	WebElement findButton;

	@FindBy (xpath = "//*[@id='addressList']")
	WebElement addressList;

	@FindBy (xpath = "//*[@name='phone']")
	WebElement companyPhone;

	@FindBy (xpath = "//*[@name='fax']")
	WebElement fax;

	@FindBy (xpath = "//*[@name='contactTitle']")
	WebElement contactTitle;

	@FindBy (xpath = "//*[@name='contactFirstName']")
	WebElement contactFirstName;

	@FindBy (xpath = "//*[@name='contactSurname']")
	WebElement contactSurname;

	@FindBy (xpath = "//*[@name='contactMobile']")
	WebElement contactMobile;

	@FindBy (xpath = "//*[@name='contactEmail']")
	WebElement contactEmail;

	@FindBy (xpath = "//*[@name='jobTitle']")
	WebElement jobTitle;

	@FindBy (xpath = "//*[@name='jobStartDate']")
	WebElement jobStartDate;

	@FindBy (xpath = "//*[@name='annualSalary']")
	WebElement annualSalary;

	@FindBy (xpath = "//*[@name='jobAnnualBonus']")
	WebElement annualBonus;

	@FindBy (xpath = "//*[@name='workingHours']")
	WebElement workingHrs;

	@FindBy (xpath = "//*[@name='workingContract']")
	WebElement workingContract;

	@FindBy (xpath = "//*[@name='workingContract']")
	WebElement lengthContract;

	
	//SelfEmployed

	@FindBy (xpath = "//*[@name='businessName']")
	WebElement businessName;

	@FindBy (xpath = "//*[@name='numberOfYearsTrading']")
	WebElement nOYTrading;

	@FindBy (xpath = "//*[@name='businessType']")
	WebElement businessType;

	@FindBy (xpath = "//*[@name='jobTitle']")
	WebElement job_Title;

	@FindBy (xpath = "//*[@name='jobStartDate']")
	WebElement job_Start_Date;

	@FindBy (xpath = "//*[@name='annualIncome']")
	WebElement annualIncome;

	@FindBy (xpath = "//*[@name='annualBonus']")
	WebElement annual_Bonus;

	@FindBy (xpath = "//*[@name='accountantTitle']")
	WebElement accTitle;

	@FindBy (xpath = "//*[@name='forename']")
	WebElement accForeName;

	@FindBy (xpath = "//*[@name='surname']")
	WebElement accSurname;

	@FindBy (xpath = "//*[@name='accountantPractiseName']")
	WebElement accPracticeName;

	@FindBy (xpath = "//*[@name='accountantPostCode']")
	WebElement accpostCode;

	@FindBy (xpath = "//*[contains(text(),'Find')]")
	WebElement postFindButton;

	@FindBy (xpath = "//*[@id='accountantAddressList']")
	WebElement accAddress;

	@FindBy (xpath = "//*[@name='Email']")
	WebElement accEmail;

	@FindBy (xpath = "//*[@name='accountantPhone']")
	WebElement accPhone;

	@FindBy (xpath = "//*[@name='accountantMobile']")
	WebElement accMobile;

	//Own Means

	@FindBy (xpath = "//*[@name='statePension']")
	WebElement StatePension;

	@FindBy (xpath = "//*[@name='privatePension']")
	WebElement PrivatePension;

	@FindBy (xpath = "//*[@name='investmentIncome']")
	WebElement InvestMentIncome;

	@FindBy (xpath = "//*[@name='interestReceived']")
	WebElement Intrest;

	//Additional Income	
	@FindBy (xpath= "//*[@name='familyTaxCreditIncome']")
	WebElement familyTaxCredit;

	@FindBy (xpath= "//*[@name='housingBenefitIncome']")
	WebElement housingBenifit;

	@FindBy (xpath= "//*[@name='incomeSupportIncome']")
	WebElement incomeSupport;

	@FindBy (xpath= "//*[@name='disabiliyLivingAllowanceIncome']")
	WebElement disabilityincome;

	@FindBy (xpath= "//*[@name='otherIncome']")
	WebElement otherIncome;

	@FindBy (xpath= "//*[@name='otherIncomeDescription']")
	WebElement description;

	@FindBy(xpath = "//label[contains(text(),'Start Date')]")
	WebElement date;
	
	
	public void add_income(String f_Tax, String h_Benifits, String i_Support, String d_Allowance, String o_Income, String disc ) 
	{
		familyTaxCredit.sendKeys(f_Tax);
		housingBenifit.sendKeys(h_Benifits);
		incomeSupport.sendKeys(i_Support);
		disabilityincome.sendKeys(d_Allowance);
		otherIncome.sendKeys(o_Income);
		description.sendKeys(disc);
	}

	//Student
	public void Student(String emptype, String insurance_No, String f_Tax, String h_Benifits, String i_Support, String d_Allowance, String o_Income, String disc) 
	{
		wait = new WebDriverWait(driver,200);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(empType));

		insuranceNo.sendKeys("IND2018");

		add_income(f_Tax, h_Benifits, i_Support, d_Allowance,  o_Income, disc);

		if(empType.isEnabled())
		{ 
			select  =new Select(empType);
			select.selectByVisibleText("Student");
		}

		updateButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}

	//Employed
	public void Employed(String insurance_No, String emptype, String c_Name, String dpartment, String c_Post, 
						 String co_Address, String c_Phone, String c_Fax, String c_Title, String c_Fname, String c_Lname, 
						 String c_Mobile, String c_Email, String position, String s_Date, String a_Salary, String a_Bonus, 
						 String f_Tax, String h_Benifits, String i_Support, String d_Allowance, String o_Income, String disc) 
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		insuranceNo.sendKeys(insurance_No);
		
		select =new Select(empType);
		select.selectByVisibleText(emptype);

		
		
		companyName.sendKeys(c_Name);
		
		department.sendKeys(dpartment);
		
		companyPostCode.sendKeys(c_Post);
		wait.until(ExpectedConditions.elementToBeClickable(findButton));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",findButton);
		
		wait.until(ExpectedConditions.visibilityOf(addressList));
		Select list =new Select(addressList);
		list.selectByVisibleText(co_Address);
		
		companyPhone.sendKeys(c_Phone);
		
		fax.sendKeys(c_Fax);
		
		select =new Select(contactTitle);
		select.selectByVisibleText(c_Title);
		
		contactFirstName.sendKeys(c_Fname);
		
		contactSurname.sendKeys(c_Lname);
		
		contactMobile.sendKeys(c_Mobile);
		
		contactEmail.sendKeys(c_Email);
		
		jobTitle.sendKeys(position);
		
		jobStartDate.sendKeys(s_Date);
		date.click();
		
		annualSalary.sendKeys(a_Salary);
		
		annualBonus.sendKeys(a_Bonus);
		
		
		add_income(f_Tax, h_Benifits, i_Support, d_Allowance,  o_Income, disc);
		
		updateButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}

	public void Self_Emp(String insurance_No, String emptype, String business_Name, String YearsOfTrade,
						String business_Type, String jobTitle, String startDate, String anuIncome, String anuBonus,
					String title, String foreName, String surName, String accPractName, String pCode, String address,	
					String accPractEmail, String accPractPhone, String accPractMobile, String accPractfax, String f_Tax, String h_Benifits, String i_Support, String d_Allowance, String o_Income, String disc)
	
	
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));

		insuranceNo.sendKeys(insurance_No);
		
		
		select =new Select(empType);
		select.selectByVisibleText(emptype);

		
		businessName.sendKeys(business_Name);

		nOYTrading.sendKeys(YearsOfTrade);
		
		businessType.sendKeys(business_Type);
		
		job_Title.sendKeys(jobTitle);
		
		job_Start_Date.sendKeys(startDate);
		date.click();
		
		annualIncome.clear();
		annualIncome.sendKeys(anuIncome);
		
		annual_Bonus.sendKeys(anuBonus);
		
		select = new Select(accTitle);
		select.selectByVisibleText(title);
		
		accForeName.sendKeys(foreName);
		
		accSurname.sendKeys(surName);
		
		accPracticeName.sendKeys(accPractName);
		
		accpostCode.sendKeys(pCode);
		wait.until(ExpectedConditions.elementToBeClickable(postFindButton));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",postFindButton);
		wait.until(ExpectedConditions.visibilityOf(accAddress));
		select =new Select(accAddress);
		select.selectByVisibleText(address);
		
		accEmail.sendKeys(accPractEmail);
		
		accPhone.sendKeys(accPractPhone);
		
		accMobile.sendKeys(accPractMobile);
		
		fax.sendKeys(accPractfax);

		add_income(f_Tax, h_Benifits, i_Support, d_Allowance,  o_Income, disc);
		
		updateButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.invisibilityOf(loader));	
	}

	//UnEmployed
	public void unemployed( String insurance_No, String emptype, String f_Tax, String h_Benifits, String i_Support, String d_Allowance, String o_Income, String disc ) 
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));

		insuranceNo.sendKeys(insurance_No);
		
		select =new Select(empType);
		select.selectByVisibleText(emptype);

		

		add_income(f_Tax, h_Benifits, i_Support, d_Allowance,  o_Income, disc);

		updateButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.invisibilityOf(loader));	
	}

	public void own_means(String emptype, String insurance_No, String f_Tax, String h_Benifits, String i_Support, String d_Allowance, String o_Income, String disc) 
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));

		select  =new Select(empType);
		select.selectByVisibleText("Own means");

		insuranceNo.sendKeys("IND2018");

		StatePension.sendKeys("1500");

		PrivatePension.sendKeys("2500");

		InvestMentIncome.sendKeys("3500");

		Intrest.sendKeys("500");

		add_income(f_Tax, h_Benifits, i_Support, d_Allowance,  o_Income, disc);

		updateButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.invisibilityOf(loader));	
	}

}
