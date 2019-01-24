package com.uktd.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uktd.qa.base.TestBase;

public class CreateApplicationPage extends TestBase
{
	
	public CreateApplicationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@name='officeName']")
	WebElement office;
	
	@FindBy(xpath = "//*[@name='applicationType']")
	WebElement applicationType;
	
	@FindBy(xpath = "//*[@name='reportPurchaseMethod']")
	WebElement purchaseMethod;
	
	@FindBy(xpath = "//*[@name='toCompleteApplication']")
	WebElement fillBy;
	
	@FindBy(xpath = "//*[@name='propertyAddress']")
	WebElement propertyAddress;
	
	@FindBy (xpath = "//button[contains(text(),'Find')][@aria-controls='find']")
	WebElement find;
	
	@FindBy(xpath = "//*[@id='addressList']")
	WebElement addList;
	
	@FindBy(xpath = "//*[@name='date']")
	WebElement moveInDate;
	
	@FindBy(xpath = "//*[@name='tenancyPeriod']")
	WebElement tenancyPeriod;
	
	@FindBy(xpath = "//*[@name='totalMonthlyRent']")
	WebElement monthlyRent;
	
	@FindBy(xpath = "//*[@name='rentShareAllocation']")
	WebElement rentShareAllocation;
	
	@FindBy(xpath = "//*[@id='linksendYes']")
	WebElement lLDashEnable;
	
	@FindBy(xpath = "//*[@id='linksendNo']")
	WebElement lLDashDisable;
	
	@FindBy(xpath = "//*[@ng-model='createApplication.landlordTitle']")
	WebElement lLTitle;
	
	@FindBy(xpath = "//*[@name='landLordForeName']")
	WebElement lLForeName;
	
	@FindBy(xpath = "//*[@name='landLordSurname']")
	WebElement lLSurename;
	
	@FindBy(xpath = "//*[@name='landLordPostalCode']")
	WebElement lLPostalCode;
	
	@FindBy(xpath = "//*[@name='landLordPhoneNo']")
	WebElement lLPhone;
	
	@FindBy(xpath = "//*[@name='landLordMobileNo']")
	WebElement lLMobileNo;

	@FindBy(xpath = "//*[@name='landLordEmail']")
	WebElement lLEmail;

	@FindBy(xpath = "//*[contains(text(),'Next Step')]")
	WebElement nextButton;

	@FindBy(xpath = "//*[@name='date']")
	WebElement date;

	@FindBy(xpath = "//*[@name='depositAmount']")
	WebElement depositAmount;
	
	@FindBy(xpath = "//*[@name='263']")
	WebElement enableHoldingDeposit;
	
	@FindBy(xpath = "//*[@name='264']")
	WebElement disableHoldingDeposit;
	
	@FindBy(xpath = "//*[@name='additionalFund']")
	WebElement additionalFunds;
	
	@FindBy(xpath = "//*[@name='paymentReference']")
	WebElement paymentRef;
	
	@FindBy(xpath = "//*[contains(text(),'Next Step')]")
	WebElement nextbutton;
	
	@FindBy(xpath = "//label[contains(text(),'Proposed move date*')]")
	WebElement label;
	
	public QuickStepOnePage FullReportAgentToPurAgentFill(String f_Report, String p_method, String filledBy, 
															String p_Code, String a_Address, String d_MoveIn,
															String t_Period, String m_Rent)
	{
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait (driver,100); 
		
		wait.until(ExpectedConditions.visibilityOf(applicationType));
		Select AppType = new Select(applicationType);
		AppType.selectByVisibleText(f_Report);

		wait.until(ExpectedConditions.visibilityOf(purchaseMethod));
		Select PurType = new Select(purchaseMethod);
		PurType.selectByVisibleText(p_method);
		
		Select Filling = new Select(fillBy);
		Filling.selectByVisibleText(filledBy);
		
		
		propertyAddress.sendKeys(p_Code);
		wait.until(ExpectedConditions.elementToBeClickable(find));
		
		js.executeScript("arguments[0].click();",find);
		
		wait.until(ExpectedConditions.visibilityOf(addList));
		Select List = new Select(addList);
		List.selectByVisibleText(a_Address);
		
		moveInDate.sendKeys(d_MoveIn);
		label.click();
		
		wait.until(ExpectedConditions.visibilityOf(tenancyPeriod));
		Select Period = new Select(tenancyPeriod);
		Period.selectByVisibleText(t_Period);
		
		monthlyRent.sendKeys(m_Rent);
		

		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();",lLDashDisable);
		nextbutton.sendKeys(Keys.RETURN);
		return new QuickStepOnePage();
		}
	
	
	
	public ApplicationQuickPage FullReportTenantToPurTenantFill(String f_Report, String p_method, String filledBy, 
			String p_Code, String a_Address, String d_MoveIn,
			String t_Period, String m_Rent)
	{
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait (driver,100); 
		
		wait.until(ExpectedConditions.visibilityOf(applicationType));
		Select AppType = new Select(applicationType);
		AppType.selectByVisibleText(f_Report);

		wait.until(ExpectedConditions.visibilityOf(purchaseMethod));
		Select PurType = new Select(purchaseMethod);
		PurType.selectByVisibleText(p_method);
		
		Select Filling = new Select(fillBy);
		Filling.selectByVisibleText(filledBy);
		
		
		propertyAddress.sendKeys(p_Code);
		wait.until(ExpectedConditions.elementToBeClickable(find));
		
		js.executeScript("arguments[0].click();",find);
		
		wait.until(ExpectedConditions.visibilityOf(addList));
		Select List = new Select(addList);
		List.selectByVisibleText(a_Address);
		
		moveInDate.sendKeys(d_MoveIn);
		label.click();
		
		wait.until(ExpectedConditions.visibilityOf(tenancyPeriod));
		Select Period = new Select(tenancyPeriod);
		Period.selectByVisibleText(t_Period);
		
		monthlyRent.sendKeys(m_Rent);
		

		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();",lLDashDisable);
		nextbutton.sendKeys(Keys.RETURN);
		return new ApplicationQuickPage();
		
	}
	
	
	
	}



