package com.Wonderwe.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;*/
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Wonderwe.Utility.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String url=readconfig.getApplicationurl();
	public static WebDriver driver;
	public static String timestamp;
	public static String testMethodName;
	public static String errorMsg;
	//static  Logger logger;
	//public Logger log = Logger.getLogger("devpinoyLogger");
	
	@org.testng.annotations.Parameters("browser")
	@BeforeSuite
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\chromedrive\\chromedriver.exe");
		 driver=new ChromeDriver();
		// Logger log = Logger.getLogger("devpinoyLogger");
		// PropertyConfigurator.configure("log4j.properties");
		 
		driver.get(url); 
		driver.manage().window().maximize();
	//	log.info("Browser Maximized");
		
	}
	@AfterSuite(enabled=false)
	
	public void Close()
	{
		driver.close();
	}
	public void capturescreen(WebDriver driver, String tname) throws IOException
	{
		timestamp=tname;
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshots/"+ timestamp + ".png");
		FileHandler.copy(source, target);
		System.out.println("screenshot taken");
		
	}
	
	

}
