package com.uktd.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.CompleteApplication;
import com.uktd.qa.pages.CreateApplicationPage;
import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.OpenApplicationPage;
import com.uktd.qa.pages.QuickStepOnePage;
import com.uktd.qa.util.TestUtil;

public class AgentToPurAgentFillCRTest extends TestBase
{

	LoginPage loginpage;
	OpenApplicationPage openApplication;
	CreateApplicationPage createApplication;
	QuickStepOnePage quickstepOnePage;
	CompleteApplication completeApplication;
	
	
	public AgentToPurAgentFillCRTest()
	{
		super();
	}


	@DataProvider
	public Object[][] getAgentToPurchaseCRApplicantData()
	{
		Object data[][] = TestUtil.getTestData("AgToPurAgFillCR");
		return data;
	}



	@Test(dataProvider = "getAgentToPurchaseCRApplicantData")
	public void AgentToPurAgentFillCR(String f_Report, String p_method, String filledBy, 
			String p_Code, String a_Address, String d_MoveIn,
			String t_Period, String m_Rent, String r_Share, String a_Title, String a_Name,
			 String a_MiddleName, String a_SurName, 
			 String a_MaidenName, String a_DOB, String m_Status, 
			 String h_Phone, String w_Phone,String a_Mobile, String e_Mail,
			 String e_MailConfirm, String a_Proof, String s_Code, String a_No,
			 String c_PostCode, String c_Address, String c_MoveIn, String no_Child, String no_ChildOver18) 
	{

		createApplication = new CreateApplicationPage();
		createApplication.FullReportAgentToPurAgentFill(f_Report, p_method, filledBy, p_Code, a_Address, d_MoveIn, t_Period, m_Rent);

		quickstepOnePage = new QuickStepOnePage();
		quickstepOnePage.AgentFillQuickStepOneCreditReport(r_Share, a_Title, a_Name, a_MiddleName, a_SurName, a_MaidenName, a_DOB, m_Status, 
														   h_Phone, w_Phone, a_Mobile, e_Mail, e_MailConfirm, a_Proof, s_Code, a_No, c_PostCode, 
														   c_Address, c_MoveIn, no_Child, no_ChildOver18);
		
		completeApplication = new CompleteApplication();
		completeApplication.finishApplication();
		
		openApplication.verifyCreditReportFilling();
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
