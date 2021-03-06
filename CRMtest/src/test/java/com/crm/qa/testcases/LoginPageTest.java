package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialize();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void validateloginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void validateCRMlogotest() {
		boolean flag = loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void logintest() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String Homepgtitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(Homepgtitle,"CRMPRO");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
