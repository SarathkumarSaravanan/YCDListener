package com.base.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{
private static  String getTestMethodName(ITestResult iTestResult)
{
	return iTestResult.getMethod().getConstructorOrMethod().getName();
}
public void onStart(ITestContext context)
{
	System.out.println(context.getName());
}
public void onFinish(ITestContext iTestContext)
{
	System.out.println(iTestContext.getName());

}
public void onTestStart(ITestResult result)
{
	System.out.println(result.getName());
}
public void onTestFailure(ITestResult result)
{
	System.out.println(result.getName());
}
public void onTestFailedButWithinSuccessPercentage(ITestResult result)
{
	System.out.println(result.getName());
}
public void onTestSkipped(ITestResult result)
{
	System.out.println(result.getName());
}
public void onTestSuccess(ITestResult result)
{
	System.out.println(result.getName());
}

}
