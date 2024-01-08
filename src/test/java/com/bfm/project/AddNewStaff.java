package com.bfm.project;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewStaff {
	public static WebDriver driver;
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");
	@Test()
	public void addStaff() throws IOException, InterruptedException
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
	String actual="My Profile";
	WebElement text=driver.findElement(By.xpath("//h2[@class='page-title']"));
	String expected=text.getText();
	Assert.assertEquals(actual, expected);
	System.out.println("Login suceesfully move to home page");
	WebElement staff=driver.findElement(By.xpath("(//a[@id='hideclass'])[3]"));
	Actions act= new Actions(driver);
	act.moveToElement(staff).perform();
WebElement staflist=driver.findElement(By.xpath("//a[text()='Staff List']"));
staflist.click();
WebElement addnewstaff=driver.findElement(By.xpath("//a[@href='/v1/Staffs/0']"));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", addnewstaff);
WebElement fname=driver.findElement(By.xpath("//input[@id='FirstName']"));
fname.sendKeys("TestingFname"+dt1+"");
WebElement lname=driver.findElement(By.xpath("//input[@id='LastName']"));
lname.sendKeys("TestingLname"+dt1+"");
WebElement cmp=driver.findElement(By.xpath("(//span[contains(@class,'k-picker-solid k-picker-md')])[3]"));
cmp.click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement sltcmp=driver.findElement(By.xpath("//span[text()='Building Futures Pty Ltd']"));
js.executeScript("arguments[0].click();", sltcmp);
WebElement cntre=driver.findElement(By.xpath("(//span[contains(@class,'k-dropdownlist k-picker')])[4]"));
cntre.click();
WebElement aqua=driver.findElement(By.xpath("//li[@role='option']//span[text()='AQUA']"));
js.executeScript("arguments[0].click();", aqua);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement etype=driver.findElement(By.xpath("(//span[contains(@class,'k-dropdownlist k-picker-solid')])[5]"));
etype.click();
WebElement perm=driver.findElement(By.xpath("//span[text()='Full Time']"));
js.executeScript("arguments[0].click();", perm);
WebElement sctleve=driver.findElement(By.xpath("(//span[contains(@class,'dropdownlist k-picker-solid')])[6]"));
sctleve.click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement sltsctleve=driver.findElement(By.xpath("//span[text()='Administration Data Manager']"));
js.executeScript("arguments[0].click();",sltsctleve);
WebElement empposit=driver.findElement(By.xpath("//span[text()='Select Employment Position']"));
empposit.click();
WebElement slcempposti=driver.findElement(By.xpath("//span[text()='Group Leader']"));
js.executeScript("arguments[0].click();",slcempposti);
WebElement currom=driver.findElement(By.xpath("(//span[contains(@class,'k-dropdownlist k-picker-solid')])[8]"));
currom.click();
WebElement sltcurrom=driver.findElement(By.xpath("//span[text()='QA Room 2']"));
js.executeScript("arguments[0].click();",sltcurrom);
WebElement savebtn=driver.findElement(By.xpath("//button[@class='btn-blue-withicon']"));
js.executeScript("arguments[0].click();",savebtn);
WebElement ybtn=driver.findElement(By.xpath("(//button[@id='Yes'])[2]"));
ybtn.click();
WebElement ffilter=driver.findElement(By.xpath("(//a[@class='k-grid-filter'])[2]"));
js.executeScript("arguments[0].click();",ffilter);
WebElement 	cnt=driver.findElement(By.xpath("//input[@class='k-input-inner']"));
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
cnt.sendKeys("TestingFname"+dt1+"");
WebElement fltr=driver.findElement(By.xpath("//button[@title='Filter']"));
fltr.click();
Thread.sleep(5000);
TakesScreenshot tks=(TakesScreenshot)driver;
File src=tks.getScreenshotAs(OutputType.FILE);
File dst=new File("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\ScreenShot\\image"+dt1+".png");
FileHandler.copy(src, dst);
System.out.println("New staff added succesfully Please see the screenshot");

	}

}
