package com.uktd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uktd.qa.base.TestBase;
import com.uktd.qa.pages.ApplicationQuickPage;
import com.uktd.qa.pages.CompleteApplication;
import com.uktd.qa.pages.CreateApplicationPage;
import com.uktd.qa.pages.LoginPage;
import com.uktd.qa.pages.OpenApplicationPage;
import com.uktd.qa.pages.OrderConfirmationPage;
import com.uktd.qa.pages.PaymentPage;
import com.uktd.qa.pages.QuickStepOnePage;
import com.uktd.qa.util.TestUtil;

public class TenantToPurTenantFillCR extends TestBase
{

	LoginPage loginpage;
	OpenApplicationPage openApplication;
	CreateApplicationPage createApplication;
	ApplicationQuickPage applicationQuick;
	CompleteApplication completeApplication;
	QuickStepOnePage quickStepOne;
	PaymentPage paymentPage;
	OrderConfirmationPage orderConfirmationPage;
	
	
	public  TenantToPurTenantFillCR()
	{
		super();
	}



	@DataProvider
	public Object[][] getAddTenantToPurchaseTenantFillFRApplicantData()
	{
		Object data[][] = TestUtil.getTestData("TenPurTenFillCR");
		return data;
	}



	@Test(dataProvider = "getAddTenantToPurchaseTenantFillFRApplicantData")
	public void CreditReportTenantToPurTenantFill(String f_Report, String p_method, String filledBy, 
			String p_Code, String a_Address, String d_MoveIn,
			String t_Period, String m_Rent, String r_Share, String a_Title, String a_Name,
			String a_SurName,  String a_Mobile, String e_Mail, String e_MailConfirm,
			String a_MiddleName, String a_MaidenName, String a_DOB, String m_Status, 
			String h_Phone, String w_Phone, String a_Proof, 
			String s_Code, String a_No,String c_PostCode, String c_Address, String c_MoveIn, 
			String no_Child, String no_ChildOver18) 

	{
		createApplication = new CreateApplicationPage();
		createApplication.FullReportTenantToPurTenantFill(f_Report, p_method, filledBy, p_Code, a_Address, d_MoveIn, t_Period, m_Rent);

		applicationQuick = new ApplicationQuickPage();
		applicationQuick.fillApplicationQuickPage(r_Share, a_Title, a_Name, a_SurName, a_Mobile, e_Mail, e_MailConfirm);

		completeApplication = new CompleteApplication();
		completeApplication.finishApplication();

		String ApplicantFillURL = openApplication.getApplicantFillURL();

		logoutCurrentSessionandOpenNewWindow(ApplicantFillURL);

		quickStepOne = new QuickStepOnePage();
		quickStepOne.TenantFillQuickStepOneCreditReport(a_MiddleName, a_MaidenName, a_DOB,  m_Status, 
				h_Phone,  w_Phone,  a_Proof, s_Code,  a_No, c_PostCode,  c_Address,  c_MoveIn, no_Child,  no_ChildOver18) ;

		paymentPage = new PaymentPage();
		paymentPage.MakePayment();
		
		orderConfirmationPage = new OrderConfirmationPage();
		Assert.assertEquals(orderConfirmationPage.getPageHeader(), "Order Confirmation");
		
	}


	@BeforeMethod
	public void beforeMethod() 
	{
		initialization();

		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		openApplication = new OpenApplicationPage();
		openApplication.newApplicationPage();
	}

	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}

}