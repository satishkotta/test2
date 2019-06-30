package com.Wonderwe.Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends com.Wonderwe.TestCases.BaseClass implements ITestListener {
	
	public ExtentTest logger;
	public ExtentReports extent;
	public ExtentHtmlReporter htmlReporter;
	public WebDriver driver;
	

	
	public void onTestStart(ITestResult result) {
		logger = extent.createTest(result.getName());
		
	}

	
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}

	
	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String Screenshotpath = System.getProperty("user.dir") + "\\Screenshots\\" + timestamp + ".png";
		File f = new File(Screenshotpath);
		if (f.exists()) {
			try {
				logger.fail("Exception :" +errorMsg + logger.addScreenCaptureFromPath(Screenshotpath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public void onTestSkipped(ITestResult result) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		String Screenshotpath = System.getProperty("user.dir") + "\\Screenshots\\" + timestamp + ".png";
		File f = new File(Screenshotpath);
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());// timestamp
		String repName = "Test-Report-" + timestamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environmet", "QA");
		extent.setSystemInfo("Reporter", "PURNACHANDRA NAYUDU");
		htmlReporter.config().setDocumentTitle("InternetBanking Application");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
	}

	
	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("report closed");
		
	}

}
