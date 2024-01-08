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
import org.testng.annotations.Test;

public class DailyCareFood {
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
	WebElement usname= driver.findElement(By.xpath("(//input[@data-val='true'])[1]"));
	usname.sendKeys("groupleader@yourchildsday.com");
	WebElement psw=driver.findElement(By.xpath("//input[@id='Password']"));
	psw.sendKeys("T0sW#g@0YU4#");
	WebElement btn=driver.findElement(By.xpath("//input[@type='submit']"));
	btn.click();
	}
	@Test(dependsOnMethods="login")
	public void dailyTask()
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
	}
	@Test(dependsOnMethods="dailyTask")
	public void dailyCare()
	{
	WebElement dlcare=driver.findElement(By.xpath("(//span[text()='Daily Care'])[1]"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", dlcare);
	System.out.println("Food screen reached successfully");
	WebElement fd=driver.findElement(By.xpath("//input[@id='food']"));
	fd.sendKeys("Testing 1");
	}
	@Test(dependsOnMethods="dailyCare")
	public void mrngTea()
	{
	WebElement none=driver.findElement(By.xpath("(//button[text()='None'])[1]"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", none);
	WebElement some=driver.findElement(By.xpath("(//button[text()='Some'])[2]"));
	js.executeScript("arguments[0].click()", some);
	WebElement most=driver.findElement(By.xpath("(//button[text()='Most'])[3]"));
	js.executeScript("arguments[0].click()", most);
	WebElement all=driver.findElement(By.xpath("(//button[text()='All'])[4]"));
	js.executeScript("arguments[0].click()", all);
	WebElement extra=driver.findElement(By.xpath("(//button[text()='Extra'])[5]"));
	js.executeScript("arguments[0].click()", extra);
	WebElement incre=driver.findElement(By.xpath("(//button[contains(@class,'from-brgrdbtn1 to-brgrdbtn2')])[3]"));
	js.executeScript("arguments[0].click()", incre);
	js.executeScript("arguments[0].click()", incre);
	WebElement  svbtn=driver.findElement(By.xpath("//button[contains(@class,'text-white bg-primarymedium ml-2')]"));
	js.executeScript("arguments[0].click()", svbtn);
	System.out.println("Morning Tea added successfully");
	}
	@Test(dependsOnMethods="mrngTea")
	public void lunch()
	{
	WebElement mrnTea=driver.findElement(By.xpath("//div[text()='Morning Tea']"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", mrnTea);
	WebElement lunch=driver.findElement(By.xpath("//button[text()='Lunch']"));
	js.executeScript("arguments[0].click()", lunch);
	WebElement food=driver.findElement(By.xpath("//input[@id='food']"));
	food.sendKeys("Testing 2");
	WebElement none=driver.findElement(By.xpath("(//button[text()='None'])[1]"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", none);
	WebElement some=driver.findElement(By.xpath("(//button[text()='Some'])[2]"));
	js.executeScript("arguments[0].click()", some);
	WebElement most=driver.findElement(By.xpath("(//button[text()='Most'])[3]"));
	js.executeScript("arguments[0].click()", most);
	WebElement all=driver.findElement(By.xpath("(//button[text()='All'])[4]"));
	js.executeScript("arguments[0].click()", all);
	WebElement extra=driver.findElement(By.xpath("(//button[text()='Extra'])[5]"));
	js.executeScript("arguments[0].click()", extra);
	WebElement incre=driver.findElement(By.xpath("(//button[contains(@class,'from-brgrdbtn1 to-brgrdbtn2')])[3]"));
	js.executeScript("arguments[0].click()", incre);
	js.executeScript("arguments[0].click()", incre);
	WebElement  svbtn=driver.findElement(By.xpath("//button[contains(@class,'text-white bg-primarymedium ml-2')]"));
	js.executeScript("arguments[0].click()", svbtn);
	System.out.println("Lunch added successfully");
	}
	@Test(dependsOnMethods="lunch")
	public void aftTea()
	{
	WebElement aftTea=driver.findElement(By.xpath("//div[text()='Lunch']"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", aftTea);
	WebElement aftnoonTea=driver.findElement(By.xpath("//button[text()='Afternoon Tea']"));
	js.executeScript("arguments[0].click()", aftnoonTea);
	WebElement food=driver.findElement(By.xpath("//input[@id='food']"));
	food.sendKeys("Testing 3");
	WebElement none=driver.findElement(By.xpath("(//button[text()='None'])[1]"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", none);
	WebElement some=driver.findElement(By.xpath("(//button[text()='Some'])[2]"));
	js.executeScript("arguments[0].click()", some);
	WebElement most=driver.findElement(By.xpath("(//button[text()='Most'])[3]"));
	js.executeScript("arguments[0].click()", most);
	WebElement all=driver.findElement(By.xpath("(//button[text()='All'])[4]"));
	js.executeScript("arguments[0].click()", all);
	WebElement extra=driver.findElement(By.xpath("(//button[text()='Extra'])[5]"));
	js.executeScript("arguments[0].click()", extra);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement incre=driver.findElement(By.xpath("(//button[contains(@class,'from-brgrdbtn1 to-brgrdbtn2')])[3]"));
	js.executeScript("arguments[0].click()", incre);
	js.executeScript("arguments[0].click()", incre);
	WebElement  svbtn=driver.findElement(By.xpath("//button[contains(@class,'text-white bg-primarymedium ml-2')]"));
	js.executeScript("arguments[0].click()", svbtn);
	System.out.println("Afternoon Tea added successfully");
	
		
	}
}
