package com.uktd.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.AddAgentPage;
import com.uktd.qa.pages.AgentManagement;
import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.UnassignedApplicant;
import com.uktd.qa.util.TestUtil;

public class AddAgentTest extends TestBase 
{
	LoginPage loginpage;
	UnassignedApplicant unassignedApplicant;
	AgentManagement agentManagement;
	AddAgentPage addAgentPage;
	
	public AddAgentTest()
	{
		super();
	}
	
	@DataProvider
	public Object[][] getAddAgentTestData()
	{
		Object data[][] = TestUtil.getTestData("DataPool1");
		return data;
	}
	
	
	
  @Test(dataProvider = "getAddAgentTestData")
  public void addAgentTest(String Company_Name, String Postal_Code, String Company_address, String TelephoneNo, String emailId, String WebSite) 
  {
	  addAgentPage = new AddAgentPage();
	  addAgentPage.addAgent(Company_Name, Postal_Code, Company_address, TelephoneNo, emailId, WebSite);
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
	agentManagement.addAgent();
	
  }

  @AfterMethod
  public void tearDown() 
  {
	  driver.quit();
  }
}
