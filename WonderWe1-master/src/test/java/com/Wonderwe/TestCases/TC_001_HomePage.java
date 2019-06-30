package com.Wonderwe.TestCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Wonderwe.PageObjects.HomePage;

public class TC_001_HomePage extends BaseClass {
	
	@Test(priority=1)
	public void Title() throws IOException 
	{
		
		
		try {
			
			HomePage page=new HomePage();
			String act=driver.getTitle();
			//String act1=driver.findElement(By.xpath("//div[@class='bigtext']/h1")).getText();
			Thread.sleep(10000);
			page.Popup();
			//page.Animal();
			
			if(act.equals("WonderWe: Free Online Fundraising - Raise Money for a Cause"))
			{
				Assert.assertTrue(true);
				System.out.println("Title Matched");
			}
			
			else
			{
				throw new Exception("Title Mismatched");
				

			}

		} catch (Exception e) {
			
			errorMsg=e.getMessage();
			timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			capturescreen(driver,timestamp);
			System.out.println(e.getMessage());
			//Assert.assertTrue(false);
			Assert.fail(e.getMessage());
		}

	}
	
	
}


