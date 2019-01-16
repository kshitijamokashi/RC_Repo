package com.uktd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.AgentTransactionPage;
import com.uktd.qa.pages.CompleteApplication;
import com.uktd.qa.pages.CreateApplicationPage;
import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.OpenApplicationPage;
import com.uktd.qa.pages.QuickStepOnePage;
import com.uktd.qa.pages.StepFourPage;
import com.uktd.qa.pages.StepThreePage;
import com.uktd.qa.pages.StepTwoPage;
import com.uktd.qa.util.TestUtil;

public class AgentToPurAgentFillTest extends TestBase 
{
	LoginPage loginpage;
	OpenApplicationPage openApplication;
	CreateApplicationPage createApplication;
	QuickStepOnePage quickstepOnePage;
	StepTwoPage stepTwoPage;
	StepThreePage stepThreePage;
	StepFourPage stepFourPage;
	CompleteApplication completeApplication;
	AgentTransactionPage agentTransactionPage;

	
	public AgentToPurAgentFillTest()
	{
		super();
	}
	
 
	
	@DataProvider
	public Object[][] getAddAgentToPurchaseFRApplicantData()
	{
		Object data[][] = TestUtil.getTestData("DataPool2");
		return data;
	}



  @Test(dataProvider = "getAddAgentToPurchaseFRApplicantData")
  public void FullReportAgentToPurAgentFill(String f_Report, String p_method, String filledBy, 
											String p_Code, String a_Address, String d_MoveIn,
											String t_Period, String m_Rent, String r_Share, String a_Title, String a_Name,
											String a_MiddleName, String a_SurName, String a_MaidenName, 
											String a_DOB, String m_Status, String h_Phone, String w_Phone,String a_Mobile, String e_Mail,
											String e_MailConfirm, String a_Proof, String no_Child, String no_ChildOver18) 
  {
	  createApplication = new CreateApplicationPage();
	  createApplication.FullReportAgentToPurAgentFill(f_Report, p_method, filledBy, p_Code, a_Address, d_MoveIn, t_Period, m_Rent);
	  
	  quickstepOnePage = new QuickStepOnePage();
	  quickstepOnePage.FillQuickStepOneFullReport(r_Share, a_Title, a_Name, a_MiddleName, a_SurName, a_MaidenName,a_DOB, m_Status, h_Phone, w_Phone, a_Mobile, e_Mail, e_MailConfirm, a_Proof, no_Child, no_ChildOver18);
	  
	  stepTwoPage = new StepTwoPage();
	  stepTwoPage.FriendsAndFamilyYesLA();
	  
	  stepThreePage = new StepThreePage();
	  stepThreePage.fillStepThree();
	  
	  stepFourPage = new StepFourPage();
	  stepFourPage.unemployed();
	  
	  completeApplication = new CompleteApplication();
	  completeApplication.finishApplication();
	  
	  openApplication = new OpenApplicationPage();
	  String ApplicantId =  openApplication.getApplicantID();
	  openApplication.agentTransaction();
	  
	  agentTransactionPage = new AgentTransactionPage();
	  String [] transValue = agentTransactionPage.getAgentToPurchaseTransation(ApplicantId);
	  
	  Assert.assertEquals(transValue[0],"Agent Purchase -Full Report-"+a_Name+" "+ a_MiddleName+" "+ a_SurName+"("+ApplicantId+")");
	  Assert.assertEquals(transValue[1], "1");
	  Assert.assertEquals(transValue[2], "10.00");
	  Assert.assertEquals(transValue[3], "2.00");
	  Assert.assertEquals(transValue[4], "12.00");
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
	  driver.close();
  }

}
