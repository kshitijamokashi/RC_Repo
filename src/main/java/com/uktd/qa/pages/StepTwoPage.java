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

public class StepTwoPage extends TestBase
{
	public StepTwoPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
			//Common
		
			@FindBy(xpath ="//*[@name='currentAccmStatus']")
			WebElement accStatus;
		
			@FindBy(xpath ="//*[@id='yesRented']")
			WebElement rentedLast6MonthYes;
		
			@FindBy(xpath ="//*[@id='notRented']")
			WebElement rentedLast6MonthNo;
		
			@FindBy (xpath = "//*[contains(text(),'Update')][@ng-click='submitApplicationStep2Form();']")
			WebElement updateButton;
		
			@FindBy (xpath = "//*[@id='progressing']")
			WebElement loader;
		
			@FindBy(xpath = "html/body/section/section/div/div/ng-view/div/div/div/form/div[1]")
			WebElement date;
		
			@FindBy (xpath = "//*[@id='lettingPay']")
			WebElement lettingAgent;
		
			@FindBy (xpath = "//*[@id='landLordPay']")
			WebElement landlord;
		
			//F&F
	
			@FindBy (xpath = "//*[@name='familyContactTitle']")
			WebElement contactTitle;
	
			@FindBy (xpath = "//*[@name='friendFirstName']")
			WebElement contactName;
	
			@FindBy (xpath = "//*[@name='friendSurName']")
			WebElement contactSurName;
	
			@FindBy (xpath = "//*[@name='friendPhoneNum']")
			WebElement contactPhone;
	
			@FindBy (xpath = "//*[@name='friendMobileNum']")
			WebElement contactMobile;
	
			@FindBy (xpath = "//*[@name='friendEmail']")
			WebElement contactEmail;
	
	
			//BankInfo
			@FindBy (xpath = "//*[@id='bankShortCode1']")
			WebElement sortCode;
	
			@FindBy (xpath = "//*[@id='bankAccNo']")
			WebElement accNo;

			//CurrentAcc	
			@FindBy (xpath = "//*[@name='currentAccomPostalCode']")
			WebElement currentAdd;
	
			@FindBy (xpath = "//*[contains(text(),'Find')]")
			WebElement findButton;
	
			@FindBy (xpath = "//*[@id='currentAccomaddressList']")
			WebElement addressList;
	
			@FindBy (xpath = "//*[@name='currentAccomProposedMoveDate']")
			WebElement currentAddMoveIn;

		
			//FinishStep
			@FindBy (xpath = "//button[contains(text(),'Finish')]")
			WebElement finishButton;
	
			@FindBy(xpath = "//button[contains(text(),'Add')]")
			WebElement addAnother;
	
			@FindBy(xpath = "//button[@type='button'][contains(text(),'Finish')][1]")
			WebElement popupFinish;
	
			@FindBy(xpath = "html/body/div[6]/div/div/div[3]/button[1]")
			WebElement popupCancel;
		
		
			//PrevAccomodationBlock	

			@FindBy (xpath = "//*[@name='prevAccomPostalCode']")
			WebElement prevAccPostCode;

			@FindBy (xpath = "//button[contains(text(),'Find')][@aria-controls='find3']")
			WebElement prevAccPostCodeFind;

			@FindBy (xpath = "//*[@id='prevAccomAddressList']")
			WebElement prevAccAddList;

			@FindBy (xpath = "//*[@name='prevAccomProposedMoveDate']")
			WebElement prevAccProposeMoveIn;
			
			//AccommodationDetails
		
			@FindBy (xpath = "//*[@name='accomMonthlyRent']")
			WebElement monthlyRent;

			@FindBy (xpath = "//*[@name='rentPayMethod']")
			WebElement rentPayment;
				
			//Letting Agent	
			
			@FindBy (xpath = "//*[@name='lettingAgentName']")
			WebElement lettingAgentName;
			

			@FindBy (xpath = "//*[@name='lettingAgentPostCode']")
			WebElement lettingAgentPostCode;
			
			@FindBy (xpath = "//button[contains(text(),'Find')][@aria-controls='find4']")
			WebElement lAFindButton;
			
			@FindBy (xpath = "//*[@id='lettingAgentAddressList']")
			WebElement lettingAgentAddList;	
			
			@FindBy (xpath = "//*[@placeholder='Enter Fax']")
			WebElement fax;
			
			@FindBy (xpath = "//*[@name='lettingAgentTitle']")
			WebElement lettingAgentTitle;
			
			@FindBy (xpath = "//*[@name='lettingAgentFirstName']")
			WebElement agentFirstName;
			
			@FindBy (xpath = "//*[@name='lettingAgentSurName']")
			WebElement agentSurName;

			@FindBy (xpath = "//*[@name='lettingAgentPhone']")
			WebElement agentPhone;

			@FindBy (xpath = "//*[@name='lettingAgentMobile']")
			WebElement agentMobile;

			@FindBy (xpath = "//*[@name='lettingAgentEmailID']")
			WebElement agentEmail;

			//LandLord	

			@FindBy (xpath = "//*[@name='landLordPostalCode']")
			WebElement lLpostcode;
			
			@FindBy (xpath = "//button[contains(text(),'Find')][@aria-controls='find5']")
			WebElement lLpostcodeFind;
			
			@FindBy (xpath = "//*[@id='landlordAddressList']")
			WebElement lLAddlist;
			
			@FindBy (xpath = "//*[@name='landLordTitle']")
			WebElement lLTitle;
			
			@FindBy (xpath = "//*[@name='landLordFirstName']")
			WebElement lLFirstName;
			
			@FindBy (xpath = "//*[@name='landLordSurname']")
			WebElement lLSurname;
			
			@FindBy (xpath = "//*[@name='landLordPhone']")
			WebElement lLPhone;
			
			@FindBy (xpath = "//*[@name='landLordMobile']")
			WebElement lLMobile;
			
			@FindBy (xpath = "//*[@name='landLordEmailID']")
			WebElement lLEmail;
			
			//Address Renting	
			
			@FindBy (xpath = "//*[@name='prevMovedIn']")
			WebElement prevMoveInDate;
			
			@FindBy (xpath = "//*[@name='prevMovedOut']")
			WebElement PrevMoveOutDate;
			
			@FindBy (xpath = "//*[@name='prevMovedPostCode']")
			WebElement prevAddPostCode;
			
			@FindBy (xpath = "//button[contains(text(),'Find')][@aria-controls='find2']")
			WebElement prevAddPostCodeFind;
			
			@FindBy (xpath = "//*[@id='prevMovedAddressList']")
			WebElement prevAddList;
			
			
			public void landlord_section() 
			{
				wait = new WebDriverWait(driver, 100);
				lLpostcode.sendKeys("L118LZ");
				lLpostcodeFind.click();
				
				wait.until(ExpectedConditions.visibilityOf(lLAddlist));
				//wait.until(ExpectedConditions.invisibilityOf(loader));
				select = new Select(lLAddlist);
				select.selectByVisibleText("30 Broad Lane Norris Green Liverpool");
				
				fax.sendKeys("123456789");
				
				select = new Select(lLTitle);
				select.selectByVisibleText("Mrs");
				
				lLFirstName.sendKeys("Lucy");
				
				lLSurname.sendKeys("Petrus");
				
				lLPhone.sendKeys("9604328562");
				
				lLMobile.sendKeys("8855699878");
				
				lLEmail.sendKeys("amitbaghel@benchmarkitsolutions.com");
			} 
			

			public void letting_agent_section() 
			{
				wait = new WebDriverWait(driver, 100);
				
				lettingAgentName.sendKeys("X1 Lettings");
				
				lettingAgentPostCode.sendKeys("AB117UE");
				lAFindButton.click();
				wait.until(ExpectedConditions.visibilityOf(lettingAgentAddList));
				Select LAList = new Select(lettingAgentAddList);
				LAList.selectByVisibleText("6 Deemount Gardens Aberdeen");
				
				fax.sendKeys("0000000000");
				
				select = new Select(lettingAgentTitle);
				select.selectByVisibleText("Miss");
				
				agentFirstName.sendKeys("Priyanka");
				
				agentSurName.sendKeys("Gaikwad");
				
				agentPhone.sendKeys("020555478");
				
				agentMobile.sendKeys("9503999099");
				
				agentEmail.sendKeys("priyankagaikwad@benchmarkitsoluions.com");

			}	

			
			public void enter_accommodation_details() 
			{
				monthlyRent.sendKeys("1000");
				
				select =new Select(rentPayment);
				select.selectByVisibleText("Direct Debit");
			}	
				
				
			
			public void enter_bank_info() 
			{
				sortCode.sendKeys("232323");
				
				accNo.sendKeys("00000000");
			}
			
			
			
			public void enter_current_address_info() 
			{
				wait = new WebDriverWait(driver, 100);
				currentAdd.sendKeys("M36GB");
				js = (JavascriptExecutor)driver;		
				js.executeScript("arguments[0].click();",findButton);
				
				wait.until(ExpectedConditions.visibilityOf(addressList));
				select =new Select(addressList);
				select.selectByVisibleText("Apartment 2 Block B Alto Sillavan Way Salford");
				
				wait.until(ExpectedConditions.invisibilityOf(loader));
				currentAddMoveIn.clear();
				currentAddMoveIn.sendKeys("01/01/2011");
				//Date.click();
			}

			public void address_you_were_renting() 
			{
				WebDriverWait wait = new WebDriverWait(driver, 100);
				prevMoveInDate.clear();
				prevMoveInDate.sendKeys("20/01/2010");
				//Date.click();
				PrevMoveOutDate.clear();
				PrevMoveOutDate.sendKeys("01/07/2018");
				//Date.click();
				prevAddPostCode.sendKeys("M36GB");
				js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();",prevAddPostCodeFind);

				//PrevAddPostCodeFind.click();
				wait.until(ExpectedConditions.visibilityOf(prevAddList));
				select= new Select(prevAddList);
				select.selectByVisibleText("Apartment 45 Block B Alto Sillavan Way Salford");
			
			}
			
			//Friends And Family Yes		
			public void FriendsAndFamilyYesLA()
			{
				WebDriverWait wait = new WebDriverWait(driver,100);

				wait.until(ExpectedConditions.invisibilityOf(loader));
				wait.until(ExpectedConditions.visibilityOf(accStatus));
				Select statusdrp =new Select(accStatus);
				statusdrp.selectByVisibleText("Currently Living with friends or family");

				wait.until(ExpectedConditions.visibilityOf(rentedLast6MonthYes));

				JavascriptExecutor js1 = (JavascriptExecutor)driver;
				js1.executeScript("arguments[0].click();",rentedLast6MonthYes);

				wait.until(ExpectedConditions.visibilityOf(lettingAgent));
				js1.executeScript("arguments[0].click();",lettingAgent);

				enter_current_address_info();

				address_you_were_renting();

				letting_agent_section();

				enter_accommodation_details();

				enter_bank_info();

				updateButton.sendKeys(Keys.RETURN);
			}

}
