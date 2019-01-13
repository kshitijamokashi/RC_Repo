package com.uktd.qa.testcases;

import org.testng.annotations.Test;

import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.IncompleteApplicant;
import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.UnassignedApplicant;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class UnassignedPageTest extends TestBase
{
	IncompleteApplicant incompleteApplicantListing;
	LoginPage loginpage;
	UnassignedApplicant unassignedApplicant;
	
	
	public UnassignedPageTest()
	{
		super();
	}
	
	
  @Test(enabled = false)
  public void PageNameTest () 
  {
	  unassignedApplicant = new UnassignedApplicant();
	  unassignedApplicant.pageHeaderTest();
  }
  
  @Test(priority = 2)
  public void goToIncompleteApplicantListing()
  {
	  unassignedApplicant = new UnassignedApplicant();
	  incompleteApplicantListing =  unassignedApplicant.openIncompleteApplicantListing();
	  
  }
  
  
  @BeforeMethod
  public void setUp() 
  {
	initialization();
	loginpage = new LoginPage();
	loginpage.login(prop.getProperty("Admin_username"), prop.getProperty("Admin_password"));
	
  }

  @AfterMethod
  public void tearDown() 
  {
	  driver.quit();
  }

}
