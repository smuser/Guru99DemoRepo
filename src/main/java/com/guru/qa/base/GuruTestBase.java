package com.guru.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.guru.qa.util.TestUtil;
import com.guru.qa.util.WebEventListener;

public class GuruTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	public static WebEventListener eventlistener;
	   
	public GuruTestBase() 
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\StudyStuff\\Guru99Tests\\src\\main\\java\\com\\guru\\qa\\cofig\\config.properties");
			prop.load(ip);
		} 
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException io) {
			io.printStackTrace();
		}		
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		
		//To invoke browser
		if(browserName.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\deepa\\Downloads\\StudyStuff\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\deepa\\Downloads\\StudyStuff\\geckodriver-v0.33.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//log each event when being performed
		edriver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		edriver.register(eventlistener);
		driver = edriver;		
		
		//Basic events on browser
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

	}
	
	
	

}
