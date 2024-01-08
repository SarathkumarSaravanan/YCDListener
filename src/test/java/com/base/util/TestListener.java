package com.base.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.bfm.project.login;

public class TestListener implements ITestListener {
//	public static WebDriver driver;
	
	private static String getTestMetodName(ITestResult result)
	{
		return result.getMethod().getConstructorOrMethod().getName();
	}
	public void onStart(ITestContext context)
	{
		System.out.println(context.getName());
		
	}
	public void onFinish(ITestContext context)
	{
		System.out.println(context.getName());
		ReportManager.getInstance().flush();
	}
	public void onTestStart(ITestResult result)
	{
		String description =result.getMethod().getDescription();
		
		System.out.println("I am in onTestSucess method"+getTestMetodName(result)+"suceed");
		ReportTestManager.startTest(result.getMethod().getDescription(),result.getInstance().getClass().getCanonicalName());
		// if(description!=null)
		// ReportTestManager.startTest(result.getMethod().getMethodName()+"("+description+")",result.getInstance().getClass().getCanonicalName());
		// else if (result.getTestName()!=null)
		// {
		// 	ReportTestManager.startTest(result.getTestName(),result.getInstance().getClass().getCanonicalName());
		// }
		// else {
		// 	ReportTestManager.startTest(result.getMethod().getMethodName(),result.getInstance().getClass().getCanonicalName());
		// }
		System.out.println("I am in onTestStart method"+getTestMetodName(result)+"start");
		}
	public void onTestSuccess(ITestResult result)
	{
		ReportTestManager.getTest().log(Status.PASS, "Test Passed");
	}
	public void onTestFailure(ITestResult result)
	{
	System.out.println("I am in onTestFailure method"+getTestMetodName(result)+"failed");
	Object testClass=result.getInstance();
	WebDriver driver =((Baseclass)testClass).driver;
	Long l = Calendar.getInstance().getTimeInMillis();
	String ScreenshotId = l.toString();
	String path=System.getProperty("user.dir")+"/target/";
	File Screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String imagePath=path+ScreenshotId+".png";
	File dest= new File(imagePath);
	try {
		FileUtils.copyFile(Screenshot, dest);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String Imagepath="../ws/target/"+ScreenshotId+".png";
	ReportTestManager.getTest().log(Status.FAIL, result.getThrowable());
	ReportTestManager.getTest().fail("deatils",MediaEntityBuilder.createScreenCaptureFromPath(Imagepath).build());

	}
//	public static synchronized String addScreenshots() throws IOException
//	{
//		
//	Long l = Calendar.getInstance().getTimeInMillis();
//	String ScreenshotId = l.toString();
//	String path=System.getProperty("user.dir")+"/ExtendReports/";
//	File Screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	String imagePath=path+ScreenshotId+".png";
//	File dest= new File(imagePath);
//	FileUtils.copyFile(Screenshot, dest);
//	String Imagepath="../ExtendReports/"+ScreenshotId+".png";
//	return Imagepath;
//	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("I am in onTestSkipped method"+getTestMetodName(result)+"skipped");
	ReportTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}
	public void onTestFaiedButWithinSuccessPercentage(ITestResult result)
	{
	System.out.println("Test failed  but it is in  defined succes ratio"+getTestMetodName(result));
	}
}
