package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	String sheetName="Contacts";
	
	//Calling the test base class for initializing the properties
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testutil=new TestUtil();
		loginpage=new LoginPage();
		contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage=homepage.clickonContactslink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest(){
		Assert.assertTrue(contactspage.verifyContactsLabel(),"Label is not present/mismatch");
	}
	
	@Test(priority=2)
	public void selectSingleContactsByNameTest() throws Throwable{
		contactspage.selectContactsByName("sonia agarwal");
		Thread.sleep(2000);
	}
	

	@Test(priority=3)
	public void selectMultipleContactsByNameTest() throws Throwable{
		contactspage.selectContactsByName("sonia agarwal");
		contactspage.selectContactsByName("Tom Harry");
		Thread.sleep(2000);
	}
	
	//khaja
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void createNewContactsTest(String Title,String FirstName,String LastName,String Company ){
		homepage.clickOnNewContactsLink();
		contactspage.createNewContact(Title,FirstName,LastName,Company);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
