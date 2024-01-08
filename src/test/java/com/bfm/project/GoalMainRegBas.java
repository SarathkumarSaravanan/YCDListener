package com.bfm.project;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.poifs.property.Parent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoalMainRegBas {
	public static WebDriver driver;
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");

	@Test()
	public static void login()
		{
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
	}
	@Test(dependsOnMethods="login")
	public static void goalRegBas() throws InterruptedException
	{
	WebElement cntr=driver.findElement(By.xpath("//a[text()='Centre']"));
	Actions act = new Actions(driver);
	act.moveToElement(cntr).perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement golman=driver.findElement(By.xpath("//a[text()='Goals Maintenance']"));
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", golman);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement rgbased=driver.findElement(By.xpath("//a[text()='Region Based']"));
	js.executeScript("arguments[0].click()", rgbased);
	WebElement adnewgol=driver.findElement(By.xpath("//button[@id='btnKindyAdd']"));
	js.executeScript("arguments[0].click()", adnewgol);
	WebElement txtar=driver.findElement(By.xpath("//textarea[@id='txtkdyMaterial']"));
	txtar.sendKeys("TestingParent"+dt1+"");
	WebElement btn=driver.findElement(By.xpath("//button[@id='btnkdySave']"));
	js.executeScript("arguments[0].click()", btn);
	System.out.println("New Goal Added Successfully");
	WebElement parn=driver.findElement(By.xpath("//span[text()='TestingParent"+dt1+"']"));
	js.executeScript("arguments[0].click()", parn);
	Thread.sleep(5000);
	WebElement txtar1=driver.findElement(By.xpath("//textarea[@id='txtkdyMaterial']"));
	txtar1.clear();
	txtar1.sendKeys("TestingParent123"+dt1+"");
	WebElement svbtn=driver.findElement(By.xpath("//button[@id='btnkdySave']"));
	js.executeScript("arguments[0].click()", svbtn);
	System.out.println("New Goal Updated Successfully");
	WebElement updtprnt=driver.findElement(By.xpath("//span[text()='TestingParent123"+dt1+"']"));
	js.executeScript("arguments[0].click()", updtprnt);
	WebElement arch=driver.findElement(By.xpath("//button[@id='btnArchive']"));
	js.executeScript("arguments[0].click()", arch);
	Thread.sleep(5000);
	WebElement yesbtn=driver.findElement(By.xpath("(//button[@id='Yes'])[2]"));
	js.executeScript("arguments[0].click()", yesbtn);
	System.out.println("Updated Goal Has been Archived successfully");
	Thread.sleep(5000);
	WebElement updtprnt1=driver.findElement(By.xpath("//span[text()='TestingParent123"+dt1+"']"));
	js.executeScript("arguments[0].click()", updtprnt1);
	Thread.sleep(5000);
	WebElement mkac=driver.findElement(By.xpath("//button[text()='Make Active']"));
	js.executeScript("arguments[0].click()", mkac);
	WebElement yes=driver.findElement(By.xpath("(//button[@id='Yes'])[2]"));
	js.executeScript("arguments[0].click()", yes);
	System.out.println("Activated the archived Updated Goal successfully");
	Thread.sleep(5000);
	WebElement adnewgol1=driver.findElement(By.xpath("//button[@id='btnKindyAdd']"));
	js.executeScript("arguments[0].click()", adnewgol1);
	WebElement txtar2=driver.findElement(By.xpath("//textarea[@id='txtkdyMaterial']"));
	txtar2.sendKeys("TestingChild123"+dt1+"");
	WebElement svbtn1=driver.findElement(By.xpath("//button[@id='btnkdySave']"));
	js.executeScript("arguments[0].click()", svbtn1);
	WebElement src=driver.findElement(By.xpath("//span[text()='TestingParent123"+dt1+"']"));
	WebElement dst=driver.findElement(By.xpath("//span[text()='TestingChild123"+dt1+"']"));
	act.dragAndDrop(dst, src).perform();
	WebElement dst1=driver.findElement(By.xpath("//span[text()='TestingChild123"+dt1+"']"));
	js.executeScript("arguments[0].click()", dst1);
	System.out.println("Nesting the child into parent successfully");
	

	}
}
