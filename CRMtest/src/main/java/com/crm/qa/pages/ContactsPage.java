package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;  
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//*[@id='vContactsForm']//td[contains(text(),'Contacts')]")
	WebElement contactslbl;
	
	public ContactsPage()
	{
		initialize();
		PageFactory.initElements(driver, this);
	}
	
	public String verifycontactspage() 
	{	
		return contactslbl.getText();
		
	}
	
}
