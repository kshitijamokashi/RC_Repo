package com.rc.qa.testcases;


import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rc.qa.base.TestBase;
import com.rc.qa.pages.ScheduleApponitmentPage;
import com.rc.qa.util.TestUtil;

public class ScheduleAppointment extends TestBase {
	public ScheduleAppointment()
	{
		super();
	}
	@DataProvider
	public Object[][] getAppointmentData()
	{
		Object data[][] = TestUtil.getTestData("ApponitmentData");
		return data;
	}

	@Test(dataProvider = "getAppointmentData")
	public void schduleAppointment(String property, String HK, String service) throws InterruptedException 
	{
		
		ScheduleApponitmentPage scheduling = new ScheduleApponitmentPage();
		scheduling.scheduleAppointment(property, HK, service);
		
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
