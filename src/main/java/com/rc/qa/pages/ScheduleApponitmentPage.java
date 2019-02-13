package com.rc.qa.pages;

import static org.testng.Assert.assertTrue;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rc.qa.base.TestBase;

public class ScheduleApponitmentPage extends TestBase {
	public ScheduleApponitmentPage() {
		PageFactory.initElements(driver, this);
	}

	// Add service pop up
	@FindBy(xpath = "//*[@class='sub-nav']//*[text()='Dashboard']")
	WebElement dashboardSubnavigation;
	
	@FindBy(xpath = "//li[@title='Schedule Appointments']")
	WebElement icon_SchduleAppointment;
	
	@FindBy(xpath = "//select[@id='PropertyList_0']")
	WebElement dropdown_Properties;
	
	@FindBy(xpath = "//select[@id='ha_list_0']")
	WebElement dropdown_HA;
	
	@FindBy(xpath = "//select[@id='housekeeper_list_0']")
	WebElement dropdown_HK;
	
	@FindBy(xpath = "//select[@id='inspector_0']")
	WebElement dropdown_Inpector;
	
	@FindBy(xpath = "//input[@id='resnum_0']")
	WebElement textbox_reservationId;
	
	@FindBy(xpath = "//input[@id='nwarr_0']")
	WebElement textbox_newArrivalDate;

	@FindBy(xpath = "//input[@id='apptdate_0']")
	WebElement textbox_appDate;

	@FindBy(xpath = "//select[@id='ServicesList_0']")
	WebElement dropdown_service;
	
	@FindBy(xpath = "//input[@id='chkSame_0']")
	WebElement checkbox_TA;
	
	@FindBy(xpath = "//input[@id='qc_0']")
	WebElement checkbox_QC;
	
	@FindBy (xpath = "//div[@class='top-nav']//child::ul//child::li//child::span[contains(text(),'Appointment')]")
	WebElement tab_Apponitments;
	
	@FindBy(xpath = "//button[contains(text(), 'Schedule')]")
	WebElement button_Schedule;
	
	public void scheduleAppointment(String property, String HK, String service) throws InterruptedException {
		// Wait for page load
		waitTillElemenyVisibility(dashboardSubnavigation);
		
		//navigate To Scheduling Page
		clickOnElement(icon_SchduleAppointment);
		
		dismissAlertify();
		
		//schedule appointment
//		selectFromDropDown(dropdown_Properties, property);
//		selectFromDropDown(dropdown_HK, HK);
//		enterText(textbox_appDate, getTodayesDateFormatted());
//		selectFromDropDown(dropdown_service, service);
//		
//		clickOnElement(button_Schedule);
		clickOnElement(tab_Apponitments);
		
		
		
		

		

		
	}

}
