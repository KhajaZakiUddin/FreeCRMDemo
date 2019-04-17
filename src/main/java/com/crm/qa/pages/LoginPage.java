package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase{

	//Defining PageFactory or Object Repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement lginbtn;
	
	
	//Initializing the WebElements or page objects of Login Page
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	//Performing Actions on LoginPage
	public String validLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		TestUtil.flash(lginbtn, driver);
		TestUtil.clickElement(lginbtn, driver);
		
		return new HomePage(); 
		
	}
	
}
