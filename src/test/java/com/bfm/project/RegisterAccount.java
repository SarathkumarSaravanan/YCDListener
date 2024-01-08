package com.bfm.project;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.util.Baseclass;
import com.base.util.TestListener;
@Listeners(TestListener.class)
public class RegisterAccount extends Baseclass {
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");
//	public static WebDriver driver;

	@Test(priority=1)
public static void createacc() throws InterruptedException, IOException
{
//		createReport();
		createTest("Create New Account");
		driver = new FirefoxDriver();
		driver.get("https://dev.yourchildsday.com/");
//		teststatus("pass", "YCD Site Open");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement newact= driver.findElement(By.xpath("//a[text()='Create a new account >']"));
		newact.click();
//		teststatus("pass", "Create a new account clicked");
		String actual="Create a New Account";
		WebElement newac =driver.findElement(By.xpath("//h2[text()='Create a New Account']"));
		String expected = newac.getText();
		Assert.assertEquals(actual, expected);
		System.out.println("Enter into create a new account page");
//		teststatus("passScreenshot", "Entered new account clicked");
//		TakesScreenshot tks=(TakesScreenshot)driver;
//		File src=tks.getScreenshotAs(OutputType.FILE);
//		File dst=new File("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\user.dir\\Signup"+dt1+".png");
//		FileHandler.copy(src, dst);
//		test.addScreenCaptureFromPath("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\user.dir\\Signup"+dt1+".png");
	WebElement fname=driver.findElement(By.xpath("//input[@placeholder='First name']"));
	fname.sendKeys("SampleTest1"+dt1+"");
//	teststatus("pass", "First Name Entered");
	WebElement lname=driver.findElement(By.xpath("//input[@placeholder='Last name']"));
	lname.sendKeys("SampleTest2"+dt1+"");
//	teststatus("pass", "Last Name Entered");
	WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email']"));
	email.sendKeys("Testingsar6"+dt1+"@yopmail.com");
//	teststatus("pass", "Email Entered");
	WebElement phone=driver.findElement(By.xpath("//input[@placeholder='Mobile number']"));
	phone.sendKeys("9632154215");
//	teststatus("pass", "Mobile Entered");
//	WebElement usname=driver.findElement(By.xpath("//input[@id='UserName']"));
//	usname.sendKeys("AutoTesting6"+dt1+"");
	WebElement slctCompany=driver.findElement(By.xpath("//span[text()='Select company']"));
	slctCompany.click();
//	teststatus("pass", "Company clicked");
	Thread.sleep(2000);
	slctCompany.sendKeys(Keys.DOWN);
	slctCompany.sendKeys(Keys.ENTER);
//	teststatus("fail", "Unable to select compaly");
//	TakesScreenshot tks1=(TakesScreenshot)driver;
//	File src1=tks.getScreenshotAs(OutputType.FILE);
//	File dst1=new File("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\user.dir\\cpnyError"+dt1+".png");
//	FileHandler.copy(src1, dst1);
//	test.addScreenCaptureFromPath("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\user.dir\\cpnyError"+dt1+".png");
	WebElement psw=driver.findElement(By.xpath("//input[@id='Password']"));
	psw.sendKeys("Vss@1234");
	WebElement cpsw=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
	cpsw.sendKeys("Vss@1234");
	WebElement regbtn=driver.findElement(By.xpath("//input[@value='REGISTER']"));
	regbtn.click();
//	stop();
}
//	String paren=driver.getWindowHandle();
//	Set<String> child=driver.getWindowHandles();
//	for(String ch:child)
//	{
//		if(!ch.equals(paren))
//			driver.switchTo().window(ch);
//		}
//	Set<String> child=driver.getWindowHandles();
//	List<String>li= new LinkedList<>();
//	li.addAll(child);
//	driver.switchTo().window(li.get(1));
//	String actual= "Sign In";
//	WebElement sgn=driver.findElement(By.xpath("//p[text()='Sign In']"));
//	String expected=sgn.getText();
//	Assert.assertEquals(actual, expected);
//	System.out.println("New User Created Sucessfully");
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.get("https://yopmail.com/");
//	WebElement maillgn=driver.findElement(By.xpath("//input[@id='login']"));
//	maillgn.sendKeys("Testingsar6"+dt1+"@yopmail.com");
//	WebElement gmail=driver.findElement(By.xpath("//i[contains(@class,'material-icons-outlined f36')]"));
//	gmail.click();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	WebElement frame=driver.findElement(By.xpath("//iframe[@id='ifmail']"));
//	driver.switchTo().frame(frame);
//	WebElement cfm=driver.findElement(By.xpath("//a[text()='link']"));
//	cfm.click();
//	String paren1=driver.getWindowHandle();
//	Set<String> child1=driver.getWindowHandles();
//	for(String ch:child1)
//	{
//		if(!ch.equals(paren1))
//			driver.switchTo().window(ch);
//		}
//	String actual1= "Sign In";
//	WebElement sgn1=driver.findElement(By.xpath("//p[text()='Sign In']"));
//	String expected1=sgn.getText();
//	Assert.assertEquals(actual1, expected1);
//	System.out.println("Mail verified successfully");
	
//	@Test(priority=2, enabled=false)
//	public static void mailValid()
//	{
//	driver = new ChromeDriver();
//		driver.get("https://yopmail.com/");
//		WebElement maillgn=driver.findElement(By.xpath("//input[@id='login']"));
//		maillgn.sendKeys("Testingsar6"+dt1+"@yopmail.com");
//		WebElement gmail=driver.findElement(By.xpath("//i[contains(@class,'material-icons-outlined f36')]"));
//		gmail.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebElement frame=driver.findElement(By.xpath("//iframe[@id='ifmail']"));
//		driver.switchTo().frame(frame);
//		WebElement cfm=driver.findElement(By.xpath("//a[text()='link']"));
//		cfm.click();
//		String paren=driver.getWindowHandle();
//		Set<String> child=driver.getWindowHandles();
//		for(String ch:child)
//		{
//			if(!ch.equals(paren))
//				driver.switchTo().window(ch);
//			}
//		String actual= "Sign In";
//		WebElement sgn=driver.findElement(By.xpath("//p[text()='Sign In']"));
//		String expected=sgn.getText();
//		Assert.assertEquals(actual, expected);
//		System.out.println("Mail verified successfully");
//		WebElement inntecadmin=driver.findElement(By.xpath("//input[@id='Email']"));
//		inntecadmin.sendKeys("InntechAdmin");
//		driver.findElement(By.xpath("//input[@id='Password']"));
//		
	}
	

