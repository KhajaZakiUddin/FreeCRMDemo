package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		super(); //Calling TestBase class constructor
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1,groups="Title")
	public void loginPageTitleTest(){
		String Title=loginpage.validLoginPageTitle();
		Assert.assertEquals(Title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2,groups="Logging in")
	public void LoginTest(){
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	

}
