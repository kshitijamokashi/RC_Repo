package com.rc.qa.pages;



import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rc.qa.base.TestBase;
import com.rc.qa.util.TestUtil;

public class ManageServicesPage extends TestBase
{

	public ManageServicesPage() {
		PageFactory.initElements(driver, this);
	}

	// Add service pop up
	@FindBy(xpath = "//*[@id='sidebar']")
	WebElement sidebar;

	@FindBy(xpath = "//span[contains(text(),'Setup')]")
	WebElement tab_setUp;
	
	@FindBy(xpath = "//span[@class='nav-txt'][contains(text(), 'Services')]")
	WebElement link_services;

	@FindBy(xpath = "//span[@class='label label-success pull-right']")
	WebElement button_addServices;

	@FindBy(xpath = "//form[@name='frmCleaningServices']")
	WebElement form_addServices;

	@FindBy(xpath = "//input[@name='cleaning_type']")
	WebElement textbox_enterService;

	@FindBy(xpath = "//div[@class='can-toggle__switch']")
	WebElement check_dateCalculation;

	@FindBy(xpath = "//button[@type='submit'][contains(text(), 'Add')]")
	WebElement button_Add;

	@FindBy(xpath = "//div[@class='ajs-message ajs-visible']")
	WebElement alertify_popup;

	@FindBy(xpath = "//div[@id='dismiss_maint_alert']")
	WebElement button_dismiss;

	@FindBy(xpath = "//button[contains(text(),'OK')][@class='ajs-button ajs-ok']")
	WebElement button_dismissConfirmationOK;

	// update service pop up
	@FindBy(xpath = "//input[@name='cleaning_type1']")
	WebElement textbox_updateService;

	@FindBy(xpath = "//button[@type='submit'][contains(text(), 'Save')]")
	WebElement button_update;

	// Deactivate service
	@FindBy(xpath = "//div[@class='label label-primary pull-right'][contains(text(), 'Show Inactive')]")
	WebElement button_showInactive;

	// String on navigators
//	public String ManageServiceNavigator = "Manage Services";

	public void addService(String serviceName, String calculateDate) throws InterruptedException {
		// Wait for page load
		waitTillElemenyVisibility(sidebar);

		// Navigation to add service page
		clickOnElement(tab_setUp);
		clickOnElement(link_services);
		
		// Add service
		clickOnElement(button_addServices);
		verifyElementIsDisplayed(form_addServices);
		enterText(textbox_enterService, serviceName);

		// check date calculation if true
		if (calculateDate.equalsIgnoreCase("Yes"))
			clickOnElement(check_dateCalculation);

		// add service button
		if (verifyElementIsDisplayed(alertify_popup)) {
			clickOnElement(button_dismiss);
			clickOnElement(button_dismissConfirmationOK);
		}
		Thread.sleep(4000);
		clickOnElement(button_Add);
		assertTrue(verifyTableData(serviceName));	
		}

	public void editService(String serviceName, String updateName) {

		clickOnTableActionButton(serviceName, "Edit");
		enterText(textbox_updateService, updateName);
		clickOnElement(button_update);
		assertTrue(verifyTableData(updateName));

	}

	public void deactivateService(String updateName) {

		clickOnTableActionButton(updateName, "Deactivate");
		clickOnElement(button_showInactive);
		assertTrue(verifyTableData(updateName));

	}

	public void activateService(String updateName) {

		clickOnTableActionButton(updateName, "Activate");
		assertTrue(verifyTableData(updateName));

	}

	public void deleteService(String updateName) {

		clickOnTableActionButtonWithAlert(updateName, "Delete");
		assertTrue(!verifyTableData(updateName));
	}
	
	public void verifyServiceDeleteWhenLinkedToProperty(String serviceName, String calculateDate) throws InterruptedException {

		addService(serviceName,calculateDate);
	}
	
	

}
	
