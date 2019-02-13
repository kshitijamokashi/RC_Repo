package com.rc.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rc.qa.base.TestBase;

public class LoginPage extends TestBase
{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='rcusername']")
	WebElement email;

	@FindBy(xpath = "//*[@name='rcpassword']")
	WebElement admin_password;

	@FindBy(xpath = "//*[@id='LoginFormDetails']/button")
	WebElement login;

	@FindBy(xpath = "/html/body/header/a")
	WebElement logo;

	@FindBy(xpath = "//*[@class='sub-nav']//*[text()='Dashboard'])")
	WebElement dashboardSubnavigation;

	public boolean validateLogo() {
		return logo.isDisplayed();

	}

	public void login(String username, String password){
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(email));
		js = (JavascriptExecutor) driver;

		enterText(email, username);
		enterText(admin_password, password);
		clickOnElement(login);
	
		
	}
}
	
