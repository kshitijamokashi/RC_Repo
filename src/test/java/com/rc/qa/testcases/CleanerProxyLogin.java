//Created By Swapnil

package com.rc.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rc.qa.base.TestBase;
import com.rc.qa.pages.AdminCleanerListingPage;
import com.rc.qa.pages.LoginPage;
import com.rc.qa.util.TestUtil;


public class CleanerProxyLogin extends TestBase 
{
	
	 
	public CleanerProxyLogin()
	{
		super();
	}
	@DataProvider
	public Object[][] getCleanersEmail()
	{
		Object data[][] = TestUtil.getTestData("CleanerData");
		return data;
	}

	@Test(dataProvider = "getCleanersEmail")
	public void cleanerProxyLogin(String email) throws InterruptedException 
	{
		
		
	AdminCleanerListingPage adminCleanerListingPage = new AdminCleanerListingPage();	
	adminCleanerListingPage.cleanerProxyLogin(email);

	}

	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		initialization();
	
//		AdminLoginPage adminloginpage = new AdminLoginPage();
//		adminloginpage.adminLoginPage(prop.getProperty("username"), prop.getProperty("password"));
		
		

	}

	@AfterMethod
	public void tearDown() 
	{
//		driver.quit();
	}
}