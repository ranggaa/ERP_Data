package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
//define Repository for login page
	@FindBy(xpath = "//button[@id='btnreset']")
	WebElement ObjResetBtn;
	@FindBy(name ="username")
	WebElement ObjUser;
	@FindBy(name ="password")
	WebElement ObjPass;
	@FindBy(name ="btnsubmit")
	WebElement ObjLoginbtn;
	//define method for login
	public void eRP_login(String user,String pass)
	{
		ObjResetBtn.click();
		ObjUser.sendKeys(user);
		ObjPass.sendKeys(pass);
		ObjLoginbtn.click();
	}
	
}
