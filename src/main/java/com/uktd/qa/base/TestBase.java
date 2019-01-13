package com.uktd.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.uktd.qa.util.TestUtil;
import com.uktd.qa.util.WebEventListener;

public class TestBase 
{
	static	Logger log = Logger.getLogger(TestBase.class);
	
	
	public static WebDriver driver;
	public static Properties prop;
	public WebDriverWait wait;  
	public Select select;
	public JavascriptExecutor js;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;
	public TestBase()
	{
		
		
		try 
		{
 			prop = new Properties();
			
			FileInputStream ip = new FileInputStream("C:\\Users\\swapnil\\eclipse-workspace\\UKTD_Maven"
					+ "\\src\\main\\java\\com\\uktd\\qa\\config\\config.properties");
			
			prop.load(ip);

		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}

	
	
	public static void initialization()
	{
		String broweserName = prop.getProperty("browser");
		
		if (broweserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\swapnil\\eclipse-workspace\\WebDriver\\test\\scripts\\resources\\chromedriver.exe");
			driver=new ChromeDriver();
			log.info("Chrome Browser Started");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
		}
		
		else if (broweserName.equals("FF"))
		{
			 System.setProperty("webdriver.gecko.driver","C:\\Users\\swapnil\\eclipse-workspace\\WebDriver\\test\\scripts\\resources\\geckodriver.exe");
			 driver=new FirefoxDriver();
			 log.info("Firefox Browser Started");
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		
		else
		{
			System.out.println("Browser did not identified");
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	
	
	}
	

}
