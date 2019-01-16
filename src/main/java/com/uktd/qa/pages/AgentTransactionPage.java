package com.uktd.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.uktd.qa.base.TestBase;

public class AgentTransactionPage extends TestBase
{
	public AgentTransactionPage()
	{
		PageFactory.initElements(driver, this);	
	}

	
	public String[] getAgentToPurchaseTransation(String ApplicantId)
	{	
		String trnacation_Description = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Agent Purchase')]")).getText();

		String report_Quantity = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Agent Purchase')]//following::td[1]")).getText();

		String net_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Agent Purchase')]//following::td[2]")).getText();

		String vat_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Agent Purchase')]//following::td[3]")).getText();
		
		String total_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Agent Purchase')]//following::td[4]")).getText();

		System.out.println(trnacation_Description+" , "+report_Quantity+" , "+net_Amount+" , "+vat_Amount+" , "+total_Amount);
		
		String [] values = new String[5];
		values [0] = trnacation_Description;
		values [1] = report_Quantity;
		values [2] = net_Amount;
		values [3] = vat_Amount;
		values [4] = total_Amount;	
		return values;
	}
	
	public String[] getTenantToPurchaseCommisionTransation(String ApplicantId)
	{
		String trnacation_Description = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Tenant Purchase')]")).getText();

		String report_Quantity = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Tenant Purchase')]//following::td[1]")).getText();

		String net_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Tenant Purchase')]//following::td[2]")).getText();

		String vat_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Tenant Purchase')]//following::td[3]")).getText();

		String total_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Tenant Purchase')]//following::td[4]")).getText();

		System.out.println(trnacation_Description+" , "+report_Quantity+" , "+net_Amount+" , "+vat_Amount+" , "+total_Amount);

		String [] values = new String[5];
		values [0] = trnacation_Description;
		values [1] = report_Quantity;
		values [2] = net_Amount;
		values [3] = vat_Amount;
		values [4] = total_Amount;	
		return values;

	}

	
	public String[] getAMLRebateTransaction(String ApplicantId)
	{
		String trnacation_Description = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'AML Rebate')]")).getText();

		String report_Quantity = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'AML Rebate')]//following::td[1]")).getText();

		String net_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'AML Rebate')]//following::td[2]")).getText();

		String vat_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'AML Rebate')]//following::td[3]")).getText();

		String total_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'AML Rebate')]//following::td[4]")).getText();

		System.out.println(trnacation_Description+" , "+report_Quantity+" , "+net_Amount+" , "+vat_Amount+" , "+total_Amount);

		String [] values = new String[5];
		values [0] = trnacation_Description;
		values [1] = report_Quantity;
		values [2] = net_Amount;
		values [3] = vat_Amount;
		values [4] = total_Amount;	
		return values;

	}
	
	
	public String[] getImmigrationRebateTransaction(String ApplicantId)
	{
		String trnacation_Description = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Rebate -Immigration')]")).getText();

		String report_Quantity = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Rebate -Immigration')]//following::td[1]")).getText();

		String net_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Rebate -Immigration')]//following::td[2]")).getText();

		String vat_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Rebate -Immigration')]//following::td[3]")).getText();

		String total_Amount = driver.findElement(By.xpath("//td[contains(text(),'"+ApplicantId+"')][contains(text(),'Rebate -Immigration')]//following::td[4]")).getText();

		System.out.println(trnacation_Description+" , "+report_Quantity+" , "+net_Amount+" , "+vat_Amount+" , "+total_Amount);

		String [] values = new String[5];
		values [0] = trnacation_Description;
		values [1] = report_Quantity;
		values [2] = net_Amount;
		values [3] = vat_Amount;
		values [4] = total_Amount;	
		return values;

	}
		
	
	
	
}
