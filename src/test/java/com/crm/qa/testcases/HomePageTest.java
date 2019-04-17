package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	
	
	//Creating the constructor of Homepage Test
	public HomePageTest(){
		super(); //calling the TestBase Class constructor and properties are initialized
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil=new TestUtil();
		contactspage=new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle,"CRMPRO","Homepage Title not matched");
	}
	
	@Test(priority=3)
	public void verifyCorrectUsername(){
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifyUsername());
	}
	
	@Test(priority=2)
	public void verifyclickonContactslinkTest(){
		testUtil.switchToFrame();
		contactspage=homepage.clickonContactslink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
