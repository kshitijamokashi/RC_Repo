package com.uktd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.IncompleteApplicant;
import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.UnassignedApplicant;

public class IncompleteApplicantTest extends TestBase {
  
	IncompleteApplicant incompleteApplicantListing;
	LoginPage loginpage;
	UnassignedApplicant unassignedApplicant;
	
	
	public IncompleteApplicantTest()
	{
		super();
	}
	
	
 
  
  @Test(priority = 1)
  public void sendmailtofillapplication()
  {
	  incompleteApplicantListing = new IncompleteApplicant();
	  incompleteApplicantListing.checkCheckbox("495812");
	Assert.assertEquals(incompleteApplicantListing.getCreatedDate("495812"), "24/12/2018");
  }
  
  
  @BeforeMethod
  public void setUp() 
  {
	initialization();
	loginpage = new LoginPage();
	loginpage.login(prop.getProperty("Admin_username"), prop.getProperty("Admin_password"));
	unassignedApplicant = new UnassignedApplicant();
	incompleteApplicantListing =  unassignedApplicant.openIncompleteApplicantListing();
  }

  @AfterMethod
  public void tearDown() 
  {
	//  driver.quit();
  }
}
