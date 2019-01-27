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

public class StepTwoPage extends TestBase
{
	public StepTwoPage()
	{
		PageFactory.initElements(driver, this);
	}


	//Common

	@FindBy(xpath ="//*[@name='currentAccmStatus']")
	WebElement accStatus;

	@FindBy(xpath ="//*[@id='yesRented']")
	WebElement rentedLast6MonthYes;

	@FindBy(xpath ="//*[@id='notRented']")
	WebElement rentedLast6MonthNo;

	@FindBy (xpath = "//*[contains(text(),'Update')][@ng-click='submitApplicationStep2Form();']")
	WebElement updateButton;

	@FindBy (xpath = "//*[@id='progressing']")
	WebElement loader;

	@FindBy(xpath = "html/body/section/section/div/div/ng-view/div/div/div/form/div[1]")
	WebElement date;

	@FindBy (xpath = "//*[@id='lettingPay']")
	WebElement lettingAgent;

	@FindBy (xpath = "//*[@id='landLordPay']")
	WebElement landlord;

	//F&F

	@FindBy (xpath = "//*[@name='familyContactTitle']")
	WebElement contactTitle;

	@FindBy (xpath = "//*[@name='friendFirstName']")
	WebElement contactName;

	@FindBy (xpath = "//*[@name='friendSurName']")
	WebElement contactSurName;

	@FindBy (xpath = "//*[@name='friendPhoneNum']")
	WebElement contactPhone;

	@FindBy (xpath = "//*[@name='friendMobileNum']")
	WebElement contactMobile;

	@FindBy (xpath = "//*[@name='friendEmail']")
	WebElement contactEmail;


	//BankInfo
	@FindBy (xpath = "//*[@id='bankShortCode1']")
	WebElement sortCode;

	@FindBy (xpath = "//*[@id='bankAccNo']")
	WebElement accNo;

	//CurrentAcc	
	@FindBy (xpath = "//*[@name='currentAccomPostalCode']")
	WebElement currentAdd;

	@FindBy (xpath = "//*[contains(text(),'Find')]")
	WebElement findButton;

	@FindBy (xpath = "//*[@id='currentAccomaddressList']")
	WebElement addressList;

	@FindBy (xpath = "//*[@name='currentAccomProposedMoveDate']")
	WebElement currentAddMoveIn;


	//FinishStep
	@FindBy (xpath = "//button[contains(text(),'Finish')]")
	WebElement finishButton;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement addAnother;

	@FindBy(xpath = "//button[@type='button'][contains(text(),'Finish')][1]")
	WebElement popupFinish;

	@FindBy(xpath = "html/body/div[6]/div/div/div[3]/button[1]")
	WebElement popupCancel;


	//PrevAccomodationBlock	

	@FindBy (xpath = "//*[@name='prevAccomPostalCode']")
	WebElement prevAccPostCode;

	@FindBy (xpath = "//button[contains(text(),'Find')][@aria-controls='find3']")
	WebElement prevAccPostCodeFind;

	@FindBy (xpath = "//*[@id='prevAccomAddressList']")
	WebElement prevAccAddList;

	@FindBy (xpath = "//*[@name='prevAccomProposedMoveDate']")
	WebElement prevAccProposeMoveIn;

	//AccommodationDetails

	@FindBy (xpath = "//*[@name='accomMonthlyRent']")
	WebElement monthlyRent;

	@FindBy (xpath = "//*[@name='rentPayMethod']")
	WebElement rentPayment;

	//Letting Agent	

	@FindBy (xpath = "//*[@name='lettingAgentName']")
	WebElement lettingAgentName;


	@FindBy (xpath = "//*[@name='lettingAgentPostCode']")
	WebElement lettingAgentPostCode;

	@FindBy (xpath = "//button[contains(text(),'Find')][@aria-controls='find4']")
	WebElement lAFindButton;

	@FindBy (xpath = "//*[@id='lettingAgentAddressList']")
	WebElement lettingAgentAddList;	

	@FindBy (xpath = "//*[@placeholder='Enter Fax']")
	WebElement fax;

	@FindBy (xpath = "//*[@name='lettingAgentTitle']")
	WebElement lettingAgentTitle;

	@FindBy (xpath = "//*[@name='lettingAgentFirstName']")
	WebElement agentFirstName;

	@FindBy (xpath = "//*[@name='lettingAgentSurName']")
	WebElement agentSurName;

	@FindBy (xpath = "//*[@name='lettingAgentPhone']")
	WebElement agentPhone;

	@FindBy (xpath = "//*[@name='lettingAgentMobile']")
	WebElement agentMobile;

	@FindBy (xpath = "//*[@name='lettingAgentEmailID']")
	WebElement agentEmail;

	//LandLord	

	@FindBy (xpath = "//*[@name='landLordPostalCode']")
	WebElement lLpostcode;

	@FindBy (xpath = "//button[contains(text(),'Find')][@aria-controls='find5']")
	WebElement lLpostcodeFind;

	@FindBy (xpath = "//*[@id='landlordAddressList']")
	WebElement lLAddlist;

	@FindBy (xpath = "//*[@name='landLordTitle']")
	WebElement lLTitle;

	@FindBy (xpath = "//*[@name='landLordFirstName']")
	WebElement lLFirstName;

	@FindBy (xpath = "//*[@name='landLordSurname']")
	WebElement lLSurname;

	@FindBy (xpath = "//*[@name='landLordPhone']")
	WebElement lLPhone;

	@FindBy (xpath = "//*[@name='landLordMobile']")
	WebElement lLMobile;

	@FindBy (xpath = "//*[@name='landLordEmailID']")
	WebElement lLEmail;

	//Address Renting	

	@FindBy (xpath = "//*[@name='prevMovedIn']")
	WebElement prevMoveInDate;

	@FindBy (xpath = "//*[@name='prevMovedOut']")
	WebElement PrevMoveOutDate;

	@FindBy (xpath = "//*[@name='prevMovedPostCode']")
	WebElement prevAddPostCode;

	@FindBy (xpath = "//button[contains(text(),'Find')][@aria-controls='find2']")
	WebElement prevAddPostCodeFind;

	@FindBy (xpath = "//*[@id='prevMovedAddressList']")
	WebElement prevAddList;

	@FindBy (xpath = "//label[contains(text(),'Enter your moved in date*')]")
	WebElement labelCurentMoveInDate;

	@FindBy (xpath = "//label[contains(text(),'Moved in date*')]")
	WebElement lablePrevMoveInDate;

	@FindBy (xpath = "//label[contains(text(),'Moved out date*')]")
	WebElement labelPrevMoveOutDate;

	public void landlord_section(String ll_PCode, String ll_Address, String ll_Fax, 
			String ll_Title, String ll_Name, String ll_Surname,
			String ll_PhoneNo, String ll_MobileNo, String ll_EmailAdd) 
	{
		wait = new WebDriverWait(driver, 100);
		lLpostcode.sendKeys(ll_PCode);
		lLpostcodeFind.click();

		wait.until(ExpectedConditions.visibilityOf(lLAddlist));
		//wait.until(ExpectedConditions.invisibilityOf(loader));
		select = new Select(lLAddlist);
		select.selectByVisibleText(ll_Address);

		fax.sendKeys(ll_Fax);


		select = new Select(lLTitle);
		select.selectByVisibleText(ll_Title);

		lLFirstName.sendKeys(ll_Name);

		lLSurname.sendKeys(ll_Surname);

		lLPhone.sendKeys(ll_PhoneNo);

		lLMobile.sendKeys(ll_MobileNo);

		lLEmail.sendKeys(ll_EmailAdd);
	} 


	public void letting_agent_section(String la_Name, String la_Postcode, String la_Address, 
			String la_Fax, String la_Titile, String la_FName, 
			String la_lName, String la_Phone, String la_Mobile, 
			String la_Email ) 
	{
		wait = new WebDriverWait(driver, 100);

		lettingAgentName.sendKeys(la_Name);

		lettingAgentPostCode.sendKeys(la_Postcode);
		lAFindButton.click();
		wait.until(ExpectedConditions.visibilityOf(lettingAgentAddList));
		Select LAList = new Select(lettingAgentAddList);
		LAList.selectByVisibleText(la_Address);

		fax.sendKeys(la_Fax);

		select = new Select(lettingAgentTitle);
		select.selectByVisibleText(la_Titile);

		agentFirstName.sendKeys(la_FName);

		agentSurName.sendKeys(la_lName);

		agentPhone.sendKeys(la_Phone);

		agentMobile.sendKeys(la_Mobile);

		agentEmail.sendKeys(la_Email);

	}	


	public void enter_accommodation_details(String m_Rent, String p_Type) 
	{
		monthlyRent.sendKeys(m_Rent);

		select =new Select(rentPayment);
		select.selectByVisibleText(p_Type);
	}	



	public void enter_bank_info(String s_Code, String a_No) 
	{
		sortCode.sendKeys(s_Code);

		accNo.sendKeys(a_No);
	}



	public void enter_current_address_info(String c_PostCode, String c_Address, String c_MoveIn) 
	{
		wait = new WebDriverWait(driver, 100);
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
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}

	public void address_you_were_renting(String p_MoveIn, String p_MoveOut, String p_Postcode, String p_Address) 
	{
		wait = new WebDriverWait(driver, 100);
		prevMoveInDate.clear();
		prevMoveInDate.sendKeys(p_MoveIn);
		lablePrevMoveInDate.click();

		PrevMoveOutDate.clear();	
		PrevMoveOutDate.sendKeys(p_MoveOut);
		labelPrevMoveOutDate.click();

		prevAddPostCode.sendKeys(p_Postcode);
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",prevAddPostCodeFind);

		//PrevAddPostCodeFind.click();
		wait.until(ExpectedConditions.visibilityOf(prevAddList));
		select= new Select(prevAddList);
		select.selectByVisibleText(p_Address);

	}

	//Friends And Family Yes LA		
	public StepThreePage FriendsAndFamilyYesLA(String c_LivivngWith, String c_PostCode, String c_Address, 
			String c_MoveIn, String p_MoveIn, String p_MoveOut, String p_Postcode,
			String p_Address, String la_Name, String la_Postcode, String la_Address, 
			String la_Fax, String la_Titile, String la_FName, 
			String la_lName, String la_Phone, String la_Mobile, 
			String la_Email, String m_Rent, String p_Type, String s_Code, String a_No )
	{
		wait = new WebDriverWait(driver,100);

		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(accStatus));
		Select statusdrp =new Select(accStatus);
		statusdrp.selectByVisibleText(c_LivivngWith);

		wait.until(ExpectedConditions.visibilityOf(rentedLast6MonthYes));

		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",rentedLast6MonthYes);

		wait.until(ExpectedConditions.visibilityOf(lettingAgent));
		js.executeScript("arguments[0].click();",lettingAgent);


		enter_current_address_info(c_PostCode, c_Address, c_MoveIn);


		address_you_were_renting(p_MoveIn, p_MoveOut, p_Postcode, p_Address);


		letting_agent_section(la_Name, la_Postcode, la_Address, la_Fax,  la_Titile,  la_FName, 
				la_lName,  la_Phone,  la_Mobile, la_Email);


		enter_accommodation_details(m_Rent, p_Type);


		enter_bank_info(s_Code, a_No);


		updateButton.sendKeys(Keys.RETURN);

		return new StepThreePage();
	}


	//Friends And Family Yes LL		
	public StepThreePage FriendsAndFamilyYesLL(String c_LivivngWith, String c_PostCode, String c_Address, 
			String c_MoveIn, String p_MoveIn, String p_MoveOut, String p_Postcode,
			String p_Address, String ll_PCode, String ll_Address, String ll_Fax, 
			String ll_Title, String ll_Name, String ll_Surname,
			String ll_PhoneNo, String ll_MobileNo, String ll_EmailAdd, String mo_Rent, String p_Type, String s_Code, String a_No )
	{
		wait = new WebDriverWait(driver,100);

		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(accStatus));
		Select statusdrp =new Select(accStatus);
		statusdrp.selectByVisibleText(c_LivivngWith);

		wait.until(ExpectedConditions.visibilityOf(rentedLast6MonthYes));

		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",rentedLast6MonthYes);

		wait.until(ExpectedConditions.visibilityOf(landlord));
		js.executeScript("arguments[0].click();",landlord);


		enter_current_address_info(c_PostCode, c_Address, c_MoveIn);


		address_you_were_renting(p_MoveIn, p_MoveOut, p_Postcode, p_Address);


		landlord_section(ll_PCode, ll_Address,  ll_Fax, ll_Title,  ll_Name, ll_Surname, ll_PhoneNo,  ll_MobileNo,  ll_EmailAdd); 


		enter_accommodation_details(mo_Rent, p_Type);


		enter_bank_info(s_Code, a_No);


		updateButton.sendKeys(Keys.RETURN);

		return new StepThreePage();
	}

	public StepThreePage CurrentlyRentingLettingAgent(String c_LivivngWith, String c_PostCode, String c_Address, 
			String c_MoveIn, String la_Name, String la_Postcode, String la_Address, 
			String la_Fax, String la_Titile, String la_FName, 
			String la_lName, String la_Phone, String la_Mobile, 
			String la_Email, String m_Rent, String p_Type, String s_Code, String a_No)
	{
		wait = new WebDriverWait(driver,100);
		js = (JavascriptExecutor)driver;
		
		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(accStatus));
		select  = new Select(accStatus);
		select.selectByVisibleText(c_LivivngWith);

		wait.until(ExpectedConditions.visibilityOf(lettingAgent));
		js.executeScript("arguments[0].click();",lettingAgent);
		
		enter_current_address_info(c_PostCode, c_Address, c_MoveIn);


		letting_agent_section(la_Name, la_Postcode, la_Address, la_Fax,  la_Titile,  la_FName, 
				la_lName,  la_Phone,  la_Mobile, la_Email);


		enter_accommodation_details(m_Rent, p_Type);


		enter_bank_info(s_Code, a_No);


		updateButton.sendKeys(Keys.RETURN);


		return new StepThreePage();
	}
	
	
	

	public StepThreePage CurrentlyRentingLandlord(String c_LivivngWith, String c_PostCode, String c_Address, 
			String c_MoveIn, String ll_PCode, String ll_Address, String ll_Fax, 
			String ll_Title, String ll_Name, String ll_Surname,
			String ll_PhoneNo, String ll_MobileNo, String ll_EmailAdd, String mo_Rent, String p_Type, String s_Code, String a_No )
	{
		wait = new WebDriverWait(driver,100);
		js = (JavascriptExecutor)driver;
		
		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(accStatus));
		select  = new Select(accStatus);
		select.selectByVisibleText(c_LivivngWith);

		wait.until(ExpectedConditions.visibilityOf(landlord));
		js.executeScript("arguments[0].click();",landlord);

		enter_current_address_info(c_PostCode, c_Address, c_MoveIn);
		

		landlord_section(ll_PCode, ll_Address,  ll_Fax, ll_Title,  ll_Name, ll_Surname, ll_PhoneNo,  ll_MobileNo,  ll_EmailAdd); 


		enter_accommodation_details(mo_Rent, p_Type);


		enter_bank_info(s_Code, a_No);


		updateButton.sendKeys(Keys.RETURN);

		return new StepThreePage();

	}
	
	
}
