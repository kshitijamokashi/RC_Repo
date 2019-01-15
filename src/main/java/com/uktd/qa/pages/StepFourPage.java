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

	@FindBy(xpath = "html/body/section/section/div/div/ng-view/div/div/div/form/div[1]")
	WebElement date;
	
	
	public void add_income() 
	{
		familyTaxCredit.sendKeys("100");
		housingBenifit.sendKeys("200");
		incomeSupport.sendKeys("300");
		disabilityincome.sendKeys("400");
		otherIncome.sendKeys("500");
		description.sendKeys("Pension");
	}

	//Student
	public void Student() 
	{
		wait = new WebDriverWait(driver,200);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(empType));

		insuranceNo.sendKeys("IND2018");

		add_income();

		if(empType.isEnabled())
		{ 
			select  =new Select(empType);
			select.selectByVisibleText("Student");
		}

		updateButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}

	//Employed
	public void Employed() 
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		select =new Select(empType);
		select.selectByVisibleText("Employed");

		insuranceNo.sendKeys("IND2018");
		
		companyName.sendKeys("Bemchmark IT Solutions India Pvt Ltd");
		
		department.sendKeys("QA");
		
		companyPostCode.sendKeys("M36GB");
		wait.until(ExpectedConditions.elementToBeClickable(findButton));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",findButton);
		
		wait.until(ExpectedConditions.visibilityOf(addressList));
		Select list =new Select(addressList);
		list.selectByVisibleText("Apartment 3 Block B Alto Sillavan Way Salford");
		
		companyPhone.sendKeys("02022556698");
		
		fax.sendKeys("000000000");
		
		select =new Select(contactTitle);
		select.selectByVisibleText("Miss");
		
		contactFirstName.sendKeys("Tripti");
		
		contactSurname.sendKeys("Poddar");
		
		contactMobile.sendKeys("02312545006");
		
		contactEmail.sendKeys("tp@bits.com");
		
		jobTitle.sendKeys("QA");
		
		jobStartDate.sendKeys("17/04/2017");
		date.click();
		
		annualSalary.sendKeys("280000");
		
		annualBonus.sendKeys("1500");
		
		add_income();
		updateButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}

	public void Self_Emp()
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		select =new Select(empType);
		select.selectByVisibleText("Self-Employed / Director of own company");

		insuranceNo.sendKeys("IND2018");
		
		businessName.sendKeys("WallMart");

		nOYTrading.sendKeys("120");
		
		businessType.sendKeys("Shopping Center");
		
		job_Title.sendKeys("Owner");
		
		job_Start_Date.sendKeys("17/04/2017");
		date.click();
		
		annualIncome.sendKeys("280000");
		
		annual_Bonus.sendKeys("1200");
		
		select = new Select(accTitle);
		select.selectByVisibleText("Mr");
		
		accForeName.sendKeys("Aniket");
		
		accSurname.sendKeys("Kulkarni");
		
		accPracticeName.sendKeys("AniKet Sir");
		
		accpostCode.sendKeys("l118lz");
		wait.until(ExpectedConditions.elementToBeClickable(postFindButton));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",postFindButton);
		wait.until(ExpectedConditions.visibilityOf(accAddress));
		select =new Select(accAddress);
		select.selectByVisibleText("28 Broad Lane Norris Green Liverpool");
		
		accEmail.sendKeys("ak@bits.com");
		
		accPhone.sendKeys("123456878");
		
		accMobile.sendKeys("789548798978");
		
		fax.sendKeys("887787788787");

		add_income();
		
		updateButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.invisibilityOf(loader));	
	}

	//UnEmployed
	public void unemployed() 
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));

		select =new Select(empType);
		select.selectByVisibleText("Unemployed");

		insuranceNo.sendKeys("IND2018");

		add_income();

		updateButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.invisibilityOf(loader));	
	}

	public void own_means() 
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

		add_income();

		updateButton.sendKeys(Keys.RETURN);
		wait.until(ExpectedConditions.invisibilityOf(loader));	
	}

}
