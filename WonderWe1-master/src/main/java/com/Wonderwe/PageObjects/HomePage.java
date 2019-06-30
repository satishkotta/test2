package com.Wonderwe.PageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Wonderwe.TestCases.BaseClass;

public class HomePage extends BaseClass {

	
	public HomePage()
	{
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='pro-close']")
	WebElement Close_Popup;
	
	@FindBy(xpath="(//div[@class='homePage-title'])[1]") WebElement Animals;
	

	public void Popup()
	{
		Close_Popup.click();
	}
	
	
	public void Animal() throws Exception
	{
		Thread.sleep(1000);
		Animals.click();
	}
	
	
	
	
	
}
