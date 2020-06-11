package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page factory - OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[@href='https://register.freecrm.com/register/']")
	WebElement signupbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement logo;
	
	//Initialization	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCRMLogo() {
		return logo.isDisplayed();
	}
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",loginbtn);

		
		
		return new HomePage();
		
	}
}
