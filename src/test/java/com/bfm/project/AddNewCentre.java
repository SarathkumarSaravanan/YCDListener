package com.bfm.project;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCentre {
	public static WebDriver driver;
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");
	@Test()
	public void addStaff() throws InterruptedException 
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
	WebElement staff=driver.findElement(By.xpath("//a[text()='Centre']"));
	Actions act= new Actions(driver);
	act.moveToElement(staff).perform();
	WebElement nwchild=driver.findElement(By.xpath("//a[text()='Centre List']"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",nwchild);
	WebElement adnc=driver.findElement(By.xpath("//a[@href='/v1/Centres/0']"));
	js.executeScript("arguments[0].click();",adnc);
	WebElement cname=driver.findElement(By.xpath("//input[@id='Name']"));
	cname.sendKeys("Testingname"+dt1+"");
	WebElement slc=driver.findElement(By.xpath("(//span[contains(@class,'k-dropdownlist k-picker-solid')])[1]"));
	slc.click();
	WebElement slccompany=driver.findElement(By.xpath("//span[text()='Building Futures Pty Ltd']"));
	js.executeScript("arguments[0].click();",slccompany);
	WebElement type=driver.findElement(By.xpath("//span[text()='Select Service Type']"));
	type.click();
	WebElement typeslc=driver.findElement(By.xpath("//span[text()='Family Day Care']"));
	js.executeScript("arguments[0].click();",typeslc);
	WebElement opentime=driver.findElement(By.xpath("//input[@id='openingTime']"));
	opentime.sendKeys("9:00 AM");
	WebElement closetime=driver.findElement(By.xpath("//input[@id='closingTime']"));
	closetime.sendKeys("5:00 PM");
	WebElement phone=driver.findElement(By.xpath("//input[@id='GeneralGenericContact_Phone']"));
	phone.sendKeys("0413123456");
	WebElement mobile=driver.findElement(By.xpath("//input[@id='GeneralGenericContact_Mobile']"));
	mobile.sendKeys("0413895556");
	
	WebElement email=driver.findElement(By.xpath("//input[@id='GeneralGenericContact_Email']"));
	email.sendKeys("Testingsar6"+dt1+"@yopmail.com");
	WebElement btn2=driver.findElement(By.xpath("//button[@class='btn-blue-withicon']"));
	js.executeScript("arguments[0].click();",btn2);	
	WebElement btn3=driver.findElement(By.xpath("(//button[@id='Yes'])[2]"));
	btn3.click();
	
	Thread.sleep(5000);
	for(int k=1;k<=4;k++)
	{
	String data="Testingname054015";  
	WebElement table=driver.findElement(By.xpath("//*[@id=\"CentreGrid\"]"));
	List<WebElement>tablerow=table.findElements(By.tagName("tr"));
	for(int i=1;i<tablerow.size();i++)
	{
	WebElement tdata=table.findElement(By.xpath("/html/body/div[2]/div/main/div[1]/div/div/div/table/tbody/tr["+i+"]/td[1]"));
	if((tdata.getText().contains(data)))
	{
	System.out.println("newcentrecreated successfully");
	break;
	}else if(i==20) {
	WebElement nxtbtn=driver.findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-right']"));
	js.executeScript("arguments[0].click();",nxtbtn);	
				}
}
}
	}
}
	
	
	
