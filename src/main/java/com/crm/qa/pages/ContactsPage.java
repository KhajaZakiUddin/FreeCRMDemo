package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	//Defining the pagefactories
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement compani;
	
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement savebtn;
	
	// Initializing the Page Factory
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean verifyContactsLabel(){
		return contactslabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String ftName,String LtName,String company){
		Select select=new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(LtName);
		compani.sendKeys(company);
		savebtn.click();
	}
	
	
}
