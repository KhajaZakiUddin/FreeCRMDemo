package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Khaja ZakiUddin')]")
	WebElement username;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement Contactslink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement Dealslink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement Taskslink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement NewContactsLink;
	
	
	//Initializing the page objects by creating a constructor
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	// Different verifications to be done on Home page
	public boolean verifyUsername(){
		return username.isDisplayed();
	}
	
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
		 
	}
	
	public ContactsPage clickonContactslink(){
		Contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealslink(){
		Dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskslink(){
		Taskslink.click();
		return new TasksPage();
	}

	public void clickOnNewContactsLink(){
		Actions action=new Actions(driver);
		action.moveToElement(Contactslink).build().perform();
		NewContactsLink.click();
	}
	
}
 