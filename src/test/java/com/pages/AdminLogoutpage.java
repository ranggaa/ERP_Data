package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogoutpage {
@FindBy(xpath = "(//a[starts-with(text(),' Logout')])[2]")
WebElement logout;
public void adminLogout()
{
	logout.click();
}
}
