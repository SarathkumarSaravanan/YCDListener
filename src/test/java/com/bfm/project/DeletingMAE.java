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

public class DeletingMAE {
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
	WebElement litlebby=driver.findElement(By.xpath("//h3[text()='1 Lilies Baby']"));
	js.executeScript("arguments[0].click()", litlebby);
	WebElement actvt=	driver.findElement(By.xpath("(//span[text()='Activities'])[1]"));
	js.executeScript("arguments[0].click()", actvt);
	}
	@Test(dependsOnMethods="dailyTask")
	public void mesAddLang() throws InterruptedException
	{
	Thread.sleep(5000);
	WebElement mes=driver.findElement(By.xpath("(//button[contains(@class,'bg-gradient-to-t from-brgrdbtn1 to-brgrdbtn2')])[2]"));	
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", mes);
	WebElement btn=driver.findElement(By.xpath("(//button[contains(@class,'items-center justify-center')])[3]"));
	js.executeScript("arguments[0].click()", btn);
	WebElement lang=driver.findElement(By.xpath("//button[text()='Language']"));
	js.executeScript("arguments[0].click()", lang);
	WebElement slct=driver.findElement(By.xpath("//button[text()='SELECT']"));
	js.executeScript("arguments[0].click()", slct);
	}
	@Test(dependsOnMethods="mesAddLang")
	public void createMAE() throws InterruptedException
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement bocab=driver.findElement(By.xpath("//*[@id=\"gridscroll\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/button"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", bocab);
	Thread.sleep(5000);
	WebElement createMAE=driver.findElement(By.xpath("//button[text()='MAE']"));
	js.executeScript("arguments[0].click()", createMAE);
	Thread.sleep(3000);
	WebElement workingWith=driver.findElement(By.xpath("(//button[contains(@class,'items-center justify-center text-sm')])[2]"));
	js.executeScript("arguments[0].click()", workingWith);
	Thread.sleep(3000);
	WebElement sve=driver.findElement(By.xpath("//span[text()='SAVE']"));
	js.executeScript("arguments[0].click()", sve);
	WebElement close=driver.findElement(By.xpath("//button[contains(@class,'justify-center w-11 h-11 rounded bg-gradient')]"));
	js.executeScript("arguments[0].click()", close);
	Thread.sleep(3000);
	WebElement chld=driver.findElement(By.xpath("(//span[text()='Children'])[1]"));
	js.executeScript("arguments[0].click()", chld);
	Thread.sleep(3000);
	WebElement abby=driver.findElement(By.xpath("//div[text()='Abbey']"));
	js.executeScript("arguments[0].click()", abby);
	Thread.sleep(3000);
	WebElement dot=driver.findElement(By.xpath("//button[contains(@class,'border-oracle600 shadow rounded-sm')]"));
	js.executeScript("arguments[0].click()", dot);
	Thread.sleep(3000);
	WebElement viewprofile=driver.findElement(By.xpath("(//button[text()='View Profile'])[3]"));
	js.executeScript("arguments[0].click()", viewprofile);	
	Thread.sleep(3000);
	WebElement lear=driver.findElement(By.xpath("(//span[text()='Learning'])[1]"));
	js.executeScript("arguments[0].click()", lear);
	Thread.sleep(3000);
	WebElement workwith=driver.findElement(By.xpath("//button[@id='learningWorkWith']"));
	js.executeScript("arguments[0].click()", workwith);
	Thread.sleep(3000);
	WebElement cabinet=driver.findElement(By.xpath("//span[text()='Botany Cabinet']"));
	System.out.println(cabinet.getText()+"MAE Created Successfully");
	Thread.sleep(3000);
	WebElement close1=driver.findElement(By.xpath("//button[contains(@class,'bg-gradient-to-t from-brgrdbtn1 to-brgrdbtn2')]"));
	js.executeScript("arguments[0].click()", close1);
	Thread.sleep(3000);
	WebElement active2=driver.findElement(By.xpath("(//span[text()='Activities'])[1]"));
	js.executeScript("arguments[0].click()", active2);
	Thread.sleep(3000);
	WebElement btnyCab=driver.findElement(By.xpath("//span[text()='Botany Cabinet']"));
	js.executeScript("arguments[0].click()", btnyCab);
	Thread.sleep(3000);
	WebElement iconTimelog=driver.findElement(By.xpath("//button[contains(@class,'items-center justify-center rounded-md h-11 w-11 bg-white')]"));
	js.executeScript("arguments[0].click()", iconTimelog);
	WebElement dltExp=driver.findElement(By.xpath("//span[text()='Delete Experience']"));
	js.executeScript("arguments[0].click()",dltExp);
	WebElement yes=driver.findElement(By.xpath("//button[text()='Yes']"));
	js.executeScript("arguments[0].click()",yes);
	System.out.println("MAE deleted successfully");
	}
	@Test(dependsOnMethods="createMAE")
	public void deleteMAEVeryfy() throws InterruptedException
	{
	Thread.sleep(3000);
	WebElement goto1=driver.findElement(By.xpath("(//button[contains(@class,'h-11 w-11 bg-gradient-to-t from-brgrdbtn1 to-brgrdbtn2 border')])[2]"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", goto1);
	WebElement btn2=driver.findElement(By.xpath("(//button[contains(@class,'items-center justify-center')])[3]"));
	js.executeScript("arguments[0].click()", btn2);
	WebElement lang2=driver.findElement(By.xpath("//button[text()='Language']"));
	js.executeScript("arguments[0].click()", lang2);
	WebElement slct2=driver.findElement(By.xpath("//button[text()='SELECT']"));
	js.executeScript("arguments[0].click()", slct2);
	Thread.sleep(3000);
	WebElement bocab=driver.findElement(By.xpath("//*[@id=\"gridscroll\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/button"));
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", bocab);
	Thread.sleep(3000);
	WebElement close3=driver.findElement(By.xpath("//button[contains(@class,'bg-gradient-to-t from-brgrdbtn1 to-brgrdbtn2')]"));
	js.executeScript("arguments[0].click()", close3);
	WebElement chld1=driver.findElement(By.xpath("(//span[text()='Children'])[1]"));
	js.executeScript("arguments[0].click()", chld1);
	Thread.sleep(3000);
	WebElement abby1=driver.findElement(By.xpath("//div[text()='Abbey']"));
	js.executeScript("arguments[0].click()", abby1);
	Thread.sleep(3000);
	WebElement dot1=driver.findElement(By.xpath("//button[contains(@class,'border-oracle600 shadow rounded-sm')]"));
	js.executeScript("arguments[0].click()", dot1);
	Thread.sleep(3000);
	WebElement viewprofile1=driver.findElement(By.xpath("(//button[text()='View Profile'])[3]"));
	js.executeScript("arguments[0].click()", viewprofile1);	
	Thread.sleep(3000);
	WebElement lear1=driver.findElement(By.xpath("(//span[text()='Learning'])[1]"));
	js.executeScript("arguments[0].click()", lear1);
	Thread.sleep(3000);
	WebElement workwith1=driver.findElement(By.xpath("//button[@id='learningWorkWith']"));
	js.executeScript("arguments[0].click()", workwith1);
	Thread.sleep(3000);
	String validation=driver.findElement(By.xpath("//div[text()='There are no experiences that match the search criteria.']")).getText();
	System.out.println(validation+"Mae Deleted and verified in profile successfully");
	}
	}
