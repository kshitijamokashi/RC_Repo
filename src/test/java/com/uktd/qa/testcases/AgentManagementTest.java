package com.uktd.qa.testcases;

import org.testng.annotations.Test;

import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.AgentManagement;

import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.UnassignedApplicant;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AgentManagementTest extends TestBase
{
	
	
	LoginPage loginpage;
	UnassignedApplicant unassignedApplicant;
	AgentManagement agentManagement;
	
	
	public AgentManagementTest()
	{
		super();
	}
	
  @Test
  public void f() {
  }
  
  
  @BeforeMethod
  public void setUp() 
  {
	initialization();
	loginpage = new LoginPage();
	loginpage.login(prop.getProperty("Admin_username"), prop.getProperty("Admin_password"));
	unassignedApplicant = new UnassignedApplicant();
	unassignedApplicant.openAgentManagement();
	agentManagement = new AgentManagement();
	
  }

  @AfterMethod
  public void tearDown() 
  {
	//  driver.quit();
  }
}
