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

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	DealsPage dealpage;
	TasksPage taskspage;
	TestUtil testutil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() 
	{
		initialize();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomepgTitle()
	{
		String homepgtitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepgtitle,"CRMPRO", "Home page title is not matching");
	}
	@Test(priority=1)
	public void verifyuserlbl()
	{	testutil.switchToFrame();
		String userlbl = homepage.verifyuserlabel();
		Assert.assertEquals(userlbl,"  User: Demo User", "user name is not matching");
	}
	
	@Test(priority=2)
	public void Contactspage()
	{	testutil.switchToFrame();
		contactpage = homepage.clickOnContactsLink();
	}
	
	@Test(priority=3)
	public void Dealspage()
	{	testutil.switchToFrame();
		dealpage = homepage.clickOnDealsLink();
	}
	
	@Test(priority=4)
	public void Taskpage()
	{	testutil.switchToFrame();
		taskspage = homepage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
