package com.uktd.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uktd.qa.base.TestBase;

public class CompleteApplication extends TestBase
{
	public CompleteApplication()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//button[contains(text(),'Finish')]")
	WebElement finishButton;
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement addAnother;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Finish')][1]")
	WebElement popupFinish;
	
	@FindBy(xpath = "html/body/div[6]/div/div/div[3]/button[1]")
	WebElement popupCancel;
	
	@FindBy(xpath = "//*[@href='#/openapplications']")
	WebElement openapplication;
	
	@FindBy (xpath = "//div[@class='sidebar-nav']")
	WebElement sideMenu;
	
	@FindBy (xpath = "//*[@id='progressing']")
	WebElement loader;
			
	public void finishApplication() {
	wait = new WebDriverWait(driver, 100);

	finishButton.sendKeys(Keys.RETURN);
	wait.until(ExpectedConditions.visibilityOf(popupFinish));
	popupFinish.sendKeys(Keys.RETURN);
	
	wait.until(ExpectedConditions.invisibilityOf(loader));
	sideMenu.click();
	wait.until(ExpectedConditions.visibilityOf(openapplication));
	openapplication.click();
	}
	
	
}
