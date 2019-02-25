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

public class ManageRegionsAreasPage extends TestBase
{

	public ManageRegionsAreasPage() {
		PageFactory.initElements(driver, this);
	}

	// Add service pop up
	@FindBy(xpath = "//*[@id='sidebar']")
	WebElement sidebar;
	
	@FindBy(xpath = "//span[contains(text(),'Setup')]")
	WebElement tab_setUp;
	
	@FindBy(xpath = "//span[@class='nav-txt'][contains(text(), 'Regions')]")
	WebElement link_Regions;
	
	@FindBy(xpath = "//span[contains(text(), 'Add Region')]")
	WebElement button_addRegion;
	
	@FindBy(xpath = "//input[@id='Add_Region']")
	WebElement textbox_regionName;
	
	@FindBy(xpath = "//button[@id='lodding_id1']")
	WebElement button_submitRegion;
	
	@FindBy(xpath = "//button[@class='btn clear_input_class disable_submit_btn addHideBtn']")
	WebElement button_cancelRegion;
	
	@FindBy(xpath = "//div[@class='ajs-message ajs-visible']")
	WebElement alertify_popup;

	@FindBy(xpath = "//div[@id='dismiss_maint_alert']")
	WebElement button_dismiss;

	@FindBy(xpath = "//button[contains(text(),'OK')][@class='ajs-button ajs-ok']")
	WebElement button_dismissConfirmationOK;
	
	@FindBy(xpath = "//*[@id='add_group_div_id']/label")
	WebElement popup_addREgion;
	
	
	
	

	

	// String on navigators
//	public String ManageServiceNavigator = "Manage Services";

	public void addRgion(String regionName) throws InterruptedException {
		// Wait for page load
		waitTillElemenyVisibility(sidebar);
		if (verifyElementIsDisplayed(alertify_popup)) {
			clickOnElement(button_dismiss);
			clickOnElement(button_dismissConfirmationOK);
		}
		clickOnElement(tab_setUp);
		 js.executeScript("arguments[0].scrollIntoView();",link_Regions);
		clickOnElement(link_Regions);		
		clickOnElement(button_addRegion);
		enterText(textbox_regionName, regionName);
		
		clickOnElement(button_submitRegion);
		clickOnElement(popup_addREgion);
		assertTrue(verifyTableData(regionName));
		
		
	

	}

//	public void editService(String serviceName, String updateName) {
//
//		clickOnTableActionButton(serviceName, "Edit");
//		enterText(textbox_updateService, updateName);
//		clickOnElement(button_update);
//		assertTrue(verifyTableData(updateName));
//
//	}
//
//	public void deactivateService(String updateName) {
//
//		clickOnTableActionButton(updateName, "Deactivate");
//		clickOnElement(button_showInactive);
//		assertTrue(verifyTableData(updateName));
//
//	}
//
//	public void activateService(String updateName) {
//
//		clickOnTableActionButton(updateName, "Activate");
//		assertTrue(verifyTableData(updateName));
//
//	}
//
//	public void deleteService(String updateName) {
//
//		clickOnTableActionButtonWithAlert(updateName, "Delete");
//		assertTrue(!verifyTableData(updateName));
//	}
//	
//	public void verifyServiceDeleteWhenLinkedToProperty(String serviceName, String calculateDate) throws InterruptedException {
//
//		addService(serviceName,calculateDate);
//	}
	
	

}
	
