//Created By Swapnil

package com.rc.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rc.qa.base.TestBase;
import com.rc.qa.pages.LoginPage;


public class Login extends TestBase 
{
	
	 
	LoginPage loginpage;

	public Login()
	{
		super();
	}


	@Test
	public void login() throws InterruptedException 
	{
		
		LoginPage loginpage = new LoginPage();
		if(prop.getProperty("LoginType").equalsIgnoreCase("User"))
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		else
			loginpage.login(prop.getProperty("admin_username"), prop.getProperty("admin_username"));
	
		
	}

	@BeforeMethod
	public void setUp() 
	{
		initialization();
//		

	}

	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}