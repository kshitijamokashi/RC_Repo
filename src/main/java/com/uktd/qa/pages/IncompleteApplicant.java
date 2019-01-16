package com.uktd.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uktd.qa.base.TestBase;

public class IncompleteApplicant extends TestBase 
{
	public String date;
	public IncompleteApplicant()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//*[contains(text(),'Incomplete Applicants')]")
	WebElement pageHeader;
	
	@FindBy (xpath = "//label[text()='Payment Status']")
	WebElement paymentStatus;
	
	
	public void checkCheckbox(String id)
	{
		paymentStatus.click();
		wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+id+"')]//parent::td[@data-title='Id']//preceding-sibling::td[@data-title='Select']//input[@type='checkbox']")));
		
		driver.findElement(By.xpath("//*[contains(text(),'"+id+"')]//parent::td[@data-title='Id']//preceding-sibling::td[@data-title='Select']//input[@type='checkbox']")).click();
	}
	

	
	public String getCreatedDate(String id)
	{
		 date = driver.findElement(By.xpath("//*[contains(text(),'495807')]//parent::td[@data-title='Id']//following-sibling::td[@data-title='Created']")).getText();
				return date;
	}
}
