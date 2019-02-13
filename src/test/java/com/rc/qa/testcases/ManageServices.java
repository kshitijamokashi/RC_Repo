package com.rc.qa.testcases;





//Created By Swapnil

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rc.qa.base.TestBase;
import com.rc.qa.pages.AdminCleanerListingPage;
import com.rc.qa.pages.ManageServicesPage;
import com.rc.qa.pages.LoginPage;
import com.rc.qa.util.TestUtil;


public class ManageServices  extends TestBase 
{
	
	 
	public ManageServices()
	{
		super();
	}
	@DataProvider
	public Object[][] getServiceData()
	{
		Object data[][] = TestUtil.getTestData("ServiceData");
		return data;
	}

	@Test(dataProvider = "getServiceData")
	public void manageServices(String serviceName, String calculateDate, String updateServiceName) throws InterruptedException 
	{
		
		ManageServicesPage cleanerPage = new ManageServicesPage();
		cleanerPage.addService(serviceName, calculateDate);
		cleanerPage.editService(serviceName, updateServiceName);
		cleanerPage.deactivateService(updateServiceName);
		cleanerPage.activateService(updateServiceName);
		cleanerPage.deleteService(updateServiceName);
	}

	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		initialization();
		Login loginObj = new Login();
		loginObj.login();
	
	
		
		
		

	}

	@AfterMethod
	public void tearDown() 
	{
//		driver.quit();
	}
}