package com.uktd.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.uktd.qa.base.TestBase;

public class OpenApplicationPage extends TestBase
{
	public OpenApplicationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//*[contains(text(), 'Open Application')]")
	WebElement header;
	
	@FindBy(xpath = "//*[contains(text(),'LOGOUT')]")
	WebElement logout;

	
	@FindBy (xpath ="//*[@name = 'searchTextall']")
	WebElement globalSearchText;
	
	@FindBy (xpath = "//button[@class='input-group-addon']")
	WebElement globalSearchBtn;
	
	@FindBy (xpath = "//a[@tabindex ='-1']")
	WebElement searchResult;
	
	@FindBy (xpath = "//span[@class='icon-user-plus']")
	WebElement addApplicant;
	
	@FindBy (xpath ="//span[@class='lnr lnr-pencil']")
	WebElement editApplication;
	
	@FindBy (xpath= "//i[@class='icon-clipboard-text ng-scope']")
	WebElement taskList;
	
	@FindBy (xpath = "//span[@class='lnr lnr-envelope black']")
	WebElement msgApplicant;
	
	@FindBy (xpath = "//*[@id='exp']")
	WebElement expandApplication;
	
	@FindBy (xpath = "//div[@class='sidebar-nav']")
	WebElement sideMenu;
	
	
	@FindBy (xpath = "//*[@id='progressing']")
	WebElement loader;
	
	@FindBy (xpath = "//div[@class='sidebar clearfix ng-scope']//child::a[@href='#/createApplication']")
	WebElement newApplication;
	
	@FindBy (xpath = "//td[@data-title='ID Ref']")
	WebElement appID;
	
	@FindBy(xpath = "//*[contains(text(),'LOGOUT')]")
	WebElement Logout;

	@FindBy (xpath = "//div[@class='sidebar clearfix ng-scope']//child::a[@href='#agentTransactions']")
	WebElement account_Transaction;
	
	@FindBy (xpath = "//*[@id='exp']")
	WebElement ExpandApplication;
	
	
	@FindBy (xpath = "//*[@id='no-more-tables']/table/tbody/tr[1]/td[13]/div/a/span")
	WebElement OpenMessagePopUp;
	
	@FindBy (xpath = "//*[@id='modal-body']/div[1]/div[2]/ul/li[4]/span[2]")
	WebElement ApplicantMailID;
	
	
	@FindBy (xpath = "//*[@id='ddlmsgtype']")
	WebElement MessageTypeDrp;
	
	@FindBy (xpath = "//*[@id='pnlLink']/div/div[1]/label")
	WebElement URL;
	
	@FindBy(xpath = "//*[@id='sendMessageModal']/div[4]/button[1]")
	WebElement PopUpClose;
	
	@FindBy (xpath= "//td[@data-title='Submitted']")
	WebElement submmitted_Status;
	

	@FindBy (xpath= "//td[@data-title='Name']")
	WebElement app_Name;
	
	
	@FindBy (xpath= "//td[@data-title='Recommendation']")
	WebElement recommendation_Status;
	
	
	
	
	
	public void pageHeaderTest()
	{
		Assert.assertTrue(header.isDisplayed());
	}
	
	
	
	public String getPageHeader()
	{
		String PageHeader = header.getText();
		return PageHeader;
	}
	
	
	
	public String getApplicantID()
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		expandApplication.click();
		String ApplicantID = appID.getText();
		return ApplicantID;
	}
	
	
	
	
	public  CreateApplicationPage newApplicationPage()
	{
		action = new Actions(driver);
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(sideMenu));
		action.moveToElement(sideMenu).build().perform();
		wait.until(ExpectedConditions.visibilityOf(newApplication));
		newApplication.click();
		return new CreateApplicationPage();
	}
	
	
	public AgentTransactionPage agentTransaction()
	{
		action = new Actions(driver);
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		wait.until(ExpectedConditions.visibilityOf(sideMenu));
		action.moveToElement(sideMenu).build().perform();
		wait.until(ExpectedConditions.visibilityOf(account_Transaction));
		account_Transaction.click();
		return new AgentTransactionPage();
	}
	
	public String getApplicantFillURL()
	{
		WebDriverWait wait = new WebDriverWait(driver, 400);	
		wait.until(ExpectedConditions.invisibilityOf(loader));
		ExpandApplication.click();
		OpenMessagePopUp.click();
		wait.until(ExpectedConditions.invisibilityOf(loader));
		ApplicantMailID.click();
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		select =new Select(MessageTypeDrp);
		select.selectByVisibleText("Resend Application Completion Link");
		
		String U_R_L = URL.getText();
		PopUpClose.click();
		wait.until(ExpectedConditions.invisibilityOf(Logout));
		Logout.sendKeys(Keys.RETURN);
		return U_R_L;
		
	}
	
	public void verifyFullReportFilling()
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		expandApplication.click();
		
		String submitted_Text = submmitted_Status.getText();
		String recommandation_Text = recommendation_Status.getText();
		
		Assert.assertEquals(submitted_Text, "Awaiting Processor Assignment");
		Assert.assertEquals(recommandation_Text, "Pending Decision");
	}
	
	public void verifyCreditReportFilling()
	{
		wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOf(loader));
		
		expandApplication.click();
		
		String submitted_Text = submmitted_Status.getText();
		String recommandation_Text = recommendation_Status.getText();
		
		Assert.assertEquals(submitted_Text, "Credit Report Only ");
	//	Assert.assertEquals(recommandation_Text, "Pending Decision");
	}
}
