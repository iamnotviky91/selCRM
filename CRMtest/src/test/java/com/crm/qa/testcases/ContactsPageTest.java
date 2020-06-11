package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;



public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	DealsPage dealpage;
	TasksPage taskspage;
	TestUtil testutil;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() 
	{
		initialize();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame();
		homepage.clickOnContactsLink();
		
		
	}
	
	@Test(priority=1)
	public void verifycontactspagetitle()
	{	testutil.switchToFrame();
		String contactslabel = contactpage.verifycontactspage();
		Assert.assertEquals(contactslabel, "Contacts");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
