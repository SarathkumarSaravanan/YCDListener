package com.bfm.project;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DailyTask {
	public static WebDriver driver;
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");
	JavascriptExecutor js;
	@Test
	public void login()
	{
	driver = new ChromeDriver();
	driver.get("https://dev.yourchildsday.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement usname= driver.findElement(By.xpath("//input[@type='text']"));
	usname.sendKeys("groupleader@yourchildsday.com");
	WebElement psw=driver.findElement(By.xpath("//input[@type='password']"));
	psw.sendKeys("T0sW#g@0YU4#");
	WebElement btn=driver.findElement(By.xpath("//button[@type='submit']"));
	btn.click();
	}
	@Test(dependsOnMethods="login")
	public void dailyTask() throws InterruptedException
	{
	WebElement chld=driver.findElement(By.xpath("//a[text()='Child']"));
	Actions act= new Actions(driver);
	act.moveToElement(chld).perform();
	WebElement dlytsk=driver.findElement(By.xpath("//a[text()='Daily Tasks']"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", dlytsk);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement orchid=driver.findElement(By.xpath("//h3[text()='7 Orchids (P)']"));
	js.executeScript("arguments[0].click()", orchid);
	WebElement actv=driver.findElement(By.xpath("(//span[text()='Activities'])[1]"));
	actv.click();
	WebElement addbtn=driver.findElement(By.xpath("//button[contains(@class,'bg-primarydark text-white')]"));
	js.executeScript("arguments[0].click()", addbtn);
	WebElement ple=driver.findElement(By.xpath("//button[text()='PLE']"));
	js.executeScript("arguments[0].click()", ple);
	WebElement title =driver.findElement(By.xpath("(//input[@type='text'])[3]"));
	title.sendKeys("testing"+dt1+"");
	WebElement arwbtn=driver.findElement(By.xpath("(//button[contains(@class,'flex items-center')])[3]"));
	js.executeScript("arguments[0].click()", arwbtn);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement svdrf=driver.findElement(By.xpath("//span[text()='Save as Draft']"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	js.executeScript("arguments[0].click()", svdrf);
	System.out.println("move to drafted successfully");
	}
	@Test(dependsOnMethods="dailyTask")
	public void planned() throws InterruptedException
	{
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement namedraft=driver.findElement(By.xpath("//span[text()='testing"+dt1+"']"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", namedraft);
	Thread.sleep(5000);
	WebElement sve=driver.findElement(By.xpath("//span[text()='SAVE']"));
	js.executeScript("arguments[0].click()", sve);
	System.out.println("moved to planned successfully");
	}
	@Test(dependsOnMethods="planned")
	public void implemented() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement actbtnu=driver.findElement(By.xpath("(//div[contains(@class,'items-center text-sm w-2/3')])[1]"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", actbtnu);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement pln2=driver.findElement(By.xpath("(//span[text()='Planned'])[1]"));
	pln2.click();
	Thread.sleep(3000);
	WebElement imp=driver.findElement(By.xpath("//span[text()='Implemented']"));
	js.executeScript("arguments[0].click()", imp);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement slctchld=driver.findElement(By.xpath("//span[text()='Select children']"));
	js.executeScript("arguments[0].click()", slctchld);
	WebElement select=driver.findElement(By.xpath("(//div[contains(@class,'selecthild-list flex flex-row')])[1]"));
	js.executeScript("arguments[0].click()", select);
	WebElement svbtn=driver.findElement(By.xpath("//button[text()='SAVE']"));
	svbtn.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement svmain=driver.findElement(By.xpath("//span[text()='SAVE']"));
	js.executeScript("arguments[0].click()", svmain);
	System.out.println("Moved to Implemented successfully");
	}
	@Test(dependsOnMethods="implemented")
	public void approved()
	{
	js= (JavascriptExecutor)driver;	
	WebElement impl=driver.findElement(By.xpath("//span[text()='testing"+dt1+"']"));
	js.executeScript("arguments[0].click()", impl);
	WebElement imp2=driver.findElement(By.xpath("(//span[text()='Implemented'])[1]"));
	js.executeScript("arguments[0].click()", imp2);
	WebElement appr=driver.findElement(By.xpath("//span[text()='Approved']"));
	js.executeScript("arguments[0].click()", appr);
	WebElement svbtn3=driver.findElement(By.xpath("//span[text()='SAVE']"));
	js.executeScript("arguments[0].click()", svbtn3);
	System.out.println("Moved to Approved successfully");
	}
	@Test(dependsOnMethods="approved")
	public void share() throws InterruptedException
	{
		
	Thread.sleep(3000);
	js= (JavascriptExecutor)driver;
	WebElement fnl=driver.findElement(By.xpath("//span[text()='testing"+dt1+"']"));
	js.executeScript("arguments[0].click()", fnl);
	Thread.sleep(3000);
	WebElement share=driver.findElement(By.xpath("(//button[@type='button'])[4]"));
	js.executeScript("arguments[0].click()", share);
	WebElement chkbox=driver.findElement(By.xpath("//span[@class='checkmark']"));
	js.executeScript("arguments[0].click()", chkbox);
	WebElement shrbtn=driver.findElement(By.xpath("//button[@id='ShareButton']"));
	js.executeScript("arguments[0].click()", shrbtn);
	System.out.println("Shared Successfully");
	}
	
}
