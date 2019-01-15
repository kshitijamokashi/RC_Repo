package com.uktd.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.CompleteApplication;
import com.uktd.qa.pages.CreateApplicationPage;
import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.OpenApplicationPage;
import com.uktd.qa.pages.QuickStepOnePage;
import com.uktd.qa.pages.StepFourPage;
import com.uktd.qa.pages.StepThreePage;
import com.uktd.qa.pages.StepTwoPage;

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
	
	public AgentToPurAgentFillTest()
	{
		super();
	}
	
  @Test
  public void FullReportAgentToPurAgentFill() 
  {
	  createApplication = new CreateApplicationPage();
	  createApplication.FullReportAgentToPurAgentFill();
	  
	  quickstepOnePage = new QuickStepOnePage();
	  quickstepOnePage.FillQuickStepOneFullReport();
	  
	  stepTwoPage = new StepTwoPage();
	  stepTwoPage.FriendsAndFamilyYesLA();
	  
	  stepThreePage = new StepThreePage();
	  stepThreePage.fillStepThree();
	  
	  stepFourPage = new StepFourPage();
	  stepFourPage.unemployed();
	  
	  completeApplication = new CompleteApplication();
	  completeApplication.finishApplication();
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
  }

}
