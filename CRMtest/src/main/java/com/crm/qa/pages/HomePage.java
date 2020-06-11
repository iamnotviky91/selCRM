package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User:')]")
	WebElement userlabel;

	@FindBy(xpath="//div[@id='navmenu']//a[@title='Contacts']")
	WebElement ContactsLink;

	@FindBy(xpath="//div[@id='navmenu']//a[@title='Deals']")
	WebElement DealsLink;
	
	@FindBy(xpath="//div[@id='navmenu']//a[@title='Tasks']")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyuserlabel()
	{
		return userlabel.getText();
	}
	
	public String verifyHomePageTitle()
	{	
		TestUtil.explicitwaitfortitle(10,"CRMPRO");
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() 
	{
		ContactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink() 
	{
		DealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink() 
	{
		tasksLink.click();
		return new TasksPage();
	}
	
}
