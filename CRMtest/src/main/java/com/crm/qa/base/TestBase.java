package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
		
	public TestBase() {
		
		try {
			prop=new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\viky\\git\\selCRM\\CRMtest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void initialize() {
		String browsername= prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			 driver = new ChromeDriver();
			 
			 System.out.println("Chrome");
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Firefox");
		}
		else if(browsername.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");//Use 32 bit always. 64 bit is not recommended. if used, it will be very slow.
			DesiredCapabilities caps=DesiredCapabilities.internetExplorer();
			caps.setCapability("EnableNativeEvent", false);
			caps.setCapability("ignoreZoomSettings", true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability("requireWindowFocus", true);//This will boost the sendkeys typing speed. Otherwise, IE will enter each character separately resulting in more seconds(32 bits)/mins(64 bits) instead of 1 to 2 seconds.
			driver=new InternetExplorerDriver(caps);
		}
		else if(browsername.equals("opera"))
		{
			System.setProperty("webdriver.opera.driver","operadriver.exe");
			driver=new OperaDriver();
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
}
