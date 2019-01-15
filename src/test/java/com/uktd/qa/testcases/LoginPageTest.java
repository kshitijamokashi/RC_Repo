package com.uktd.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.OpenApplicationPage;
import com.uktd.qa.pages.UnassignedApplicant;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	OpenApplicationPage openApplication;
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
	  openApplication = new OpenApplicationPage();
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
