package com.uktd.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.AgentTransactionPage;
import com.uktd.qa.pages.CompleteApplication;
import com.uktd.qa.pages.CreateApplicationPage;
import com.uktd.qa.pages.EmploymentCheck;
import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.OpenApplicationPage;
import com.uktd.qa.pages.QuickStepOnePage;
import com.uktd.qa.pages.StepFivePage;
import com.uktd.qa.pages.StepFourPage;
import com.uktd.qa.pages.StepThreePage;
import com.uktd.qa.pages.StepTwoPage;
import com.uktd.qa.util.TestUtil;

public class Step2andSte4RefrenceCheck extends TestBase
{
	public Step2andSte4RefrenceCheck()
	{
		super();
	}
	
	
	LoginPage loginpage;
	OpenApplicationPage openApplication;
	CreateApplicationPage createApplication;
	QuickStepOnePage quickstepOnePage;
	StepTwoPage stepTwoPage;
	StepThreePage stepThreePage;
	StepFourPage stepFourPage;
	CompleteApplication completeApplication;
	AgentTransactionPage agentTransactionPage;
	StepFivePage stepFivePage;
	EmploymentCheck employmentCheck;
	
	@DataProvider
	public Object[][] getLettingAgentAndEmployerData()
	{
		Object data[][] = TestUtil.getTestData("LA&EmpRefCheck");
		return data;
	}

	
	
	@Test(dataProvider = "getLettingAgentAndEmployerData")
	public void RefChekofLettingAgentAndLettingAgent(String f_Report, String p_method, String filledBy, 
			String p_Code, String a_Address, String d_MoveIn,
			String t_Period, String m_Rent, String r_Share, String a_Title, String a_Name,
			String a_MiddleName, String a_SurName, String a_MaidenName, 
			String a_DOB, String m_Status, String h_Phone, String w_Phone,String a_Mobile, String e_Mail,
			String e_MailConfirm, String a_Proof, String no_Child, String no_ChildOver18,
			String c_LivivngWith, String c_PostCode, String c_Address, 
			String c_MoveIn, String la_Name, String la_Postcode, String la_Address, 
			String la_Fax, String la_Titile, String la_FName, 
			String la_lName, String la_Phone, String la_Mobile, 
			String la_Email, String mo_Rent, String p_Type, String s_Code, String a_No, 
			String k_Title, String k_Name, String k_SName, String k_PostCode, 
			String k_Address, String k_Phone, String k_Mobile, String k_Email, 
			String k_RelationShip, String k_YOK, String insurance_No, String emptype,  String c_Name, String dpartment, String c_Post, 
			 String co_Address, String c_Phone, String c_Fax, String c_Title, String c_Fname, String c_Lname, 
			 String c_Mobile, String c_Email, String position, String s_Date, String a_Salary, String a_Bonus, String f_Tax, String h_Benifits, String i_Support,
			String d_Allowance, String o_Income, String disc ) 

	{
		createApplication = new CreateApplicationPage();
		createApplication.FullReportAgentToPurAgentFill(f_Report, p_method, filledBy, p_Code, a_Address, d_MoveIn, t_Period, m_Rent);

		quickstepOnePage = new QuickStepOnePage();
		quickstepOnePage.AgentFillQuickStepOneFullReport(r_Share, a_Title, a_Name, a_MiddleName, a_SurName, a_MaidenName,a_DOB, m_Status, h_Phone,
															w_Phone, a_Mobile, e_Mail, e_MailConfirm, a_Proof, no_Child, no_ChildOver18);

		stepTwoPage = new StepTwoPage();
		stepTwoPage.CurrentlyRentingLettingAgent(c_LivivngWith, c_PostCode, c_Address, c_MoveIn, la_Name, la_Postcode, la_Address, la_Fax, la_Titile,
												la_FName, la_lName, la_Phone, la_Mobile, la_Email, mo_Rent, p_Type, s_Code, a_No);
		
		stepThreePage = new StepThreePage();
		stepThreePage.fillStepThree( k_Title, k_Name,  k_SName, k_PostCode, k_Address, k_Phone,  k_Mobile, k_Email, 
				k_RelationShip,  k_YOK);

		stepFourPage = new StepFourPage();
		stepFourPage.Employed(insurance_No, emptype, c_Name, dpartment, c_Post, co_Address, c_Phone, c_Fax, c_Title, c_Fname, c_Lname, 
				  c_Mobile, c_Email, position, s_Date, a_Salary, a_Bonus, f_Tax, h_Benifits, i_Support, d_Allowance, o_Income, disc);

		stepFivePage = new StepFivePage();
		stepFivePage.fillStepFive();
		
		
		completeApplication = new CompleteApplication();
		completeApplication.finishApplication();
		
		String EmpRefURL = openApplication.getEmploymentRefURL();
		
		//String AccRefURL =  openApplication.getAccomodationRefURL();
		
		logoutCurrentSessionandOpenNewWindow(EmpRefURL);
		
		employmentCheck = new EmploymentCheck();
		employmentCheck.verifyEmployerData(a_Name, a_SurName, c_Address, insurance_No, s_Date, position,  a_Salary, a_Bonus, c_Fname, c_Lname );
		
	}


	@BeforeMethod
	public void beforeMethod() 
	{
		initialization();

		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		openApplication = new OpenApplicationPage();
		openApplication.newApplicationPage();
	}



	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}

}
