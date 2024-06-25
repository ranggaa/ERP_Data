package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {
//Repository for customer page
	@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
	WebElement ObjCustomerLink;
	@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
	WebElement ObjAddIcon;
	@FindBy(name = "x_Customer_Number")
	WebElement ObjCustomerNumber;
	@FindBy(name = "x_Customer_Name")
	WebElement ObjCustomerName;
	@FindBy(name = "x_Address")
	WebElement ObjAddress;
	@FindBy(name = "x_City")
	WebElement ObjCity;
	@FindBy(name = "x_Country")
	WebElement ObjCountry;
	@FindBy(name = "x_Contact_Person")
	WebElement Objcontactperson;
	@FindBy(name = "x_Phone_Number")
	WebElement ObjPhoneNumber;
	@FindBy(name = "x__Email")
	WebElement ObjEmail;
	@FindBy(name = "x_Mobile_Number")
	WebElement ObjMobileNumber;
	@FindBy(name = "x_Notes")
	WebElement ObjNotes;
	@FindBy(id = "btnAction")
	WebElement ObjClickAddBtn;
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement ObjConfirmOk;
	@FindBy(xpath = "(//button[starts-with(text(),'OK')])[6]")
	WebElement ObjAlertOk;
	@FindBy(xpath = "//span[@data-caption='Search']")
	WebElement ObjSearchPanel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement ObjSearchtextbox;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjSearchBtn;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement webtable;
	public boolean addCustomer(String Cname,String Address,String City,String Country,String Cperson,
			String pNumber,String email,String mnumber,String notes)throws Throwable
	{
		ObjCustomerLink.click();
		Thread.sleep(2000);
		ObjAddIcon.click();
		Thread.sleep(2000);
		String Exp_Data =ObjCustomerNumber.getAttribute("value");
		ObjCustomerName.sendKeys(Cname);
		ObjAddress.sendKeys(Address);
		ObjCity.sendKeys(City);
		ObjCountry.sendKeys(Country);
		Objcontactperson.sendKeys(Cperson);
		ObjPhoneNumber.sendKeys(pNumber);
		ObjEmail.sendKeys(email);
		ObjMobileNumber.sendKeys(mnumber);
		ObjNotes.sendKeys(notes);
		ObjClickAddBtn.click();
		Thread.sleep(2000);
		ObjConfirmOk.click();
		Thread.sleep(2000);
		ObjAlertOk.click();
		Thread.sleep(2000);
		if(!ObjSearchtextbox.isDisplayed())
			ObjSearchPanel.click();
		ObjSearchtextbox.clear();
		ObjSearchtextbox.sendKeys(Exp_Data);
		ObjSearchBtn.click();
		Thread.sleep(2000);
		String Act_Data = webtable.getText();
		if(Act_Data.equals(Exp_Data))
		{
			Reporter.log(Exp_Data+"    "+Act_Data,true);
			return true;
		}
		else
		{
			Reporter.log(Exp_Data+"    "+Act_Data,true);
			return false;
		}
		
		
	}
	
}
