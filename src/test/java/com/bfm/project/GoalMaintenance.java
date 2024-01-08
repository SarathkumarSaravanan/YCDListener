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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoalMaintenance {
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");
	public static WebDriver driver;
	@Test()
	public static void login(){
		driver = new ChromeDriver();
		driver.get("https://dev.yourchildsday.com/");
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement usname= driver.findElement(By.xpath("(//input[@data-val='true'])[1]"));
	usname.sendKeys("inntechadmin@yourchildsday.com");
	WebElement psw=driver.findElement(By.xpath("//input[@id='Password']"));
	psw.sendKeys("02xU^lA4e4gz");
	WebElement btn=driver.findElement(By.xpath("//input[@type='submit']"));
	btn.click();
	String actual="My Profile";
	WebElement text=driver.findElement(By.xpath("//h2[@class='page-title']"));
	String expected=text.getText();
	Assert.assertEquals(actual, expected);
	System.out.println("Login suceesfully move to home page");
	}
	@Test(dependsOnMethods="login")
	public static void goalmaintain() throws InterruptedException
	{
	WebElement centre=driver.findElement(By.xpath("(//a[@id='hideclass'])[4]"));
	Actions act= new Actions(driver);
	act.moveToElement(centre).perform();
	WebElement goal=driver.findElement(By.xpath("//a[text()='Goals Maintenance']"));
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", goal);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement adgoal=driver.findElement(By.xpath("//button[@id='btnAddMontessoriGoal']"));
	js.executeScript("arguments[0].click()", adgoal);
	WebElement goltxt=driver.findElement(By.xpath("//textarea[@id='txtMaterial']"));
	goltxt.sendKeys("TestingParent1"+dt1+"");
	WebElement svbtn=driver.findElement(By.xpath("//button[text()='SAVE GOAL']"));
	js.executeScript("arguments[0].click()", svbtn);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement adgoal1=driver.findElement(By.xpath("//button[@id='btnAddMontessoriGoal']"));
	js.executeScript("arguments[0].click()", adgoal);
	WebElement goltxt1=driver.findElement(By.xpath("//textarea[@id='txtMaterial']"));
	goltxt.sendKeys("TestingChild1"+dt1+"");
	WebElement svbtn1=driver.findElement(By.xpath("//button[text()='SAVE GOAL']"));
	js.executeScript("arguments[0].click()", svbtn);
	Thread.sleep(5000);
	WebElement src=driver.findElement(By.xpath("//span[text()='TestingParent1"+dt1+"']"));
	WebElement dst=driver.findElement(By.xpath("//span[text()='TestingChild1"+dt1+"']"));
	act.dragAndDrop(dst, src).perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement dst1=driver.findElement(By.xpath("//span[text()='TestingChild1"+dt1+"']"));
	js.executeScript("arguments[0].click()", dst1);
	WebElement linkGoal=driver.findElement(By.xpath("//button[@id='btnNewAdd']"));
	js.executeScript("arguments[0].click()", linkGoal);
	Thread.sleep(6000);
	WebElement ey1=driver.findElement(By.xpath("(//input[contains(@class,' k-checkbox-md k-rounded-md')])[1]"));
	js.executeScript("arguments[0].click()",ey1);
	WebElement ey3=driver.findElement(By.xpath("(//input[@class='k-checkbox k-checkbox-md k-rounded-md'])[11]"));
	js.executeScript("arguments[0].click()",ey3);
	WebElement addbtn=driver.findElement(By.xpath("//button[@id='btnGoalAdd']"));
	js.executeScript("arguments[0].click()",addbtn);
	WebElement updt=driver.findElement(By.xpath("//button[@id='btnEYLFSave']"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	js.executeScript("arguments[0].click()",updt);
	}			 
	}
	

	
	
	


