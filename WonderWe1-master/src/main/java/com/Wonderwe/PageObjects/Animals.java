package com.Wonderwe.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Wonderwe.TestCases.BaseClass;

public class Animals extends BaseClass {

	
	public Animals()
	{
		
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath="(//div[@class='homePage-title'])[1]") WebElement Aanimals;
	@FindBy(xpath="//A[@href='/start/?category=1'][text()='Start an animal and nature fundraiser']") WebElement AanimalnatureFund;
	@FindBy(xpath="//SELECT[@id='COUNTRY']") WebElement Country;
	
	public void Animal_page() throws Exception
	{
		Thread.sleep(1000);
		Aanimals.click();
		
	}
	
	public void Animal_fundriser() throws Exception
	{
		Thread.sleep(1000);
		AanimalnatureFund.click();
		
	}
	
	public void Country() throws InterruptedException
	{
		Thread.sleep(1000);
		Select country = new Select(driver.findElement(By.id("COUNTRY")));
		Thread.sleep(1000);
		List<WebElement> list=driver.findElements(By.tagName("option"));
		list.size();
		System.out.println(list.size());
		for (WebElement option:list) {
			System.out.println(option.getText());
			list.get(2);
			break;
			
		}
	}
}
