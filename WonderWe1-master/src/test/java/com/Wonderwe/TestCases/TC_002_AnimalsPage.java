package com.Wonderwe.TestCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.Wonderwe.PageObjects.Animals;

public class TC_002_AnimalsPage extends BaseClass {
	
	@Test(priority=2)
	public  void Animalsss() throws Exception
	{
		try {
			
			Animals animals=new Animals();
			Thread.sleep(10000);
			animals.Animal_page();
			
			String Act=driver.findElement(By.xpath("//div[@class='bigtext']/h1")).getText();
			if(Act.equals("Animals and Nature"))
			{
				Assert.assertTrue(true);
				System.out.println("Page Navigated Successfully");
			}
			
			else
			{
				throw new Exception("Page Navigation Error");
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
	
	@Test(priority=3)
	public void AnimalNatureFundriser() throws IOException
	{
		try {
			Animals animals=new Animals();
			animals.Animal_fundriser();
			WebElement  Act=driver.findElement(By.name("subscribe"));
			
			
			if(Act.equals(Act))
			{
				Assert.assertTrue(true);
			}
			else
			{
				throw new Exception("Element Not Found");
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
	
	@Test
	public void CountrySelect() throws InterruptedException
	{
		Animals animals=new Animals();
		animals.Country();
	}

}
