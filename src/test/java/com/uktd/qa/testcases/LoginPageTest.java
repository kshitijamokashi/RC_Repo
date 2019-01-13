package com.uktd.qa.testcases;



import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.OpenApplication;
import com.uktd.qa.pages.UnassignedApplicant;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	OpenApplication openApplication;
	UnassignedApplicant unassignedApplicant;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	
	@Test
	public void agentLoginPageFunction() 
	{
	  loginPage = new LoginPage();
	  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 // return new OpenApplication();
	  openApplication = new OpenApplication();
	  String Header = openApplication.getPageHeader();
//	  Assert.assertEquals(Header,"Open Applications");
	 Assert.assertTrue(Header.contains("Open Applications"));
	}
  
	@Test
	public void processorLoginPageFunction() 
	{
	  
	  loginPage = new LoginPage();
	  loginPage.login(prop.getProperty("Admin_username"), prop.getProperty("Admin_password"));
	  unassignedApplicant = new UnassignedApplicant();
	  String Header = unassignedApplicant.getPageHeader();
	  Assert.assertEquals(Header, "Unassigned Applicants");
	}
  
  
  

	@BeforeMethod
	  public void setUp() 
	  {
		initialization();
		 //loginPage = new LoginPage();
	  }

  
  @AfterMethod
  public void tearDown() 
  {
	  driver.quit();
  }

}
