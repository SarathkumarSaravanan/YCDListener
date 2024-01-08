package com.bfm.pagefactory;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListen implements ITestListener {
	public  void onStart(ITestContext Context)
	{
	System.out.println("Test Start Successfully");
	}
	public void onTestStart(ITestResult result)
	{
		System.out.println(result.getName());
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println(result.getName());
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println(result.getName());
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println(result.getName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	System.out.println(result.getName());	
	}

}
