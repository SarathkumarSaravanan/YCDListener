package com.base.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
	private static  String path;
	private static ExtentReports extent;
	  public static WebDriver driver;
  public static ExtentReports getInstance()

  {
	  if(extent==null)
	  
		  createInstance();
	  
		  return extent;
  }
  public static ExtentReports createInstance()
  {
	  if(extent==null)
	  {
		String workingDir= System.getProperty("user.dir");
		String reportName ="Report.html";
		path="//target//"+reportName;
		ExtentSparkReporter htmlReporter  = new ExtentSparkReporter(workingDir+path);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	  }
	  return extent;
  }
	public static synchronized String addScreenshots() throws IOException
	{
	Long l = Calendar.getInstance().getTimeInMillis();
	String ScreenshotId = l.toString();
	String path=System.getProperty("user.dir")+"/ExtendReports/";
	File Screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String imagePath=path+ScreenshotId+".png";
	File dest= new File(imagePath);
	FileUtils.copyFile(Screenshot, dest);
	String Imagepath="../ExtendReports/"+ScreenshotId+".png";
	return Imagepath;
	}
}
