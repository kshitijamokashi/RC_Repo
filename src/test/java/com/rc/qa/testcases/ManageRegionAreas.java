package com.rc.qa.testcases;





//Created By Swapnil

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.rc.qa.base.TestBase;
import com.rc.qa.pages.ManageRegionsAreasPage;
import com.rc.qa.util.TestUtil;


public class ManageRegionAreas  extends TestBase 
{
	
	 
	public ManageRegionAreas()
	{
		super();
	}
	@DataProvider
	public Object[][] getRegionAreaData()
	{
		Object data[][] = TestUtil.getTestData("RegionAreaData");
		return data;
	}

	@Test(dataProvider = "getRegionAreaData")
	public void manageRegionArea(String regionName) throws InterruptedException 
	{
		
		ManageRegionsAreasPage regionAreasPage = new ManageRegionsAreasPage();
		regionAreasPage.addRgion(regionName);
//		regionAreasPage.editService(serviceName, updateServiceName);
//		regionAreasPage.deactivateService(updateServiceName);
//		regionAreasPage.activateService(updateServiceName);
//		regionAreasPage.deleteService(updateServiceName);
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