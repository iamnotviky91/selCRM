package com.crm.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
public static long IMPLICIT_WAIT = 10;
public static long PAGE_LOAD_TIMEOUT=10;
public static WebDriverWait wait;

public void switchToFrame()
{
	driver.switchTo().frame("mainpanel");
}

public static void explicitwaitfortitle(int wait_time, String title) 
{
	wait=new WebDriverWait(driver,wait_time);
	wait.until(ExpectedConditions.titleIs(title));//explicit wait checking for title of the homepage, otherwise its observed that homepage driver returns loginpage title from below return statement.

}

}
